package com.mbsoft.webstore.services;

import com.mbsoft.webstore.entities.Product;
import com.mbsoft.webstore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void processOrder(Long productId, int count) {
        Optional<Product> productById = productRepository.findById(productId);
        if (productById.isPresent()) {
            if (productById.get().getUnitsInStock() < count) {
                throw new IllegalArgumentException("Zbyt mało towaru. Obecna liczba sztuk w magazynie: " +
                        productById.get().getUnitsInStock());
            }
            productById.get().setUnitsInStock(productById.get().getUnitsInStock() - count);
            productRepository.save(productById.get());
        }
        throw new IllegalArgumentException("Towar o id: " + productById + " nie istnieje");
    }
}
