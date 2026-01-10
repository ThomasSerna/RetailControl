package com.app.retailcontrol.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull(message = "Name cannot be empty")
    private String name;

    @NotBlank
    @NotNull(message = "Address cannot be emtpy")
    private String address;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    @JsonManagedReference("inventory-store")
    private List<Inventory> inventories;

    public Store(){}

    public Store(String name, String address, List<Inventory> inventories) {
        this.name = name;
        this.address = address;
        this.inventories = inventories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }
}
