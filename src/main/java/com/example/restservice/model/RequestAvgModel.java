package com.example.restservice.model;

import java.util.OptionalDouble;

public class RequestAvgModel {
    private RequestResult requestResult;
    private OptionalDouble avg;
    private OptionalDouble max;
    private OptionalDouble min;

    public RequestAvgModel(RequestResult requestResult, OptionalDouble avg, OptionalDouble max, OptionalDouble min) {
        this.requestResult = requestResult;
        this.avg = avg;
        this.max = max;
        this.min = min;
    }

    public RequestResult getRequestResult() {
        return requestResult;
    }

    public OptionalDouble getAvg() {
        return avg;
    }

    public OptionalDouble getMax() {
        return max;
    }

    public OptionalDouble getMin() {
        return min;
    }
}
