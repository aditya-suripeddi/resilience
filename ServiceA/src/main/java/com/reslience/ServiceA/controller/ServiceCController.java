package com.reslience.ServiceA.controller;

import com.reslience.ServiceA.clients.EmailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/c")
public class ServiceCController {

    @Autowired
    private EmailClient emailClient;
    private static String BASE_URL = "http://localhost:8081";

    @GetMapping
    public String serviceA() {
        String url = BASE_URL + "/b";
        emailClient.sendEmail(url);
        return " from Service A";
    }


    // the fall back method should:
    //    a. have same return type as annotated method - serviceA()
    //    b. take Exception as argument
    //    c. be defined in same class as annotated method [CHECK]
    public String serviceAFallBack(Exception ex) {
        return " this is fallback method of serviceA" ;
    }
}