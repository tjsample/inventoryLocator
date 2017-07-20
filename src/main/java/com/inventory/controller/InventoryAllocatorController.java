package com.inventory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.domain.CustomerOrder;
import com.inventory.domain.CustomerOrders;
import com.inventory.domain.Output;
import com.inventory.service.InventoryService;

@RestController
public class InventoryAllocatorController {
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryAllocatorController.class);
	private InventoryService inventoryService;
	
	
	@Autowired
	public InventoryAllocatorController(InventoryService inventoryService){
		this.inventoryService = inventoryService;
	}
	
	@RequestMapping( value = "/createOrders", method = RequestMethod.POST, headers = "Accept=application/json" )
	public CustomerOrders processOrder(@RequestBody CustomerOrders customerOrders) throws Exception{
		if(!isValidOrder(customerOrders)) {
			throw new Exception("Invalid Order!, Please try again with valid order!");
		}
		return inventoryService.allocateOrders(customerOrders);
	}
	
	@RequestMapping( value = "/listFinalOutput", method = RequestMethod.GET )
	public List<Output> list(){
		return inventoryService.getFinalOutput();
	}
	
	@RequestMapping( value = "/listCustomerOrder", method = RequestMethod.GET )
	public List<CustomerOrder> listResult(){
		List<CustomerOrder> result = inventoryService.getCustomerOrder();
		return result;
		
	}
	
    @ExceptionHandler(value = Exception.class)  
    public String handleException(Exception e){  
    	logger.error("handle Exception = " + e.getMessage());
        return e.getMessage();  
    }  	
	
	private boolean isValidOrder(CustomerOrders customerOrders) {
		List<CustomerOrder> customerOrderList = customerOrders.getCustomerOrderList();
		for(CustomerOrder co: customerOrderList)
		{
			int orderAmount = co.getOrderAmount();
			if((orderAmount < 1) || (orderAmount > 5))
			{
				logger.error("invalid Input!, Please specify order amount between 1 and 5!");
				return false;
			}
		}
		
		return true;
	}
	
}
