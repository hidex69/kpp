package com.example.restservice.controller;

import com.example.restservice.dao.ResultRepository;
import com.example.restservice.model.RequestAvgModel;
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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TriangleController {

    Logger logger = LoggerFactory.getLogger(TriangleController.class);

    @Autowired
    DataAccessService service;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    CounterService counterService;


    @GetMapping("/triangle")
    public RequestResult triangle(@RequestParam int firstSide,
                                  @RequestParam int secondSide,
                                  @RequestParam int thirdSide) {

        RequestArray requestArray = new RequestArray(firstSide, secondSide, thirdSide);

        Iterable<RequestResult> results = resultRepository.findAll();
        List<RequestResult> resultList = new ArrayList<>();
        results.forEach(resultList::add);

        Triangle triangle = new Triangle(firstSide, secondSide, thirdSide);
        counterService.inc();

        RequestResult requestResult = new RequestResult(TriangleService.area(triangle),
                TriangleService.perimeter(triangle));

        if(firstSide < 0 || secondSide < 0 || thirdSide < 0) {
            logger.warn("Invalid request params");
            throw new InputException("Invalid request params");
        } else if(service.checkIfAlreadyExist(resultList, requestResult)) {
            logger.info("Get from cache");
            return service.getFromCache(resultList, requestResult);
        } else {
            resultRepository.save(requestResult);
            logger.info("Add to cache");
            return requestResult;
        }
    }

    @GetMapping("/counter")
    public int getCounter() {
        return counterService.getCounter();
    }

    @GetMapping("/triangles")
    public Iterable<RequestResult> getTriangles() {

        return resultRepository.findAll();
    }

    @PostMapping("/triangle")
    public void triangleArray(@RequestBody List<Triangle> triangleList) {
        triangleList.forEach(t -> {
            if (t.getFirstSide() <= 0 || t.getSecondSide() <= 0
            || t.getThirdSide() <= 0) {
                throw new InputException("Invalid request params");
            }
        });
        triangleList.forEach(t -> resultRepository.save(new RequestResult(TriangleService.area(t),
                TriangleService.perimeter(t))));
//        return triangleList.stream().map(TriangleService::result).collect(Collectors.toList());
    }

    @ExceptionHandler(InputException.class)
    public ExceptionBody handleException(InputException e) {
        return new ExceptionBody("Invalid params");
    }
}
