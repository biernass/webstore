package com.mbsoft.webstore.services;

import com.mbsoft.webstore.entities.Category;
import com.mbsoft.webstore.entities.Manufacturer;
import com.mbsoft.webstore.entities.Product;
import com.mbsoft.webstore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductDatabaseServiceImpl implements ProductService {

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
        if (productOptional.isPresent()) {
            Product productById = productOptional.get();
            return productById;
        }
        throw new IllegalArgumentException("Produktu o wskazanym id: " + productId + " nie ma w bazie");
    }

    @Override
    public List<Product> getProductsByCategory(String productCategory) {
        Category productCategoryAsEnum = Category.valueOf(productCategory.toUpperCase());
        Iterable<Product> productIterable = productRepository.findProductsByCategory(productCategoryAsEnum);

        List<Product> productList = StreamSupport.stream(productIterable.spliterator(), true)
                .collect(Collectors.toList());

        if (productList.size() == 0) {
            throw new IllegalArgumentException("Nie znaleziono przedmiotów z tej kategorii: " + productCategory);
        }
        return productList;
    }

    @Override
    public List<Product> getProductsByManufacturer(String productManufacturer) {
        Manufacturer productManufacturerAsEnum = Manufacturer.valueOf(productManufacturer.toUpperCase());
        Iterable<Product> productIterable = productRepository.findProductsByManufacturer(productManufacturerAsEnum);

        List<Product> productList = StreamSupport.stream(productIterable.spliterator(), true)
                .collect(Collectors.toList());

        if (productList.size() == 0) {
            throw new IllegalArgumentException("Nie znaleziono przedmiotów marki: " + productManufacturer);
        }
        return productList;
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<>();
        Set<Product> productsByCategory = new HashSet<>();
        Set<Product> productsByPrice = new HashSet<>();
        Set<String> criterias = filterParams.keySet();
        if (criterias.contains("brand")) {
            for (String brandName : filterParams.get("brand")) {
                for (Product product : getProductsByManufacturer(brandName)) {
                    productsByBrand.addAll(this.getProductsByManufacturer(brandName));
                }
            }
        }
        if (criterias.contains("category")) {
            for (String categoryName : filterParams.get("category")) {
                productsByCategory.addAll(this.getProductsByCategory(categoryName));
            }
        }
        productsByCategory.retainAll(productsByBrand);
        return productsByCategory;
    }

    @Override
    public List<Product> getProductsByPriceFilter(BigDecimal low, BigDecimal high) {
        Iterable<Product> productIterable = productRepository.findProductsByUnitPriceBetween(low, high);

        List<Product> productList = StreamSupport.stream(productIterable.spliterator(), true)
                .collect(Collectors.toList());

        if (productList.size() == 0) {
            throw new IllegalArgumentException("Nie znaleziono przedmiotów z podanego zakresu cenowego: " + low + " " + high);
        }
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }
}



































