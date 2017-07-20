package com.inventory.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.domain.CustomerOrder;
import com.inventory.domain.CustomerOrders;
import com.inventory.domain.Inventory;
import com.inventory.domain.Output;

import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class InventoryRepository {
	private static final Logger logger = LoggerFactory.getLogger(InventoryRepository.class);
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public InventoryRepository(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	

	
	public List<Output> getFinalOutput() 
	{
		List<Output> finalOutput 		= new ArrayList<Output>();
		if(isInventoryZero()) 
		{
			logger.debug("inventory is zero, printing output ...");
			
	    	Output op				 		= null;
	        String prevHeader 				= "";
			String header 					= "";
			int productId					= -1;
			int[] orders					= null;
			int[] allocatedOrders    		= null;
			int[] backOrders				= null;
	    	List<CustomerOrder> customerOrder = getCustomerOrder();
	    	
	    	for(CustomerOrder co: customerOrder)
	    	{
	    		
	    		header 		= co.getHeader();
	    		productId 	= new Integer(co.getProductId()+"");
	    		if(!header.equals(prevHeader)) 
	    		{    			
	    			op 				= new Output();
	    			orders			= new int[5];
	    			allocatedOrders = new int[5];
	    			backOrders		= new int[5];
	    			
	    			for(int i=0;i<orders.length-1;i++) {
	    					orders[i]			= 0;
	    					allocatedOrders[i] 	= 0;
	    					backOrders[i]		= 0;
	    			}
	    			
	    		}
	    		
	
				orders[productId] 			= co.getOrderAmount() ;
				allocatedOrders[productId] 	= co.getAllocatedAmount();
				backOrders[productId] 		= co.getBackOrderedAmount();
				
	    		op.setHeader(header);
	    		op.setOrder(orders[0] + "," + orders[1] + "," + orders[2] + "," + orders[3] + "," +  orders[4]);
				op.setAllocatedOrder(allocatedOrders[0] + "," + allocatedOrders[1] + "," +  allocatedOrders[2] + "," +  allocatedOrders[3] + "," +  allocatedOrders[4]);
				op.setBackOrderedOrder(backOrders[0] + "," +  backOrders[1] + "," + + backOrders[2] + "," +  backOrders[3] + "," + backOrders[4]);
	    		
	    		if(customerOrder.size()==1)
	    		{
	    			finalOutput.add(op);
	    		}
	    		else
	    		if(!header.equals(prevHeader)) 
	    		{  
	    			finalOutput.add(op);
	    		}	
	    		
	    		prevHeader 		= header;
	    		
	    	}
		}
    	return finalOutput;
	}
	
	public CustomerOrders createOrders(CustomerOrders customerOrders)
	{	StringBuilder sql = new StringBuilder();
	    int row = 1;
	    HashMap<Long, Inventory> invt = getInventoryMap();
	    List<CustomerOrder> customerOrderList = customerOrders.getCustomerOrderList();
	 
		sql.append("INSERT INTO CustomerOrder(header, product_id, order_amount, allocated_amount, backOrdered_amount) VALUES ");
		
		for(CustomerOrder customerOrder:customerOrderList) {
			
			//find allocatedAmount and backOrderedAmount
			int allocatedAmount 	= 0;
			int backOrderedAmount 	= 0;
			
			int orderAmount = customerOrder.getOrderAmount();
			Inventory ivt = invt.get(customerOrder.getProductId());
			int inventoryAmount = ivt.getProductAmount();
			
			int newInventoryAmount = inventoryAmount - orderAmount;
			
			if(inventoryAmount == 0 ) 
			{
				allocatedAmount = 0;
				backOrderedAmount = orderAmount;
				newInventoryAmount = 0;
			}
			else if(inventoryAmount < orderAmount)
			{
				allocatedAmount 	= inventoryAmount;
				backOrderedAmount 	= Math.negateExact(newInventoryAmount);
				newInventoryAmount  = 0;
				ivt.setProductAmount(newInventoryAmount);
				invt.put(customerOrder.getProductId(), ivt);

			}
			else 
			{
				allocatedAmount 	= orderAmount;
				backOrderedAmount 	= 0;
				ivt.setProductAmount((newInventoryAmount));
				invt.put(customerOrder.getProductId(), ivt);
			}
			
			
			
			
			if(row > 1) {
				sql.append(", ");
			}
			sql.append("('").append(customerOrders.getHeader()).append("'");
			sql.append(", ").append(customerOrder.getProductId());
			sql.append(", ").append(customerOrder.getOrderAmount());
			sql.append(", ").append(allocatedAmount);
			sql.append(", ").append(backOrderedAmount).append(")");
			row++;
			
			int updatedRow = updateInventory(customerOrder.getProductId(), newInventoryAmount);
			
		}
		logger.debug("sql == " + sql.toString());
		
        int result = jdbcTemplate.update(sql.toString());
        if(result > 0) {
        	logger.debug("result --> " + result);
        
        	return customerOrders;
        }
        
        return null;
	}	
	
	public List<CustomerOrder> getCustomerOrder()
	{
	    String sqlSelect = "SELECT a.customerOrderId, a.header, a.product_id, a.order_amount, a.allocated_amount, a.backOrdered_amount, a.order_received FROM CustomerOrder a, Inventory b WHERE a.product_Id = b.product_Id ORDER BY a.header, a.order_received asc, b.product_name asc";
	    List<CustomerOrder> res =  jdbcTemplate.query(sqlSelect, (rs,i) -> new CustomerOrder(
	    rs.getLong("customerOrderId"),
	    rs.getString("header"),
	    rs.getLong("product_id"),
	    rs.getInt("order_amount"),
	    rs.getInt("allocated_amount"),
	    rs.getInt("backOrdered_amount"),
	    rs.getDate("order_received")
	    ));  
	    return res;
	}	
	
	private int updateInventory(long productId, int newInventoryAmount) {
		String sql = "UPDATE Inventory SET product_amount =" + newInventoryAmount + "WHERE product_Id= " + productId;
		int updatedRow = jdbcTemplate.update(sql.toString());
		return updatedRow;
	}
	
	private HashMap<Long, Inventory> getInventoryMap()
	{
		
        String sqlSelect = "SELECT * FROM Inventory ORDER BY product_name asc";
        List<Inventory> res =  jdbcTemplate.query(sqlSelect, (rs,i) -> new Inventory(
        rs.getLong("inventory_Id"),
        rs.getLong("product_Id"),
        rs.getString("product_name"),
        rs.getInt("product_amount")
        ));  		
		
        HashMap<Long, Inventory> inventoryMap = new HashMap<Long, Inventory> ();
        
        for(Inventory invt: res) {
        	inventoryMap.put(new Long(invt.getProductId()), invt);
        }
        
        return inventoryMap;
	}     	
	
	private boolean isInventoryZero()
	{
		
        String sqlSelect = "SELECT * FROM Inventory ORDER BY product_name asc";
        List<Inventory> res =  jdbcTemplate.query(sqlSelect, (rs,i) -> new Inventory(
        rs.getLong("inventory_Id"),
        rs.getLong("product_Id"),
        rs.getString("product_name"),
        rs.getInt("product_amount")
        ));  		
		
        boolean isZero = true;
        
        for(Inventory invt: res) {
        	if(invt.getProductAmount() > 0)
        	{
        		return false;
        	}
        }
        
        return isZero;
	}   	
	
	
}
