package edu.miu.cs.cs544.lab01.service;

import java.util.Random;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.miu.cs.cs544.lab01.domain.Fortune;

@Service
public class FortuneServiceClient implements FortuneService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Fortune getFortune() {
        return restTemplate.getForObject("http://fortune/",
                Fortune.class);
    }

}
