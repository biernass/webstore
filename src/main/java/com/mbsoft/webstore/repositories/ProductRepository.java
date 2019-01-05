package com.mbsoft.webstore.repositories;

import com.mbsoft.webstore.entities.Category;
import com.mbsoft.webstore.entities.Manufacturer;
import com.mbsoft.webstore.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findProductsByCategory(Category category);

    List<Product> findProductsByManufacturer(Manufacturer manufacturer);

    List<Product> findProductsByUnitPriceBetween(BigDecimal low, BigDecimal high);

}



























