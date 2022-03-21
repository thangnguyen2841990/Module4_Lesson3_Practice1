package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    ICustomerService customerService;
    @GetMapping
    private ModelAndView showAllCustomer(){
        List<Customer> customers = this.customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
    @GetMapping("/create")
    private ModelAndView showFormCreat(){
        ModelAndView modelAndView = new ModelAndView("create");
        Customer customer = new Customer();
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    private ModelAndView showFormEdit(@PathVariable int id){
        Customer customer = this.customerService.findCustomerById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    private ModelAndView showFormDelete(@PathVariable int id){
        Customer customer = this.customerService.findCustomerById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    private ModelAndView showCustomerDetail(@PathVariable int id){
        Customer customer = this.customerService.findCustomerById(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    private ModelAndView editCustomer(@PathVariable int id, @ModelAttribute Customer customer){
        this.customerService.update(id,customer);
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        return modelAndView;
    }
    @PostMapping("/delete/{id}")
    private ModelAndView deleteCustomer(@PathVariable int id){
        this.customerService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        return modelAndView;
    }
    @PostMapping("/create")
    private ModelAndView createNewCustomer(@ModelAttribute Customer customer){
        this.customerService.create(customer);
        ModelAndView modelAndView = new ModelAndView("redirect:/customers");
        return modelAndView;
    }
}
