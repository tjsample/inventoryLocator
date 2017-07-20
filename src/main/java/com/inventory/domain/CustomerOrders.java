
package com.inventory.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CustomerOrders implements Serializable {

	private String header;
	private List<CustomerOrder> customerOrderList;
	
	public CustomerOrders() {}
	
	public CustomerOrders(String header, List<CustomerOrder> customerOrderList) {

		this.header  		 	= header;
		this.customerOrderList  = customerOrderList;

	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public List<CustomerOrder> getCustomerOrderList() {
		return customerOrderList;
	}

	public void setCustomerOrderList(List<CustomerOrder> customerOrderList) {
		this.customerOrderList = customerOrderList;
	}

	

	
}
