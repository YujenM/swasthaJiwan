package com.swasthajiwan.swasthajiwan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RestController
public class test {
    @GetMapping("/test")
    public Map<String, String> checkApi() {
        return Collections.singletonMap("message", "Api ");
    }
}
