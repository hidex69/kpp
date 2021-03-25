package com.example.restservice;

import com.example.restservice.exceptions.InputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriangleController {

    Logger logger = LoggerFactory.getLogger(TriangleController.class);

    @GetMapping("/triangle")
    public Triangle triangle(@RequestParam(value = "1") int firstSide,
                             @RequestParam(value = "2") int secondSide,
                             @RequestParam(value = "3") int thirdSide) {

        if(firstSide < 0 || secondSide < 0 || thirdSide < 0) {
            logger.warn("Invalid request params");
            throw new InputException();
        }
        logger.info("New triangle with sides " + firstSide + " " + secondSide + " " + thirdSide);
        return new Triangle(firstSide, secondSide, thirdSide);
    }
}
