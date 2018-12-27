package com.mbsoft.webstore.controllers;

import com.mbsoft.webstore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{productId}/{count}")
    @Transactional
    public String process(@PathVariable Long productId, @PathVariable int count){
        orderService.processOrder(productId, count);
        return"redirect:/products";
    }
}
