package com.app.retailcontrol.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "store_id")
    private Store store;

    @Min(0)
    private Double totalPrice;

    private LocalDateTime date;

    @OneToMany(mappedBy = "orderDetails", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<OrderItem> orderItems;

    @PrePersist
    void onCreate(){
        this.date = LocalDateTime.now();
    }

    public OrderDetails(){}

    public OrderDetails(Customer customer, Store store, Double totalPrice) {
        this.customer = customer;
        this.store = store;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
