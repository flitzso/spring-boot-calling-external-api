package com.springboot.springbootcallingexternalapi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class RestSpringBootController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    //Funciona tudo
    @GetMapping(value = "/callclienthello")
    private String getHelloClient() {
        String url = "http://localhost:8080/hello";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
    //Nao funciona
    @GetMapping(value = "/countries")
    public List<Object> getCountries() {
        String url = "https://restcountries.eu/rest/v2/all";
        RestTemplate restTemplate = new RestTemplate();

        Object[] countries = restTemplate.getForObject(url, Object[].class);

        return Arrays.asList(countries);
    }

}
