package com.mbsoft.webstore.services;

import com.mbsoft.webstore.entities.Product;
import com.mbsoft.webstore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductDatabaseServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        Iterable<Product> products = productRepository.findAll();
        return StreamSupport.stream(products.spliterator(), true)
                .collect(Collectors.toList());
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isPresent()){
            Product productById = productOptional.get();
            return productById;
        }
        throw new IllegalArgumentException("Produktu o wskazanym id: " + productId + " nie ma w bazie");
    }


}
