package com.techknowsurfer.singletonsamples;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SingletonSamplesApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SingletonSamplesApplication.class,args);
	}
}
