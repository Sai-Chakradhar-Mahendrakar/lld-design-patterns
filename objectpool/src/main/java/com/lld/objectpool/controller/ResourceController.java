package com.lld.objectpool.controller;

import com.lld.objectpool.service.ResourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resource")
public class ResourceController {
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/use")
    public String use(@RequestParam String input) {
        return resourceService.useResource(input);
    }

    @GetMapping("/status")
    public int status() {
        return resourceService.poolStatus();
    }
}
