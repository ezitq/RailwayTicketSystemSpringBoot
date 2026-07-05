package com.bohdan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {



    @GetMapping("/")
    public String showDashboard(){

        return "main-dashboard";
    }

    @GetMapping("/checkout")
    public String showRoutesInfo(){

        return "route_overview";
    }

    @GetMapping("/book-seat")
    public String showSeats(){

        return "seat_overview";
    }




}
