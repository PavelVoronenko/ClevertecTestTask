package org.example.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

class SettingTest {
    @Mock
    Map<String, String> connect;
    @InjectMocks
    ConnectDAOSetting setting;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConnections_Should_Return_Connect() {
        Map<String, String> connect = new HashMap<>();
        connect.put("url","jdbc:postgresql://localhost:5432/ClevertecTestTask");
        connect.put("login","postgres");
        connect.put("password","1234");

        Map<String, String> result = setting.connections();
        Assertions.assertEquals(connect, result);
    }
}
