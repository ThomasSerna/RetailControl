package com.app.retailcontrol.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference("inventory-product")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JsonBackReference("inventory-product")
    @JoinColumn(name = "store_id")
    private Store store;

    @Min(0)
    private Integer stock;

    public Inventory(){}

    public Inventory(Product product, Store store, Integer stock) {
        this.product = product;
        this.store = store;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
