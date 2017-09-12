package com.intralacos.service.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/")
public class HelloWorld {

    @GetMapping
    public @ResponseBody String helloWorld(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
        String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");

        byte[] requestBody = requestEntity.getBody();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");

        return new String("Hello World");
    }
}
