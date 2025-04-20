package com.umutyenidil.springreactiveprogramming;

import com.github.javafaker.Faker;
import com.umutyenidil.springreactiveprogramming.student.Student;
import com.umutyenidil.springreactiveprogramming.student.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringReactiveProgrammingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringReactiveProgrammingApplication.class, args);
    }


    public CommandLineRunner commandLineRunner(
            StudentService studentService
    ) {
        var faker = new Faker();
        return args -> {
            for (int i = 0; i < 100; i++) {
              studentService.save(
                      Student.builder()
                              .firstName(faker.name().firstName())
                              .lastName(faker.name().lastName())
                              .age(faker.number().numberBetween(1, 100))
                              .build()
              ).subscribe();
            }
        };
    }
}
