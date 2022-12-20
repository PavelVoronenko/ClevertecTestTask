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
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class CheckServicesTest {
    @Mock
    ProductsBase productsBase;
    @Mock
    DiscountCardBase discountCard;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCheck() throws InputException {
        when(productsBase.search(anyInt())).thenReturn(new Products("name", 0, true));
        when(discountCard.search(anyInt())).thenReturn(new DiscountCard(0));

        String [] args = {"0-0"};

        CheckServices checkServices = new CheckServicesImpl(args, productsBase, discountCard);

        CheckToString result = checkServices.createCheck();
        CheckToString test = new CheckToStringImpl(List.of(new PositionInCheck(new Products("name", 0, true), 0)),
                0, 0, 0, 0);

        Assertions.assertEquals(test.toString(), result.toString());
    }
}
