package com.system.online.inventory.management.system.service;

import com.system.online.inventory.management.system.model.Product;
import com.system.online.inventory.management.system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product saveProducts(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product editProduct(Integer proId) {
        return productRepository.findById(proId).get();
    }

    public void deleteProducts(Integer proId) {
        productRepository.deleteById(proId);
    }
}
