package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.model.Cart;
import com.hexaware.util.DBUtil;
import com.hexaware.exception.ProductNotFoundException;
import com.hexaware.model.*;

/**
 * This class provides methods to interact with the cart table in the database.
 */
public class CartDao {
    
    /**
     * Adds a product to the cart for a specific customer.
     * 
     * @param cart The Cart object containing customer ID, product ID, and quantity.
     * @return boolean True if the product is successfully added to the cart, false otherwise.
     * @throws ProductNotFoundException If the product specified in the cart is not found.
     */
    public boolean addToCart(Cart cart) throws ProductNotFoundException {
        boolean result = false;
        String query = "INSERT INTO cart (customer_id, product_id, quantity) VALUES (?, ?, ?)";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cart.getCustomer_id());
            statement.setInt(2, cart.getProduct_id());
            statement.setInt(3, cart.getQuantity());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                result = true;
            }
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                throw new ProductNotFoundException("Product not found");
            } else {
                System.out.println("Error while updating product: " + e.getMessage());
            }
        }
        return result;
    }
    
    /**
     * Retrieves the products in the cart for a specific customer.
     * 
     * @param customerId The ID of the customer whose cart is to be retrieved.
     * @return List of Products in the customer's cart.
     */
    public List<Products> viewCart(int customerId) {
        List<Products> productsInCart = new ArrayList<>();
        String query = "SELECT p.product_id, p.name, p.price, p.description, c.quantity "
                     + "FROM products p "
                     + "INNER JOIN cart c ON p.product_id = c.product_id "
                     + "WHERE c.customer_id = ?";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Products product = new Products();
                product.setProduct_id(resultSet.getInt("product_id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getInt("price"));
                product.setDescription(resultSet.getString("description"));
                product.setStockQuantity(resultSet.getInt("quantity"));
                productsInCart.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productsInCart;
    }
}
