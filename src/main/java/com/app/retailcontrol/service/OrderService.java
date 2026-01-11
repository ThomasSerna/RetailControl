package com.app.retailcontrol.service;

import com.app.retailcontrol.dto.PlaceOrderRequestDTO;
import com.app.retailcontrol.repository.*;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final CustomerRepository customerRepository;
    private final InventoryRepository inventoryRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;

    public OrderService(CustomerRepository customerRepository, InventoryRepository inventoryRepository, OrderDetailsRepository orderDetailsRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository, StoreRepository storeRepository) {
        this.customerRepository = customerRepository;
        this.inventoryRepository = inventoryRepository;
        this.orderDetailsRepository = orderDetailsRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
    }

    public void saveOrder(PlaceOrderRequestDTO placeOrderRequestDTO){

    }



}
