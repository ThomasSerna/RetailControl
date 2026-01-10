package com.app.retailcontrol.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "order_id")
    private OrderDetails orders;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "product_id")
    private Product product;

    @Min(0)
    private Integer quantity;

    @Min(0)
    private Double price;

    public OrderItem(){}

    public OrderItem(OrderDetails orders, Product product, Integer quantity, Double price) {
        this.orders = orders;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderDetails getOrders() {
        return orders;
    }

    public void setOrders(OrderDetails orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
