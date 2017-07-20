package com.inventory.domain;

public class Inventory {
	
	
	private long inventoryId;
	private long productId;
	private String productName;
	private int productAmount;
	
	public Inventory(long inventoryId, long productId, String productName, int productAmount) {
		
		this.inventoryId 	= inventoryId;
		this.productId 		= productId;
		this.productName 	= productName;
		this.productAmount 	= productAmount;
		
	}
	
	public long getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}	
	

}
