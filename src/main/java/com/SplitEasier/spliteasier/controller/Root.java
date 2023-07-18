package com.SplitEasier.spliteasier.controller;

import com.SplitEasier.spliteasier.splitwise.SplitwiseAPI;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Root {
   private SplitwiseAPI splitwiseAPI;

   private ApplicationContext applicationContext;
   public Root(SplitwiseAPI splitwiseAPI, ApplicationContext applicationContext) {
        this.splitwiseAPI = splitwiseAPI;
        this.applicationContext = applicationContext;
   }
   @GetMapping("/")
   public String index(){
        return "root";
    }
}
