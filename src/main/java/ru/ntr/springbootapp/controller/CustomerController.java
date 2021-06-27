package ru.ntr.springbootapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ntr.springbootapp.model.Customer;
import ru.ntr.springbootapp.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    public List<Customer> showProducts() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer showProduct(@PathVariable("id") int id) {
        return customerService.findById(id);
    }

}
