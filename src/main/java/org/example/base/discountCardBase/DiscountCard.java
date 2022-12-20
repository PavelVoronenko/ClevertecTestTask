package org.example.base.discountCardBase;

public class DiscountCard {
    private final int discountValue;

    public DiscountCard(int discountValue) {
        this.discountValue = discountValue;
    }

    public int getDiscountValue() {
        return discountValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountCard that)) return false;
        return discountValue == that.discountValue;
    }
}
