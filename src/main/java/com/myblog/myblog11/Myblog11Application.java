package com.myblog.myblog11;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class Myblog11Application {

	@Bean
	// ModelMapper is a 3rd party java library and IOC doesn't have any info about which object to create. so modelmapper is configured separately
	// @bean annotation helps/educates spring IOC which object to create
	public ModelMapper modelMapper(){

		return new ModelMapper();

	}

	public static void main(String[] args) {
		SpringApplication.run(Myblog11Application.class, args);
	}



}
