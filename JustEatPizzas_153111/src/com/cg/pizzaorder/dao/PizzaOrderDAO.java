package com.cg.pizzaorder.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;

public class PizzaOrderDAO implements IPizzaOrderDAO {

	Random random = new Random();
	int orderId;
	int customerId;
	Map<Integer, PizzaOrder> pizzaEntry;
	Map<Integer, Customer> customerEntry;
	List<Customer> customerList;
	List<PizzaOrder> pizzaList;

	{
		pizzaEntry = new HashMap<Integer, PizzaOrder>();
		customerEntry = new HashMap<Integer, Customer>();
		customerList = new ArrayList<Customer>();
		pizzaList = new ArrayList<PizzaOrder>();
	}

	@Override
	public int placeOrder(Customer customer, PizzaOrder pizza) throws PizzaException {
		try {
			//generating random value for customerId
			customerId = random.nextInt(50000);
			customer.setCustomerId(customerId);
			
			//generating random value for orderId
			orderId = random.nextInt(5000);
			pizza.setCustomerId(customerId);
			pizza.setOrderId(orderId);
			
			//storing values in map
			customerEntry.put(new Integer(customerId), customer);
			pizzaEntry.put(new Integer(orderId), pizza);
			
			//storing objects in list
			customerList.add(customer);
			pizzaList.add(pizza);
			
			return orderId;
		} catch (Exception e) {
			//e.printStackTrace();
			throw new PizzaException("Exception occured");
		}
	}

	@Override
	public PizzaOrder getOrderDetails(int orderid) throws PizzaException {
		/*Set set = pizzaEntry.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry me = (Map.Entry) iterator.next();
			if (((PizzaOrder) me.getValue()).getOrderId() == orderid) {
				return (PizzaOrder) me.getValue();
			}
		}*/
		if(pizzaEntry.containsKey(orderid))
		{
			return pizzaEntry.get(orderid);
		}
		else
		{
			return null;
		}
	}

}
