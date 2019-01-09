package com.mbsoft.webstore.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    private BigDecimal unitPrice;

    private String description;

    @Enumerated(EnumType.STRING)
    private Manufacturer manufacturer;

    @Enumerated(EnumType.STRING)
    @Column(name = "[category]")
    private Category category;

    private Long unitsInStock;

    private Long unitsInOrder;

    @Column(nullable = true)
    private Boolean discontinued;

    @Column(name = "[condition]")
    private String condition;

    public Product() {
    }

    public Product(String name, BigDecimal unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Boolean getDiscontinued() {
        return discontinued;
    }

    public Long getUnitsInStock() {
        return unitsInStock;
    }

    public Long getUnitsInOrder() {
        return unitsInOrder;
    }

//    public boolean isDiscontinued() {
//        return discontinued;
//    }

    public String getCondition() {
        return condition;
    }

    public void setUnitsInStock(Long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setUnitsInOrder(Long unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Category getCategory() {
        return category;
    }
}












