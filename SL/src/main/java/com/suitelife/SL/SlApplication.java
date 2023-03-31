package com.suitelife.SL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.suitelife")
/*
 * Component scan is given the base packages to look for
 * all the java code in the project. They should be in the
 * com.(WhateverYouNamedIt)
 */
public class SlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlApplication.class, args);
	}

}
// comment