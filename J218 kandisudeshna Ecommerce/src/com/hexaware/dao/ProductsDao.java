package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hexaware.exception.ProductNotFoundException;
import com.hexaware.model.Products;
import com.hexaware.util.DBUtil;

/**
 * This class provides methods to interact with the products table in the database.
 */
public class ProductsDao {
    
    /**
     * Adds a new product to the products table.
     * 
     * @param product The Products object containing product details.
     * @return boolean True if the product is successfully added, false otherwise.
     */
    public boolean addProduct(Products product) {
        String query = "INSERT INTO products (product_id, name, price, description, stockQuantity) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, product.getProduct_id());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getPrice());
            statement.setString(4, product.getDescription());
            statement.setInt(5, product.getStockQuantity());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    /**
     * Deletes a product from the products table based on the given product ID.
     * 
     * @param productId The ID of the product to be deleted.
     * @return boolean True if the product is successfully deleted, false otherwise.
     * @throws ProductNotFoundException If the product with the given ID is not found.
     */
    public boolean deleteProduct(int productId) throws ProductNotFoundException {
        String query = "DELETE FROM products WHERE product_id = ?";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, productId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            } else {
                throw new ProductNotFoundException("Product ID not found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
