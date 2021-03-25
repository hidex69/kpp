package com.example.restservice;

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


}
