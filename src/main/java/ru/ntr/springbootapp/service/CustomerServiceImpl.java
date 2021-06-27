package ru.ntr.springbootapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ntr.springbootapp.model.Customer;
import ru.ntr.springbootapp.repository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }
}
