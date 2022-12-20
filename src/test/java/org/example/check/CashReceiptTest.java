package org.example.check;

import org.example.base.discountCardBase.DiscountCard;
import org.example.base.discountCardBase.DiscountCardBase;
import org.example.base.productBase.Products;
import org.example.base.productBase.ProductsBase;
import org.example.exceptions.InputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.text.SimpleDateFormat;
import java.util.Date;



class CashReceiptTest {

    @Mock
    ProductsBase productBase;
    @Mock
    DiscountCardBase discountCard;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReceiptToString() throws InputException {

        Date d = new Date();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");

        String [] args = {"2-5"};

        Products product = new Products("Ashoka Lime Pickle", 4278, false);
        DiscountCard card = new DiscountCard(0);

        Mockito.when(productBase.search(Mockito.anyInt())).thenReturn(product);
        Mockito.when(discountCard.search(Mockito.anyInt())).thenReturn(card);

        CheckServices checkServices = new CheckServicesImpl(args, productBase, discountCard);
        CheckToString check = checkServices.createCheck();

        String str1 = String.format("%29s\n%30s\n%36s\n%32s\n\n%s%23s%s\n%37s%s\n%s\n%s%12s%22s%8s\n", "CASH RECEIPT",
                "SUPERMARKET123", "12, MILKYWAY Galaxy/ Earth", "Tel :123-456-7890", "CASHIER: №1525",
                "DATE:", date.format(d), "TIME:", time.format(d), "_______________________________________________",
                "QTY", "DESCRIPTION", "PRICE", "TOTAL");

        String str2 = String.format("\n%-4d%-24s\t%s\t%s\n", 5, "Ashoka Lime Pickle",
                "$42.78", "$213.90");

        String str3 = String.format("\n%s\n%-39s\t%s\n%s%30s%d\n%s%42s", "_______________________________________________",
                "TOTAL NO DISCOUNT", "$213.90", "NO DISCOUNT CARD", "$", 0, "TOTAL", "$213.90");

        String result = check.toString();
        Assertions.assertEquals(str1 + str2 + str3, result);
    }
}
