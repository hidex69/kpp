package com.example.restservice.dao;

import com.example.restservice.model.RequestResult;
import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<RequestResult, Integer> {
}
