package com.example.demo.student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
            return args -> {
                Student julian = new Student(
                        "Julian",
                        "jgaston001@my.wilmu.edu",
                        LocalDate.of(2002, Month.MARCH, 13)
                );

                Student jack = new Student(
                        "Jack",
                        "jackie@my.wilmu.edu",
                        LocalDate.of(1900, Month.JANUARY, 5)
                );

                Student igor = new Student(
                        "Igor",
                        "Igor@CareFirst.elevate.com",
                        LocalDate.of(1995, Month.JANUARY, 5)
                );

                repository.saveAll(
                        List.of(igor, jack, julian)
                );
            };
    }
}
