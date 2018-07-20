package com.cg.pizzaorder.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;
import com.cg.pizzaorder.service.IPizzaOrderService;
import com.cg.pizzaorder.service.PizzaOrderService;

public class Client {

	public static void main(String[] args) throws PizzaException {

		/* Map<Integer,PizzaOrder> pizzaEntry; */
		IPizzaOrderService service;

		{
			service = new PizzaOrderService();
			/* pizzaEntry=new HashMap<Integer,PizzaOrder>(); */
		}
		double basePizzaPrice = 350;
		double pizzaToppingsPrice = 0;
		double totalPrice = 0;
		LocalDate date = null;
		int orderId = 0;
		Scanner sc = new Scanner(System.in);
		int choice;
		String ans;
		do {
			System.out.println("1) Place Order");
			System.out.println("2) Dispaly Order");
			System.out.println("3) Exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the name of the customer : ");
				String custName = sc.next();
				System.out.println("Enter customer address: ");
				String address = sc.next();
				System.out.println("Enter customer phone number: ");
				String phone = sc.next();
				System.out.println("Type of Pizza Topping preffered: ");
				String topping = sc.next();
				switch (topping) {
				case "Capsicum":
					pizzaToppingsPrice = 30;
					break;
				case "Mushroom":
					pizzaToppingsPrice = 50;
					break;
				case "Jalapeno":
					pizzaToppingsPrice = 70;
					break;
				case "Paneer":
					pizzaToppingsPrice = 85;
					break;
				default:
					System.out.println("Preffered Pizza Toppings are invalid");
				}
				totalPrice = basePizzaPrice + pizzaToppingsPrice;
				System.out.println("Price: (To be calculated : Rs " + (int)basePizzaPrice + " + " + (int)pizzaToppingsPrice + "("
						+ topping + ") = " + (int)totalPrice);
				System.out.println("Order Date: " + date.now());
				Customer customer = new Customer(custName, address, phone);
				PizzaOrder pizza = new PizzaOrder(totalPrice);
				orderId = service.placeOrder(customer, pizza);
				if (orderId != 0) {
					System.out.println("Pizza Order successfully placed with Order Id: " + orderId);
				}
				break;
			case 2:
				System.out.println("Enter your orderId");
				orderId=sc.nextInt();
				PizzaOrder pizzaOrder = service.getOrderDetails(orderId);
				if (pizzaOrder != null) {
					System.out.println("OrderID\tCustomerID\tTotal Price");
					System.out.println(pizzaOrder.getOrderId() + "\t" + pizzaOrder.getCustomerId() + "\t\t"
							+ (int)pizzaOrder.getTotalPrice());
				}
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
			}
			System.out.println("Do you wish to continue? yes/no");
			ans = sc.next();
		} while (ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y"));
		sc.close();
	}
}
