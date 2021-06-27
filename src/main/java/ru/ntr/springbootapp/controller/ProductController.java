package ru.ntr.springbootapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.ntr.springbootapp.model.Product;
import ru.ntr.springbootapp.service.ProductService;

import java.util.Date;

@RestController
@RequestMapping("/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public Page<Product> showProducts() {
        return productService.findAll(0);
    }

    @GetMapping("/page/{page}")
    public Page<Product> showProducts(@PathVariable("page") int pageNumber) {
        return productService.findAll(--pageNumber);

    }

    @GetMapping("/{id}")
    public Product showProduct(@PathVariable("id") int id) {
        return productService.findById(id);
    }


    @PostMapping()
    public Product create(@RequestBody Product product) {
        product.getPrice().setDate(new Date());
        return productService.save(product);

    }

    @DeleteMapping("/{id}")
    public int deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return HttpStatus.OK.value();
    }
}
