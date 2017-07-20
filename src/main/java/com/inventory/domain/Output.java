package com.inventory.domain;

public class Output {
	
	private String header;
	private String order;
	private String allocatedOrder;
	private String backOrderedOrder;
	
	public Output() {}
	
	public Output (String header, String order, String allocatedOrder, String backOrderedOrder)
	{
		this.header 			= header;
		this.order 				= order;
		this.allocatedOrder 	= allocatedOrder;
		this.backOrderedOrder 	= backOrderedOrder;
	}
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getAllocatedOrder() {
		return allocatedOrder;
	}
	public void setAllocatedOrder(String allocatedOrder) {
		this.allocatedOrder = allocatedOrder;
	}
	public String getBackOrderedOrder() {
		return backOrderedOrder;
	}
	public void setBackOrderedOrder(String backOrderedOrder) {
		this.backOrderedOrder = backOrderedOrder;
	}
	

}
