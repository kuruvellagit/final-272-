package com.enterprise.world_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {
    @GetMapping("/world")
    public String worldMessage()
    {
      return  "World";
    }
}
