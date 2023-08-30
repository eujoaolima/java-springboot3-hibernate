package com.cursospringhibernate.CursoSpringHibernate.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String workout() { return "Run a hard 5k!";}
    @GetMapping("/fortune")
    public String getDailyFortune() { return "Today is your lucky day!";}
}
