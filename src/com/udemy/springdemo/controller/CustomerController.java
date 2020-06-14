package com.udemy.springdemo.controller;

import com.udemy.springdemo.entity.Customer;
import com.udemy.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject the customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("list")
    public String listCustomers(Model model) {

        // get customers from the service
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        model.addAttribute("customer", theCustomers);
        return "list-customers";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer theCustomer = new Customer();
        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {

        final Customer theCustomer = customerService.getCustomer(id);

        model.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        System.out.println("gooing");
        customerService.deleteCustomer(theId);
        System.out.println("doing");
        return "redirect:/customer/list";
    }
}