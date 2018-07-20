package com.cg.pizzaorder.service;

import java.util.Scanner;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.dao.IPizzaOrderDAO;
import com.cg.pizzaorder.dao.PizzaOrderDAO;
import com.cg.pizzaorder.exception.PizzaException;

public class PizzaOrderService implements IPizzaOrderService {

	private IPizzaOrderDAO serviceDAO;
	Scanner sc = new Scanner(System.in);

	public PizzaOrderService() {
		serviceDAO = new PizzaOrderDAO();
	}

	private boolean validateCustName(String str) {
		String pattern = "[A-Z][a-z]*";

		if (str.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean validateAddress(String str) {
		String pattern = "[A-Z][a-z]*";

		if (str.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean validatePhone(String str) {
		String pattern = "[1-9][0-9]{9}";

		if (str.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int placeOrder(Customer customer, PizzaOrder pizza) throws PizzaException {
		while (true) {
			if (validateCustName(customer.getCustName())) {
				break;
			} else {
				System.out.println("Incorrect customer name. Please enter again!");
				customer.setCustName(sc.next());
			}
		}
		while (true) {
			if (validateAddress(customer.getAddress())) {
				break;
			} else {
				System.out.println("Incorrect customer address. Please enter again!");
				customer.setAddress(sc.next());
			}
		}
		while (true) {
			if (validatePhone(customer.getPhone())) {
				break;
			} else {
				System.out.println("Incorrect customer phone number. Please enter again!");
				customer.setPhone(sc.next());
			}
		}
		int customerId = serviceDAO.placeOrder(customer, pizza);
		return customerId;
	}

	@Override
	public PizzaOrder getOrderDetails(int orderId) throws PizzaException {
		PizzaOrder pizza=serviceDAO.getOrderDetails(orderId);
		return pizza;
	}
}
