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
import com.mysql.cj.protocol.Resultset;

public class OrdersDao {
	ResultSet rs;
    public boolean placeOrder(int cid,String address)throws CustomerNotFoundException {
    	String query1 = "select sum(price) from Products where product_id = (select product_id from cart where customer_id = ?)";
    	
        String query = "INSERT INTO orders (customer_id, total_price, shipping_address) VALUES (?, ?,?)";
        try (Connection connection = DBUtil.getDBConn();
        	PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1,cid);
            statement.setInt(2,1000);
            statement.setString(3, address);

            int rowsInserted = statement.executeUpdate();
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
						System.out.println("Order placed succesfully...");
						System.out.println("your order id : " + oid);
						System.out.println("Total amount  : " + trs.getFloat(1));
						System.out.println("----------------------------");
					}
					if (tps != null)
						tps.close();
					if (trs != null)
						tps.close();

				}

			}
			else {
				throw new CustomerNotFoundException("customer not found");
			}

		      } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return false;
    }

    public List<Orders> getOrdersByCustomerId(int customerId) throws CustomerNotFoundException{
        List<Orders> orders = new ArrayList<>();
        String query = "SELECT * FROM orders WHERE customer_id = ?";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
            while (resultSet.next()) {
            	System.out.println("orderId    : " + rs.getInt(1));
				System.out.println("orderDate  : " + rs.getDate(3));
				System.out.println("Address    : " + rs.getString(5));
				System.out.println("TotalPrice : " + rs.getInt(4));
				System.out.println("------------------------------\n");
                
            }
            }
            else {
            	throw new CustomerNotFoundException("customer id is not found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orders;
    }
	}

