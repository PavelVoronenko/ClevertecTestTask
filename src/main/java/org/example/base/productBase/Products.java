package org.example.base.productBase;

import java.util.Objects;

public class Products {
    private final String name;
    private final int price;
    private final boolean itemOnSale;

    public Products(String name, int price, boolean itemOnSale) {
        this.name = name;
        this.price = price;
        this.itemOnSale = itemOnSale;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isItemOnSale() {
        return itemOnSale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products products)) return false;
        return price == products.price && itemOnSale == products.itemOnSale && Objects.equals(name, products.name);
    }
}

