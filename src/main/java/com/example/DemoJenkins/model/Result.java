package com.example.DemoJenkins.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Result")
public class Result {


    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
