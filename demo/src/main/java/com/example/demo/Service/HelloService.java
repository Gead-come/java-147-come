package com.example.demo.Service;

import org.springframework.stereotype.Service;

// 1. 让Spring管理这个类

@Service
public class HelloService {
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}
