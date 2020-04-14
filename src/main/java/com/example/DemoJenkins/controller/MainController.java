package com.example.DemoJenkins.controller;

import com.example.DemoJenkins.model.Result;
import com.example.DemoJenkins.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    ResultRepository resultRepository;
    @RequestMapping("/")
    public Iterable<Result> showWWelcome() {
        return resultRepository.findAll();
    }

}
