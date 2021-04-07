package com.example.restservice.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CounterService {
    private AtomicInteger counter = new AtomicInteger(0);

    public void inc() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }
}
