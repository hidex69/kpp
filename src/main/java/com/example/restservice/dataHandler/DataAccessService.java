package com.example.restservice.dataHandler;

import com.example.restservice.Triangle;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataAccessService {
    private Map <RequestArray, Triangle> map = new HashMap<>();

    public DataAccessService() {}

    public boolean checkIfAlreadyExist(RequestArray requestArray) {
        return map.containsKey(requestArray);
    }

    public void addToCache(RequestArray requestArray, Triangle triangle) {
        map.put(requestArray, triangle);
    }

    public Triangle getFromCache(RequestArray requestArray) {
        return map.get(requestArray);
    }

}
