package com.cg.pizzaorder.dao;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;

public interface IPizzaOrderDAO {
	public int placeOrder(Customer customer, PizzaOrder pizza) throws PizzaException;

	public PizzaOrder getOrderDetails(int orderid) throws PizzaException;
}
