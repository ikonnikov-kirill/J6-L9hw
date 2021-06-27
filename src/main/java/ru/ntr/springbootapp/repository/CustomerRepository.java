package ru.ntr.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ntr.springbootapp.model.Customer;
import ru.ntr.springbootapp.model.Product;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAll();

    Customer findById(int id);

}
