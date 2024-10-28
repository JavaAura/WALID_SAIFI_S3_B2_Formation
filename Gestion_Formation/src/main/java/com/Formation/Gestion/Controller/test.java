package com.Formation.Gestion.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test{

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, YouCode!";
    }
}
