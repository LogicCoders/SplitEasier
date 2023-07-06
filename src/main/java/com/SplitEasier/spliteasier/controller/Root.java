package com.SplitEasier.spliteasier.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Root {
   @GetMapping("/")
   public String index() {
        return "root";
    }
}
