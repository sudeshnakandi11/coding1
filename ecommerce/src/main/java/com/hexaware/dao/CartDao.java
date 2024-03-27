package com.hexaware.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.model.Cart;
import com.hexaware.util.DBUtil;
import com.hexaware.model.*;
public class CartDao {
    public boolean addToCart(Cart cart) {
        String query = "INSERT INTO cart (cart_id,customer_id, product_id, quantity) VALUES (?, ?,?, ?)";
        try (Connection connection = DBUtil.getDBConn();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cart.getCart_id());
            statement.setInt(2, cart.getCustomer_id());
            statement.setInt(3, cart.getProduct_id());
            statement.setInt(4, cart.getQuantity());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public List<Products> viewCart(int customerId) {
        List<Products> productsInCart = new ArrayList<>();
        String query = "SELECT p.product_id, p.name, p.price, p.description, p.stockQuantity "
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
                product.setStockQuantity(resultSet.getInt("stockQuantity"));
                productsInCart.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productsInCart;
    }
}
