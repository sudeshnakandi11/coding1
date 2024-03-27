package com.hexaware.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.model.Customers;
import com.hexaware.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDao {
	    public boolean addCustomer(Customers customer) {
	    	String query = "INSERT INTO customers (customer_id,name, email, password) VALUES (?,?, ?, ?)";
	    	try (Connection connection = DBUtil.getDBConn();
	    	     PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
	    	    statement.setInt(1, customer.getCustomer_id());
	    	    statement.setString(2, customer.getName());
	    	    statement.setString(3, customer.getEmail());
	    	    statement.setString(4, customer.getPassword());

	    	    int rowsInserted = statement.executeUpdate();
	    	    if (rowsInserted > 0) {
	    	        ResultSet generatedKeys = statement.getGeneratedKeys();
	    	        if (generatedKeys.next()) {
	    	            customer.setCustomer_id(generatedKeys.getInt(1));
	    	        }
	    	    }
	    	    return rowsInserted > 0;
	    	} catch (SQLException ex) {
	    	    ex.printStackTrace();
	    	    return false;
	    	}

	    }
}
	


