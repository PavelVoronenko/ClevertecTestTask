package org.example.check;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckToStringImpl  implements  CheckToString{

    private final List<PositionInCheck> products;
    private final int totalCostNoDiscount;
    private final int discountValue;
    private final int discountCost;
    private final int totalCost;


    public CheckToStringImpl(List<PositionInCheck> products, int totalCostNoDiscount, int discountValue, int discountCost, int totalCost) {

        this.products = new ArrayList<>(products);
        this.totalCostNoDiscount = totalCostNoDiscount;
        this.discountValue = discountValue;
        this.discountCost = discountCost;
        this.totalCost = totalCost;
    }

    @Override
    public String toString ()  {
        return header() + body() + result();
    }

    private String toCurrency (int price) {
        return String.format("$%d.%02d", price/100, price%100);
    }

    private String header() {

        Date d = new Date();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");

        return String.format("%29s\n%30s\n%36s\n%32s\n\n%s%23s%s\n%37s%s\n%s\n%s%12s%22s%8s\n", "CASH RECEIPT",
                "SUPERMARKET123", "12, MILKYWAY Galaxy/ Earth", "Tel :123-456-7890", "CASHIER: №1525",
                "DATE:", date.format(d), "TIME:", time.format(d), "_______________________________________________",
                "QTY", "DESCRIPTION", "PRICE", "TOTAL");
    }

    private String body() {
        StringBuilder str = new StringBuilder();

        for(PositionInCheck product: products){

            if (product.isItemOnSale() && product.getQuantity() >= 5) {
                str.append(String.format("\n%-4d%-26s\t%s\n%25s%-7s%s\t%s\n", product.getQuantity(), product.getName(),
                        toCurrency(product.getPrice()), "Promotion 5+ -10% ", " ", toCurrency(product.getPromotionPrice()),
                        toCurrency(product.getTotalCost())));
            } else
                str.append(String.format("\n%-4d%-24s\t%s\t%s\n", product.getQuantity(), product.getName(),
                        toCurrency(product.getPrice()), toCurrency(product.getTotalCost())));
            }
        return str.toString();
    }

    private String result () {

        if (discountValue !=0) {
            return String.format("%s\n%s%30s\n%s%4d%%%34s\n%s%42s", "_______________________________________________",
                    "TOTAL NO DISCOUNT", toCurrency(totalCostNoDiscount), "DISCOUNT", discountValue, toCurrency(discountCost), "TOTAL",
                    toCurrency(totalCost));
        } else {
            return String.format("\n%s\n%-39s\t%s\n%s%30s%d\n%s%42s", "_______________________________________________",
                    "TOTAL NO DISCOUNT", toCurrency(totalCostNoDiscount), "NO DISCOUNT CARD", "$", 0, "TOTAL", toCurrency(totalCostNoDiscount));
        }
    }
}
