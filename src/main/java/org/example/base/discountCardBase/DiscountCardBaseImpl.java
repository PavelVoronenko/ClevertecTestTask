package org.example.base.discountCardBase;

import java.sql.*;
import java.util.Map;

public class DiscountCardBaseImpl implements DiscountCardBase{

    private final Connection connection;

    public DiscountCardBaseImpl(Map<String, String> connect) {
        try {
            connection = DriverManager.getConnection(connect.get("url"),
                    connect.get("login"),
                    connect.get("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public DiscountCard search (int id) {
        DiscountCard discountCard = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DISCOUNT_CARD WHERE ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                discountCard = new DiscountCard(resultSet.getInt("value"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return discountCard;
    }
}
