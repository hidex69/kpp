package com.example.restservice;

import com.example.restservice.dataHandler.DataAccessService;
import com.example.restservice.dataHandler.RequestArray;
import com.example.restservice.exceptions.ExceptionBody;
import com.example.restservice.exceptions.InputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TriangleController {

    Logger logger = LoggerFactory.getLogger(TriangleController.class);

    @Autowired
    DataAccessService service = new DataAccessService();


    @GetMapping("/triangle")
    public Triangle triangle(@RequestParam(value = "1") int firstSide,
                             @RequestParam(value = "2") int secondSide,
                             @RequestParam(value = "3") int thirdSide) {

        RequestArray requestArray = new RequestArray(firstSide, secondSide, thirdSide);


        if(firstSide < 0 || secondSide < 0 || thirdSide < 0) {
            logger.warn("Invalid request params");
            throw new InputException("Invalid request params");
        } else if(service.checkIfAlreadyExist(requestArray)) {
            logger.info("Get from cache");
            return service.getFromCache(requestArray);
        } else {
            service.addToCache(requestArray, new Triangle(firstSide, secondSide, thirdSide));
            logger.info("Add to cache");
            return service.getFromCache(requestArray);
        }
    }


    @ExceptionHandler(InputException.class)
    public ExceptionBody handleException(InputException e) {
        return new ExceptionBody("Invalid params");
    }
}
