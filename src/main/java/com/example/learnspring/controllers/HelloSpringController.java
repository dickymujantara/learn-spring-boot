package com.example.learnspring.controllers;

import com.example.learnspring.services.HelloSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloSpringController {

    private HelloSpringService helloSpringService;

    @Autowired
    public HelloSpringController(HelloSpringService helloSpringService) {
        this.helloSpringService = helloSpringService;
    }

    public void getMessage(){
        helloSpringService.sayHello();
    }

}
