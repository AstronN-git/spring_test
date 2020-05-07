package com.openstudio.Spring_test.services;

import com.openstudio.Spring_test.entities.Product;
import com.openstudio.Spring_test.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductByID(long id) {
        return productRepository.getProducts().get((int)id-1);

    }

    public List<Product> getAllProducts() {
        return productRepository.getProducts();
    }

    public void deleteProductByID(long id) {
        productRepository.deleteProductByID(id);
    }
}
