package com.example.learnspring.implemantations;

import com.example.learnspring.services.HelloSpringService;
import org.springframework.stereotype.Component;

@Component
public class HelloSpringImp implements HelloSpringService {

    @Override
    public void sayHello() {
        System.out.println("Hello Spring :)");
    }
}
