package com.example.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaclientApplication {


    @Autowired
    private RestTemplate restTemplate;


    public static void main(String[] args) {
        SpringApplication.run(EurekaclientApplication.class, args);
    }


    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "test "+name+",eureka service:" +port;
    }



    @RequestMapping("/service")
    public String service(@RequestParam String name) {
        String forObject = restTemplate.getForObject("http://service-test/test", String.class);
        return forObject+"rr";
    }

}
