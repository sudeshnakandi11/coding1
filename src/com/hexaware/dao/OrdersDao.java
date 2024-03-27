package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.model.Orders;
import com.hexaware.util.DBUtil;

/**
 * This class provides methods to interact with the orders table in the database.
 */
public class OrdersDao {
    ResultSet rs;

    /**
     * Places an order for a customer with the given customer ID and shipping address.
     * 
     * @param cid The customer ID for whom the order is placed.
     * @param address The shipping address for the order.
     * @return boolean True if the order is successfully placed, false otherwise.
     * @throws CustomerNotFoundException If the customer with the given ID is not found.
     */
    public boolean placeOrder(int cid, String address) throws CustomerNotFoundException {
        boolean result = false;
        String query = "INSERT INTO orders (customer_id,  shipping_address) VALUES (?,  ?)";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, cid);
            statement.setString(2, address);

            int noOfRows = statement.executeUpdate();
            if (noOfRows > 0) {
                rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    int oid = rs.getInt(1);

                    PreparedStatement tps = connection.prepareStatement("SELECT total_price from orders where order_id=?");
                    tps.setInt(1, oid);

                    ResultSet trs = tps.executeQuery();
                    if (trs.next()) {
                        System.out.println("----------------------------");
                        System.out.println("Order placed successfully...");
                        System.out.println("Your order id : " + oid);
                        System.out.println("Total amount  : " + trs.getFloat(1));
                        System.out.println("----------------------------");
                    }
                    if (tps != null)
                        tps.close();
                    if (trs != null)
                        tps.close();

                }

                result = true;
            } else {
                throw new CustomerNotFoundException("Customer not found");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * Retrieves orders placed by a customer with the given customer ID.
     * 
     * @param customerId The ID of the customer whose orders are to be retrieved.
     * @return List of Orders placed by the customer.
     * @throws CustomerNotFoundException If the customer with the given ID is not found.
     */
    public List<Orders> getOrdersByCustomerId(int customerId) throws CustomerNotFoundException {
        List<Orders> orders = new ArrayList<>();
        String query = "SELECT * FROM orders WHERE customer_id = ?";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                while (resultSet.next()) {
                    System.out.println("Order ID    : " + resultSet.getInt(1));
                    System.out.println("Order Date  : " + resultSet.getDate(3));
                    System.out.println("Address     : " + resultSet.getString(5));
                    System.out.println("Total Price : " + resultSet.getInt(4));
                    System.out.println("------------------------------\n");

                }
            } else {
                throw new CustomerNotFoundException("Customer ID not found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orders;
    }
}
