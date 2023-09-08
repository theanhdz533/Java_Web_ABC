package com.example.spring_web_music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringWebMusicApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {

        SpringApplication.run(SpringWebMusicApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        String sql = "INSERT INTO artists(name, image) VALUES (\"abc\",\"ab\") ";
      

//        int result = jdbcTemplate.update(sql, "charmy","hi");
//
//        if(result > 0) {
//            System.out.println("Updated");
//        }
    }
}
