package org.example.check;

import org.example.base.discountCardBase.DiscountCardBase;
import org.example.base.productBase.Products;
import org.example.base.productBase.ProductsBase;
import org.example.exceptions.InputException;

import java.util.*;

public class CheckServicesImpl  implements CheckServices{

    private final String[] inputArguments;
    private final ProductsBase productsBase;
    private final DiscountCardBase discountCard;

    public CheckServicesImpl(String[] args, ProductsBase productsBase, DiscountCardBase discountCardBase) {
        this.inputArguments = args;
        this.productsBase = productsBase;
        this.discountCard = discountCardBase;
    }

    public CheckToString createCheck () throws InputException {

        int totalCostNoDiscount = 0;
        int discountValue = 0;
        List<PositionInCheck> products = new ArrayList<>();

        for (String i: inputArguments) {

            String[] str = i.split("-");
            if (str[0].equals("")) throw new InputException("Invalid input parameters.");

            if (str[0].equals("card")) {

                try {
                    discountValue = discountCard.search(Integer.parseInt(str[1])).getDiscountValue();
                } catch (NullPointerException e) {
                    throw new InputException("Invalid discount card ID.");
                }

            } else {

                try {
                    Products prod = productsBase.search(Integer.parseInt(str[0]));
                    if (prod == null) throw new InputException("Invalid product ID.");

                    PositionInCheck positionInCheck = new PositionInCheck(prod, Integer.parseInt(str[1]));

                    totalCostNoDiscount += positionInCheck.getTotalCost();
                    products.add(positionInCheck);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new InputException("Invalid input parameters.");
                }
            }
        }
        int discountCost = totalCostNoDiscount * discountValue / 100;
        int totalCost = totalCostNoDiscount - discountCost;

        return new CheckToStringImpl (products, totalCostNoDiscount, discountValue, discountCost, totalCost);
    }
}
