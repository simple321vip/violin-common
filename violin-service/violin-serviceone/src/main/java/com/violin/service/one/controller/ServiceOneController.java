package com.violin.service.one.controller;

import com.violin.service.one.client.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("one")
public class ServiceOneController {

    @Autowired
    public ServiceClient serviceClient;

    @GetMapping("/hello")
    public String hello() {
        return "hello one, i am serviceone";
    }

    @GetMapping("/hello/two")
    public void hellotwo() {
        serviceClient.test("hello two, iam one");
    }

}
