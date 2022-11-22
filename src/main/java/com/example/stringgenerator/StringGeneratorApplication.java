package com.example.stringgenerator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StringGeneratorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StringGeneratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
