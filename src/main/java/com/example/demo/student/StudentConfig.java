//package com.example.demo.student;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//import static java.time.Month.*;
//
//@Configuration
//public class StudentConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository ){
//        return args -> {
//            Student krat = new Student(
//                    "Krat",
//                    LocalDate.of(1998, APRIL, 23),
//                    "krat.test@gmail.com"
//            );
//            Student anuj = new Student(
//                    "Anuj",
//                    LocalDate.of(1999, OCTOBER, 15),
//                    "anuj.test@gmail.com"
//            );
//
//            Student yesh = new Student(
//                    "Yesh",
//                    LocalDate.of(2000, APRIL, 10),
//                    "yesh.test@gmail.com"
//            );
//
//            repository.saveAll(
//                    List.of(krat,anuj,yesh)
//            );
//        };
//    }
//}
