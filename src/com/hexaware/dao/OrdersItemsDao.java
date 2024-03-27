package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.exception.OrderNotFoundException;
import com.hexaware.model.OrderItems;
import com.hexaware.util.DBUtil;

/**
 * This class provides methods to interact with the order_items table in the database.
 */
public class OrdersItemsDao {

    /**
     * Creates an order item in the database.
     * 
     * @param orderItem The OrderItems object containing order item details.
     * @return boolean True if the order item is successfully created, false otherwise.
     */
    public boolean createOrderItem(OrderItems orderItem) {
        String query = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orderItem.getOrder_id());
            statement.setInt(2, orderItem.getProduct_id());
            statement.setInt(3, orderItem.getQuantity());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves order items associated with a specific order ID.
     * 
     * @param orderId The ID of the order whose order items are to be retrieved.
     * @return List of OrderItems associated with the specified order ID.
     * @throws OrderNotFoundException If the order with the given ID is not found.
     */
    public List<OrderItems> getOrderItemsByOrderId(int orderId) throws OrderNotFoundException {
        List<OrderItems> orderItems = new ArrayList<>();
        String query = "SELECT * FROM order_items WHERE order_id = ?";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                while (resultSet.next()) {
                    OrderItems orderItem = new OrderItems();
                    orderItem.setOrder_item_id(resultSet.getInt("order_item_id"));
                    orderItem.setOrder_id(resultSet.getInt("order_id"));
                    orderItem.setProduct_id(resultSet.getInt("product_id"));
                    orderItem.setQuantity(resultSet.getInt("quantity"));
                    orderItems.add(orderItem);
                }
            } else {
                throw new OrderNotFoundException("Order ID not found");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return orderItems;
    }

    // Other methods for updating and deleting order items can be added here
}
