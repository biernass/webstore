package com.mbsoft.webstore.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(nullable = false)
    private Boolean discounted;

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

    public Boolean getDiscounted() {
        return discounted;
    }

    public Long getUnitsInStock() {
        return unitsInStock;
    }

    public Long getUnitsInOrder() {
        return unitsInOrder;
    }

    public boolean isDiscounted() {
        return discounted;
    }

    public String getCondition() {
        return condition;
    }

    public void setUnitsInStock(Long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Category getCategory() {
        return category;
    }
}












