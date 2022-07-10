package com.example.momorecorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class MomoRecorderApplication {
	public static void main(String[] args) {
		SpringApplication.run(MomoRecorderApplication.class, args);
	}
}
