package com.violin.service.one.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("servicetwo")
public interface ServiceClient {

    @GetMapping
    void test(@RequestParam(value = "test") String test);
}
