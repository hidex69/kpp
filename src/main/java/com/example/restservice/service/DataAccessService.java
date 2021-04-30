package com.example.restservice.service;

import com.example.restservice.model.RequestResult;
import com.example.restservice.dataHandler.RequestArray;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataAccessService {
    private Map <RequestArray, RequestResult> map = new HashMap<>();

    public DataAccessService() {}

    public boolean checkIfAlreadyExist(List<RequestResult> results, RequestResult result) {
        return results.contains(result);
    }

    public void addToCache(RequestArray requestArray, RequestResult result) {
        map.put(requestArray, result);
    }

    public RequestResult getFromCache(List<RequestResult> results, RequestResult result) {
        return results.stream().filter(n -> n.equals(result)).findFirst().get();
    }

    public Collection<RequestResult> getFromCache() {
        return map.values();
    }

}
