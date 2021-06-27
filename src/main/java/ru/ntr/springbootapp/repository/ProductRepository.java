package ru.ntr.springbootapp.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.ntr.springbootapp.model.Product;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();

    List<Product> findAll(Sort sort);

    Product findById(int id);

    void deleteById(Integer integer);

    Product save(Product product);


}
