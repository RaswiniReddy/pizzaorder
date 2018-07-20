package com.cg.pizzaorder.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;
import com.cg.pizzaorder.service.IPizzaOrderService;
import com.cg.pizzaorder.service.PizzaOrderService;

class TestPizzaOrder {
	
	IPizzaOrderService service=new PizzaOrderService();
	
	//Testing the placeOrder() method
	@Test
	public void testPlaceOrder() throws PizzaException
	{
		double basePizzaPrice=350;
		double toppingsPrice=85;
		Customer customer=new Customer("John","Dallas","9768587350");
		double totalPrice=basePizzaPrice+toppingsPrice;
		PizzaOrder pizza=new PizzaOrder(totalPrice);
		int orderId=service.placeOrder(customer, pizza);
		//assertEquals(pizza.getOrderId(), service.placeOrder(customer, pizza));
		assertEquals(pizza.getOrderId(),orderId);
	
	}
	
	//testing the getOrderDetails() method
	@Test
	public void testGetOrderDetails() throws PizzaException
	{
		double basePizzaPrice=350;
		double toppingsPrice=85;
		Customer customer=new Customer("John","Dallas","9768587350");
		double totalPrice=basePizzaPrice+toppingsPrice;
		PizzaOrder pizza=new PizzaOrder(totalPrice);
		int orderId=service.placeOrder(customer, pizza);
		assertEquals(pizza, service.getOrderDetails(orderId));
	}
}
