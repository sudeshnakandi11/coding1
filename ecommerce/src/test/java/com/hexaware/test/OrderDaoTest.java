package com.hexaware.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.hexaware.dao.OrdersDao;
import com.hexaware.exception.CustomerNotFoundException;

public class OrderDaoTest {

	OrdersDao od;

	@Before
	public void setUp() {

		od = new OrdersDao();

	}

	@Test
	public void testAddToCart() {

		try {
			assertTrue(od.placeOrder(101, "vzm"));
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() {
		od = null;
	}

}