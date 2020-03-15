package edu.miu.cs.cs544.lab01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.lab01.domain.Fortune;
import edu.miu.cs.cs544.lab01.service.FortuneService;

@RestController
public class FortuneController {

    @Autowired
    private FortuneService fortuneService;

    @GetMapping
    public Fortune getFortune() {
        return fortuneService.getFortune();
    }

}
