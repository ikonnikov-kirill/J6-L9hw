package ru.ntr.springbootapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ntr.springbootapp.model.Product;
import ru.ntr.springbootapp.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final int MAX_ITEMS_PER_PAGE = 10;

    @Override
    public Page<Product> findAll(int pageNumber) {
        Pageable page =  PageRequest.of(pageNumber, MAX_ITEMS_PER_PAGE, Sort.by("name"));
        return productRepository.findAll(page);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
         return productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }


}
