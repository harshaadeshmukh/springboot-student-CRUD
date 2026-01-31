package com.example.crudoperation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Home {
    public String msg()
    {
        return "Hi";
    }
}
