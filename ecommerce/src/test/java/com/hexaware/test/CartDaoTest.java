package com.hexaware.test;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.hexaware.dao.CartDao;
import com.hexaware.model.Cart;
import com.hexaware.exception.ProductNotFoundException;

public class CartDaoTest {

	CartDao cd;
	Cart c;

	@Before
	public void setUp() {

		cd = new CartDao();
		c = new Cart();
	}

	@Test
	public void testAddToCart() {

		c.setCustomer_id(101);
		c.setProduct_id(1);
		c.setQuantity(1);

		
			assertTrue(cd.addToCart(c));
			}

	@After
	public void tearDown() {
		cd = null;
		c=null;
	}

}