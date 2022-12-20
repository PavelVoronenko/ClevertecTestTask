package org.example.base.productBase;

import java.sql.*;
import java.util.Map;

public class ProductsBaseImpl implements ProductsBase{

    private final Connection connection;

    public ProductsBaseImpl(Map<String, String> connect) {
        try {
            connection = DriverManager.getConnection(connect.get("url"),
                                                     connect.get("login"),
                                                     connect.get("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Products search (int id) {

        Products products = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                products = new Products(resultSet.getString("name"), resultSet.getInt("price"),
                        resultSet.getBoolean("sale"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
