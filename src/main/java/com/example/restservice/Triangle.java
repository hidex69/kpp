package com.example.restservice;

import org.springframework.stereotype.Component;

import java.util.Objects;

public class Triangle {
    private final double area;
    private final double perimeter;

    private final double firstSide, secondSide, thirdSide;

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }


    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;

        this.perimeter = firstSide + secondSide + thirdSide;
        double semiPerimeter = perimeter / 2;
        this.area = Math.sqrt(semiPerimeter * (semiPerimeter - firstSide) *
                (semiPerimeter - secondSide) * (semiPerimeter - thirdSide));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.area, area) == 0
                && Double.compare(triangle.perimeter, perimeter) == 0
                && Double.compare(triangle.firstSide, firstSide) == 0
                && Double.compare(triangle.secondSide, secondSide) == 0
                && Double.compare(triangle.thirdSide, thirdSide) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, perimeter, firstSide, secondSide, thirdSide);
    }
}
