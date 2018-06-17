package com.example.billboard;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillboardController {

    @Value("${message:value was not read from config server}")
    private String message;

    @GetMapping("/")
    public String greet()
    {
        return message;
    }
}
