package com.example.restservice.service;

import com.example.restservice.model.RequestAvgModel;
import com.example.restservice.model.RequestResult;
import com.example.restservice.model.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class TriangleService {
    public static double perimeter(Triangle triangle) {
        return triangle.getFirstSide() + triangle.getSecondSide() + triangle.getThirdSide();
    }

    public static double area(Triangle triangle) {
        double semiPerimeter = perimeter(triangle) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - triangle.getFirstSide()) *
                (semiPerimeter - triangle.getSecondSide()) * (semiPerimeter - triangle.getThirdSide()));
    }

    private static OptionalDouble avg(Triangle triangle) {
        List<Double> sides = new ArrayList<>(Arrays.asList(triangle.getFirstSide(), triangle.getSecondSide(),
                triangle.getThirdSide()));

        return sides.stream().mapToDouble(Double::doubleValue).average();
    }

    private static OptionalDouble max(Triangle triangle) {
        List<Double> sides = new ArrayList<>(Arrays.asList(triangle.getFirstSide(), triangle.getSecondSide(),
                triangle.getThirdSide()));

        return sides.stream().mapToDouble(Double::doubleValue).max();
    }

    private static OptionalDouble min(Triangle triangle) {
        List<Double> sides = new ArrayList<>(Arrays.asList(triangle.getFirstSide(), triangle.getSecondSide(),
                triangle.getThirdSide()));

        return sides.stream().mapToDouble(Double::doubleValue).min();
    }

    public static RequestAvgModel result(Triangle triangle) {
        return new RequestAvgModel(new RequestResult(area(triangle), perimeter(triangle)), avg(triangle), max(triangle),
                min(triangle));
    }



}
