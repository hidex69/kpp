package com.example.restservice.service;

import com.example.restservice.model.RequestResult;
import com.example.restservice.model.Triangle;

public class TriangleService {
    public static double perimeter(Triangle triangle) {
        return triangle.getFirstSide() + triangle.getSecondSide() + triangle.getThirdSide();
    }

    public static double area(Triangle triangle) {
        double semiPerimeter = perimeter(triangle) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - triangle.getFirstSide()) *
                (semiPerimeter - triangle.getSecondSide()) * (semiPerimeter - triangle.getThirdSide()));
    }

    public static RequestResult result(Triangle triangle) {
        return new RequestResult(TriangleService.area(triangle), TriangleService.perimeter(triangle));
    }


}
