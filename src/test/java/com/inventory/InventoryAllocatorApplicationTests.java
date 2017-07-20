package com.inventory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.test.context.junit4.SpringRunner;

import com.inventory.domain.CustomerOrder;
import com.inventory.domain.CustomerOrders;
import com.inventory.domain.Output;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class InventoryAllocatorApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger(InventoryAllocatorApplicationTests.class);
	
	@Autowired
	private TestRestTemplate restTemplate;

	
	@Test
	public  void testCreateOrders1() {
		try
		{	
			CustomerOrders customerOrders = new CustomerOrders();
			List<CustomerOrder> customerOrderList = new ArrayList<CustomerOrder>();
			String header = "1";
			customerOrders.setHeader(header);
			CustomerOrder customerOrder1 = new CustomerOrder(header,0, 1);
			CustomerOrder customerOrder2 = new CustomerOrder(header,2,1);
			customerOrderList.add(customerOrder1);
			customerOrderList.add(customerOrder2);
			customerOrders.setCustomerOrderList(customerOrderList);
			
			HttpEntity<CustomerOrders> request = new HttpEntity<>(customerOrders);
			ResponseEntity <CustomerOrders> response = 
			                restTemplate.exchange("http://localhost:8080/createOrders", HttpMethod.POST, 
			                                      request, CustomerOrders.class);
			 CustomerOrders body 	= response.getBody();
			 MediaType contentType 	= response.getHeaders().getContentType();
			 HttpStatus statusCode 	= response.getStatusCode();
			 logger.debug("testCreateOrder1 status code = " + statusCode);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
			 
		 
	}
	
	@Test
	public  void testCreateOrders2() {
		try
		{	
			CustomerOrders customerOrders = new CustomerOrders();
			List<CustomerOrder> customerOrderList = new ArrayList<CustomerOrder>();
			String header = "2";
			customerOrders.setHeader(header);
			CustomerOrder customerOrder1 = new CustomerOrder(header,4, 5);
			customerOrderList.add(customerOrder1);
			customerOrders.setCustomerOrderList(customerOrderList);
			
			HttpEntity<CustomerOrders> request = new HttpEntity<>(customerOrders);
			ResponseEntity <CustomerOrders> response = 
			                restTemplate.exchange("http://localhost:8080/createOrders", HttpMethod.POST, 
			                                      request, CustomerOrders.class);
			 CustomerOrders body 	= response.getBody();
			 MediaType contentType 	= response.getHeaders().getContentType();
			 HttpStatus statusCode 	= response.getStatusCode();
			
			 logger.debug("testCreateOrder2 status code = " + statusCode);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
			 
		 
	}	
	
	@Test
	public  void testCreateOrders3() {
		try
		{	
			CustomerOrders customerOrders = new CustomerOrders();
			List<CustomerOrder> customerOrderList = new ArrayList<CustomerOrder>();
			String header = "3";
			customerOrders.setHeader(header);
			CustomerOrder customerOrder1 = new CustomerOrder(header,3, 4);
			customerOrderList.add(customerOrder1);
			customerOrders.setCustomerOrderList(customerOrderList);
			
			HttpEntity<CustomerOrders> request = new HttpEntity<>(customerOrders);
			ResponseEntity <CustomerOrders> response = 
			                restTemplate.exchange("http://localhost:8080/createOrders", HttpMethod.POST, 
			                                      request, CustomerOrders.class);
			CustomerOrders body 	= response.getBody();
			MediaType contentType 	= response.getHeaders().getContentType();
			HttpStatus statusCode 	= response.getStatusCode();
	
			logger.debug("testCreateOrder3 status code = " + statusCode);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
			 
		 
	}	
	
	
	@Test
	public  void testCreateOrders4() {
		try
		{	
			CustomerOrders customerOrders = new CustomerOrders();
			List<CustomerOrder> customerOrderList = new ArrayList<CustomerOrder>();
			String header = "4";
			customerOrders.setHeader(header);
			CustomerOrder customerOrder1 = new CustomerOrder(header,0, 1);
			CustomerOrder customerOrder2 = new CustomerOrder(header,2, 1);
			customerOrderList.add(customerOrder1);
			customerOrderList.add(customerOrder2);
			customerOrders.setCustomerOrderList(customerOrderList);
			
			HttpEntity<CustomerOrders> request = new HttpEntity<>(customerOrders);
			ResponseEntity <CustomerOrders> response = 
			                restTemplate.exchange("http://localhost:8080/createOrders", HttpMethod.POST, 
			                                      request, CustomerOrders.class);
			CustomerOrders body 	= response.getBody();
			 MediaType contentType 	= response.getHeaders().getContentType();
			 HttpStatus statusCode 	= response.getStatusCode();
			 
			 logger.debug("testCreateOrder4 status code = " + statusCode);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
			 
		 
	}			
	
	@Test
	public  void testCreateOrders5() {
		try
		{	
			CustomerOrders customerOrders = new CustomerOrders();
			List<CustomerOrder> customerOrderList = new ArrayList<CustomerOrder>();
			String header = "5";
			customerOrders.setHeader(header);
			CustomerOrder customerOrder1 = new CustomerOrder(header,1, 3);
			customerOrderList.add(customerOrder1);
			customerOrders.setCustomerOrderList(customerOrderList);
			
			
			HttpEntity<CustomerOrders> request = new HttpEntity<>(customerOrders);
	
			ResponseEntity <CustomerOrders> response = 
			                restTemplate.exchange("http://localhost:8080/createOrders", HttpMethod.POST, 
			                                      request, CustomerOrders.class);
			CustomerOrders body 	= response.getBody();
			 MediaType contentType 	= response.getHeaders().getContentType();
			 HttpStatus statusCode 	= response.getStatusCode();
	
			 logger.debug("testCreateOrder5 status code = " + statusCode);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
			 
		 
	}		
	
	
	@Test
	public  void testCreateOrders6() {
		try
		{	
			CustomerOrders customerOrders = new CustomerOrders();
			List<CustomerOrder> customerOrderList = new ArrayList<CustomerOrder>();
			String header = "6";
			customerOrders.setHeader(header);
			CustomerOrder customerOrder1 = new CustomerOrder(header,3, 4);
			customerOrderList.add(customerOrder1);
			customerOrders.setCustomerOrderList(customerOrderList);
			
			HttpEntity<CustomerOrders> request = new HttpEntity<>(customerOrders);
			ResponseEntity <CustomerOrders> response = 
			                restTemplate.exchange("http://localhost:8080/createOrders", HttpMethod.POST, 
			                                      request, CustomerOrders.class);
			CustomerOrders body 	= response.getBody();
			 MediaType contentType 	= response.getHeaders().getContentType();
			 HttpStatus statusCode 	= response.getStatusCode();
	
			 logger.debug("testCreateOrder6 status code = " + statusCode);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
			 
		 
	}	
	
	
	@Test
	public  void testGetFinalOutput() {

		ResponseEntity < List < Output >> response = 
		                restTemplate.exchange("http://localhost:8080/listFinalOutput", HttpMethod.GET, 
		                                      null, new ParameterizedTypeReference < List < Output >> () {});
		 List<Output> body = response.getBody();
		 MediaType contentType = response.getHeaders().getContentType();
		 HttpStatus statusCode = response.getStatusCode();
		
		 for(Output oo:body)
		 {
			 logger.debug(oo.getHeader() + ":" + oo.getOrder() + "::" + oo.getAllocatedOrder() + "::" + oo.getBackOrderedOrder());

			 
		 }
		 logger.debug("testGetFinalOutput status code = " + statusCode);

	}		
	
	
	
	@Test
	public  void testListCustomerOrder() {

		ResponseEntity < List < CustomerOrder >> response = 
		                restTemplate.exchange("http://localhost:8080/listCustomerOrder", HttpMethod.GET, 
		                                      null, new ParameterizedTypeReference < List < CustomerOrder >> () {});
		 List<CustomerOrder> body 	= response.getBody();
		 MediaType contentType 		= response.getHeaders().getContentType();
		 HttpStatus statusCode 		= response.getStatusCode();
		
/*		 for(CustomerOrder customerOrder:body)
		 {	logger.debug("==============================================");
		 	logger.debug("customerOrderId =" + customerOrder.getCustomerOrderId());
		 	logger.debug("header now = " + customerOrder.getHeader());
		 	logger.debug("order Amount =" + customerOrder.getOrderAmount());
		 	logger.debug("allocated Amount = " + customerOrder.getAllocatedAmount());
		 	logger.debug("backOrdered Amount =" + customerOrder.getBackOrderedAmount());
		 	logger.debug("product id =" + customerOrder.getProductId());
		 	logger.debug("order Received = " + customerOrder.getOrderReceived());
		 	logger.debug("==============================================");
		}*/
		
		logger.debug("testListCustomerOrder status code = " + statusCode);
		 
		 
	}
	

}
