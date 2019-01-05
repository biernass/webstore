package com.mbsoft.webstore.controllers;

import com.mbsoft.webstore.entities.Product;
import com.mbsoft.webstore.services.ProductService;
import javafx.util.converter.BigDecimalStringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/all")
    public String allProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "products";
    }

    @GetMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @GetMapping("/product")
    public String getProductbyId(@RequestParam("id") Long productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @GetMapping("/{category}/{price}")
    public String filterProducts(@MatrixVariable(pathVar = "price") Map<String, String> priceFilterParams,
                                 @RequestParam("manufacturer") String manufacturer, Model model) {

        BigDecimal lowPriceParam = BigDecimal.valueOf(Integer.valueOf(priceFilterParams.get("low")));
        BigDecimal highPriceParam = BigDecimal.valueOf(Integer.valueOf(priceFilterParams.get("high")));

        Set<Product> productsSet = new HashSet<>();
        productsSet.addAll(productService.getProductsByPriceFilter(lowPriceParam, highPriceParam));
        productsSet.retainAll(productService.getProductsByManufacturer(manufacturer));
        model.addAttribute("products", productsSet);
        return "products";
    }
}



























