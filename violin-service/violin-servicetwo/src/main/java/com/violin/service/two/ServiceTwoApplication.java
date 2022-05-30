package com.violin.service.two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceTwoApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ServiceTwoApplication.class, args);
    }
}
