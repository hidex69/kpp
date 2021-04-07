package com.example.restservice.model;

import java.util.Objects;

public class RequestResult {
    private final double area;
    private final double perimeter;

    public RequestResult(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestResult that = (RequestResult) o;
        return Double.compare(that.area, area) == 0 && Double.compare(that.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, perimeter);
    }
}
