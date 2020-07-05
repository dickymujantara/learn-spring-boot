package com.example.learnspring;

import com.example.learnspring.controllers.HelloSpringController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LearnspringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LearnspringApplication.class, args);
		HelloSpringController helloSpringController = (HelloSpringController) context.getBean("helloSpringController");
		helloSpringController.getMessage();
	}

}