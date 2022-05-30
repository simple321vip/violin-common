package com.violin.service.two.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("two")
public class TwoController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello , iam 2";
    }

    @GetMapping(value = "/hello/one")
    public void helloOne(@RequestParam(value = "test") String test){
        System.out.println(test);
    }



}
