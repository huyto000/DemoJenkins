package com.example.DemoJenkins.repository;

import com.example.DemoJenkins.model.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends CrudRepository<Result, String> {
}
