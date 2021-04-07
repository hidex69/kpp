package com.example.restservice.service;

import com.example.restservice.model.RequestResult;
import com.example.restservice.dataHandler.RequestArray;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataAccessService {
    private Map <RequestArray, RequestResult> map = new HashMap<>();

    public DataAccessService() {}

    public boolean checkIfAlreadyExist(RequestArray requestArray) {
        return map.containsKey(requestArray);
    }

    public void addToCache(RequestArray requestArray, RequestResult result) {
        map.put(requestArray, result);
    }

    public RequestResult getFromCache(RequestArray requestArray) {
        return map.get(requestArray);
    }

    public Collection<RequestResult> getFromCache() {
        return map.values();
    }

}
