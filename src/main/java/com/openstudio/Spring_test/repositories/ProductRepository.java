package com.openstudio.Spring_test.repositories;

import com.openstudio.Spring_test.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Хлебушек", 29));
        products.add(new Product(2, "Молочко", 35));
        products.add(new Product(3, "Сосисочки", 219));
        products.add(new Product(4, "Какао", 85));
    }

    public void deleteProductByID(long id) {
        for (int i = 0 ; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                return;
            }
        }
    }
}
