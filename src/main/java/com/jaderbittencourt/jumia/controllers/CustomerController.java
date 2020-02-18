package com.jaderbittencourt.jumia.controllers;

import com.jaderbittencourt.jumia.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String getAll(@RequestParam(required = false, defaultValue = "") final String countrySearch,
                         @RequestParam(required = false, defaultValue = "") final String stateSearch, Model model) {
        model.addAttribute("countrySearch", countrySearch);
        model.addAttribute("stateSearch", stateSearch);
        model.addAttribute("customers", customerService.searchCustomers(countrySearch, stateSearch));
        return "index.html";
    }
}
