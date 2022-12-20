package org.example.check;

import org.example.base.productBase.Products;

public class PositionInCheck {
    private final String name;
    private final int price;
    private final int promotionPrice;
    private final boolean itemOnSale;
    private final int quantity;
    private final int totalCost;

    public PositionInCheck(Products products, int quantity) {

        this.name = products.getName();
        this.price = products.getPrice();
        this.promotionPrice = price - (price * 10 / 100);
        this.itemOnSale = products.isItemOnSale();
        this.quantity = quantity;

        if (itemOnSale && quantity >= 5) totalCost = promotionPrice * quantity;
        else this.totalCost = price * quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPromotionPrice() {
        return promotionPrice;
    }

    public boolean isItemOnSale() {
        return itemOnSale;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalCost() {
        return totalCost;
    }
}
