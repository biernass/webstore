package com.mbsoft.webstore.services;

public interface OrderService {
    void processOrder(Long productId, int count);

}
