package com.example.restservice.controller;

import com.example.restservice.model.RequestResult;
import com.example.restservice.model.Triangle;
import com.example.restservice.service.DataAccessService;
import com.example.restservice.dataHandler.RequestArray;
import com.example.restservice.exceptions.ExceptionBody;
import com.example.restservice.exceptions.InputException;
import com.example.restservice.service.CounterService;
import com.example.restservice.service.TriangleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TriangleController {

    Logger logger = LoggerFactory.getLogger(TriangleController.class);

    @Autowired
    DataAccessService service = new DataAccessService();

    @Autowired
    CounterService counterService = new CounterService();


    @GetMapping("/triangle")
    public RequestResult triangle(@RequestParam(value = "1") int firstSide,
                                  @RequestParam(value = "2") int secondSide,
                                  @RequestParam(value = "3") int thirdSide) {

        RequestArray requestArray = new RequestArray(firstSide, secondSide, thirdSide);
        Triangle triangle = new Triangle(firstSide, secondSide, thirdSide);
        counterService.inc();


        if(firstSide < 0 || secondSide < 0 || thirdSide < 0) {
            logger.warn("Invalid request params");
            throw new InputException("Invalid request params");
        } else if(service.checkIfAlreadyExist(requestArray)) {
            logger.info("Get from cache");
            return service.getFromCache(requestArray);
        } else {
            service.addToCache(requestArray, new RequestResult(TriangleService.area(triangle),
                    TriangleService.perimeter(triangle)));
            logger.info("Add to cache");
            return service.getFromCache(requestArray);
        }
    }

    @GetMapping("/counter")
    public int getCounter() {
        return counterService.getCounter();
    }

    @GetMapping("/triangles")
    public Collection<RequestResult> getTriangles() {
        return service.getFromCache();
    }

    @PostMapping("/triangle")
    public List<RequestResult> triangleArray(@RequestBody List<Triangle> triangleList) {
        counterService.inc();
        return triangleList.stream().map(TriangleService::result).collect(Collectors.toList());
    }

    @ExceptionHandler(InputException.class)
    public ExceptionBody handleException(InputException e) {
        return new ExceptionBody("Invalid params");
    }
}
