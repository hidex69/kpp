package com.example.restservice.dataHandler;

import java.util.Objects;

public class RequestArray {
    private double firsParam, secondParam, thirdParam;

    public RequestArray(double firsParam, double secondParam, double thirdParam) {
        this.firsParam = firsParam;
        this.secondParam = secondParam;
        this.thirdParam = thirdParam;
    }

    public double getFirsParam() {
        return firsParam;
    }

    public double getSecondParam() {
        return secondParam;
    }

    public double getThirdParam() {
        return thirdParam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestArray that = (RequestArray) o;
        return Double.compare(that.firsParam, firsParam) == 0 && Double.compare(that.secondParam, secondParam) == 0 && Double.compare(that.thirdParam, thirdParam) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firsParam, secondParam, thirdParam);
    }
}
