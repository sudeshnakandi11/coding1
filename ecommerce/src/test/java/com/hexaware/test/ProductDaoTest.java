package com.hexaware.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.dao.ProductsDao;
import com.hexaware.model.Products;

public class ProductDaoTest {

	ProductsDao pdao;
	Products product;

	@Before
	public void setUp() {
		pdao = new ProductsDao();
		product = new Products();

	}

	@Test
	public void testAddProduct() {

		product.setName("air podes");

		product.setPrice(2000);

		product.setDescription("oppo ");

		product.setStockQuantity(400);

		assertTrue(pdao.addProduct(product));
	}

	@After
	public void tearDown() {
		pdao = null;
	}
}