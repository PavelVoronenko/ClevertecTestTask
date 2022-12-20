package org.example.base.discountCardBase;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountCardBaseTest {

    @Test
    void testSearch_Should_Return_DiscountCard() {
        Map<String, String> connect = new HashMap<>();
        connect.put("url","jdbc:postgresql://localhost:5432/ClevertecTestTask");
        connect.put("login","postgres");
        connect.put("password","1234");

        DiscountCardBase discountCardBase = new DiscountCardBaseImpl(connect);

        DiscountCard result = discountCardBase.search(1151);
        assertEquals(new DiscountCard(19), result);
    }
}
