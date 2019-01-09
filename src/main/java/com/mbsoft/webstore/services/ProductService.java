package com.mbsoft.webstore.services;

import com.mbsoft.webstore.entities.Category;
import com.mbsoft.webstore.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface ProductService {

    List<Product>findAll();

    Product getProductById(Long productId);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByManufacturer(String manufacturer);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    List<Product> getProductsByPriceFilter(BigDecimal low, BigDecimal high);

    void addProduct(Product product);


}





















