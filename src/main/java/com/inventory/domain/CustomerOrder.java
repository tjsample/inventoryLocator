package com.inventory.domain;

import java.util.Date;

public class CustomerOrder {

	private long customerOrderId;
	private String header;
	private long productId;
	private int orderAmount;
	private int allocatedAmount;
	private int backOrderedAmount;
	private Date orderReceived;
	
	public CustomerOrder() {}
	
	public CustomerOrder(String header, long productId, int orderAmount) {
		
		
		this.header  		 = header;
		this.productId		 = productId;
		this.orderAmount	 = orderAmount;
	
		
	}
	
	public CustomerOrder(long customerOrderId, String header, long productId, int orderAmount, Date orderReceived) {
		
		this.customerOrderId = customerOrderId;
		this.header  		 = header;
		this.productId		 = productId;
		this.orderAmount	 = orderAmount;
		this.orderReceived	 = orderReceived;
		
	}
	
	public CustomerOrder(long customerOrderId, String header, long productId, int orderAmount, int allocatedAmount, int backOrderedAmount,  Date orderReceived) {
		
		this.customerOrderId 	= customerOrderId;
		this.header  		 	= header;
		this.productId		 	= productId;
		this.orderAmount	 	= orderAmount;
		this.allocatedAmount 	= allocatedAmount;
		this.backOrderedAmount 	= backOrderedAmount;		
		this.orderReceived	 	= orderReceived;
		
	}	
	
	public long getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(long customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	public int getAllocatedAmount() {
		return allocatedAmount;
	}

	public void setAllocatedAmount(int allocatedAmount) {
		this.allocatedAmount = allocatedAmount;
	}

	public int getBackOrderedAmount() {
		return backOrderedAmount;
	}

	public void setBackOrderedAmount(int backOrderedAmount) {
		this.backOrderedAmount = backOrderedAmount;
	}

	public Date getOrderReceived() {
		return orderReceived;
	}
	public void setOrderReceived(Date orderReceived) {
		this.orderReceived = orderReceived;
	}	
	
	
}
