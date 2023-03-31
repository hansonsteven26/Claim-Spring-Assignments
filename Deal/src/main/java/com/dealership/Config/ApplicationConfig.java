package com.dealership.Config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration

@EntityScan(basePackages = "com.dealership.Entity")

@EnableJpaRepositories(basePackages = "com.dealership.Repo")

public class ApplicationConfig {
    
}
