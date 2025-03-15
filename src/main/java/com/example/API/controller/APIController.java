package com.example.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.API.service.APIService;
import com.razorpay.RazorpayException;

@Controller
public class APIController {

    @Autowired
    private APIService service;

    @GetMapping("/prime")
    public String prime(ModelMap map) throws RazorpayException {
        return service.prime(map);
    }
}
