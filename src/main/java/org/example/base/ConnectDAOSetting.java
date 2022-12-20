package org.example.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConnectDAOSetting {

    private final Map<String, String> connect = new HashMap<>();
    public ConnectDAOSetting() {
        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            connect.put("url", prop.getProperty("db.url"));
            connect.put("login", prop.getProperty("db.user"));
            connect.put("password", prop.getProperty("db.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Map<String, String> connections () {
        return connect;
    }
}
