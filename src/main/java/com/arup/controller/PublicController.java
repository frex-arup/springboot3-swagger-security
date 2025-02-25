package com.arup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/public")
public class PublicController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello %s".formatted(name);
    }
}
