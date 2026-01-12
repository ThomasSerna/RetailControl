package com.app.retailcontrol.dto;

import com.app.retailcontrol.entity.Inventory;
import com.app.retailcontrol.entity.Product;
import jakarta.validation.constraints.NotNull;

public class CombinedRequestDTO {

    @NotNull
    private Product product;
    @NotNull
    private Inventory inventory;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
