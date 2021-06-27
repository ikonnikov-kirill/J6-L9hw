package ru.ntr.springbootapp.service;

import ru.ntr.springbootapp.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(int id);

}
