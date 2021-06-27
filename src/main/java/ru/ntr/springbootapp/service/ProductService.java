package ru.ntr.springbootapp.service;

import org.springframework.data.domain.Page;
import ru.ntr.springbootapp.model.Product;

public interface ProductService {

    Page<Product> findAll(int pageNumber);

    Product findById(int id);

    Product save(Product product);

    void delete(int id);
}
