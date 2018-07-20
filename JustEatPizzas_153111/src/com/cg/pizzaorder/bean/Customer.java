package com.cg.pizzaorder.bean;

public class Customer {
	private int customerId;
	private String custName;
	private String address;
	private String phone;

	public Customer(String custName, String address, String phone) {
		super();
		this.custName = custName;
		this.address = address;
		this.phone = phone;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", custName=" + custName + ", address=" + address + ", phone="
				+ phone + "]";
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
