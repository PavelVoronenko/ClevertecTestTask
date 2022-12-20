package org.example.base.productBase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class ProductsBaseTest {

    @Test
    void testSearch_Should_Return_Product() {
        Map<String, String> connect = new HashMap<>();
        connect.put("url","jdbc:postgresql://localhost:5432/ClevertecTestTask");
        connect.put("login","postgres");
        connect.put("password","1234");

        ProductsBaseImpl productsBase = new ProductsBaseImpl(connect);

        Products result = productsBase.search(2);
        Assertions.assertEquals(new Products("Ashoka Lime Pickle", 4278, false), result);
    }
}
