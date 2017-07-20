package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.domain.CustomerOrder;
import com.inventory.domain.CustomerOrders;
import com.inventory.domain.Output;
import com.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

	private InventoryRepository inventoryRepository;
	
	@Autowired
	public InventoryService(InventoryRepository inventoryRepository) 
	{
		this.inventoryRepository = inventoryRepository;
	}
	
	public CustomerOrders allocateOrders(CustomerOrders customerOrders) 
	{
		return inventoryRepository.createOrders(customerOrders);
	}
		
	public List<CustomerOrder> getCustomerOrder()
	{
		return inventoryRepository.getCustomerOrder();
	}
	
	public List<Output> getFinalOutput()
	{
		return inventoryRepository.getFinalOutput();
	}
	
}
