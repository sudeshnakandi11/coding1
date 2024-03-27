package com.hexaware.model;

/**
 * This class represents a product entity.
 */
public class Products {
    public int product_id;
    public String name;
    public int price;
    public String description;
    public int stockQuantity;

    /**
     * Constructs a new Products object with the specified parameters.
     * 
     * @param product_id The ID of the product.
     * @param name The name of the product.
     * @param price The price of the product.
     * @param description The description of the product.
     * @param stockQuantity The stock quantity of the product.
     */
    public Products(int product_id, String name, int price, String description, int stockQuantity) {
        super();
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stockQuantity = stockQuantity;
    }

    /**
     * Default constructor for Products class.
     */
    public Products() {
        super();
    }

    /**
     * Retrieves the product ID.
     * 
     * @return int The product ID.
     */
    public int getProduct_id() {
        return product_id;
    }

    /**
     * Sets the product ID.
     * 
     * @param product_id The product ID to be set.
     */
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    /**
     * Retrieves the name of the product.
     * 
     * @return String The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     * 
     * @param name The name of the product to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the price of the product.
     * 
     * @return int The price of the product.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * 
     * @param price The price of the product to be set.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Retrieves the description of the product.
     * 
     * @return String The description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the product.
     * 
     * @param description The description of the product to be set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the stock quantity of the product.
     * 
     * @return int The stock quantity of the product.
     */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Sets the stock quantity of the product.
     * 
     * @param stockQuantity The stock quantity of the product to be set.
     */
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Products [product_id=" + product_id + ", name=" + name + ", price=" + price + ", description="
                + description + ", stockQuantity=" + stockQuantity + "]";
    }
}
