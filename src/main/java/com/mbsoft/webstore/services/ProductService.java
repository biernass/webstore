package com.mbsoft.webstore.services;

import com.mbsoft.webstore.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product>findAll();

    Product getProductById(Long productId);
}
