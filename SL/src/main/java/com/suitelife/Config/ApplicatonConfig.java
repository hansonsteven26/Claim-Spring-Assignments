package com.suitelife.Config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Enable your project to use config annotations to help configure stuff
@Configuration
// You must give the base package of your entity folder, then spring
// will be able to scan and make beans of them
// Won't be able to push stuff to database otherwise
@EntityScan(basePackages = "com.suitelife.Entity")

// Enables your spring project to scan for your repo's
// you give the base packages of where all your repo's live
// it will allow spring to make beans of them
// SPRING BEANS, MY GUY
@EnableJpaRepositories(basePackages = "com.suitelife.Repo")
public class ApplicatonConfig {
    
}
