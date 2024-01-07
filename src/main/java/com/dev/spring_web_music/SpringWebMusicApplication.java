package com.dev.spring_web_music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringWebMusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebMusicApplication.class, args);
    }
}
