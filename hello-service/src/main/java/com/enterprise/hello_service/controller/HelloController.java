package com.enterprise.hello_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;
//    @GetMapping("/hello-world")
//    public String helloWorldMessage() {
//        String worldMessage = restTemplate.getForObject("http://world-service:8082/world", String.class);
//        return "Hello " + worldMessage;
//    }
    @GetMapping("/hello")
    public String helloMessage()
    {

        return "Hello " ;
    }

    @GetMapping("/hello-world")
    public String helloWorldMessage() {
        String worldMessage = null;
        int retries = 5;
        while (retries-- > 0) {
            try {
                worldMessage = restTemplate.getForObject("http://world-service:8082/world", String.class);
                break;
            } catch (ResourceAccessException e) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        if (worldMessage == null) {
            throw new RuntimeException("Failed to retrieve world message after retries");
        }
        return "Hello " + worldMessage;
    }
}
