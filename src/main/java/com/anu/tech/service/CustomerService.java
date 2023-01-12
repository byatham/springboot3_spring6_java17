package com.anu.tech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu.tech.dto.Customer;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
@Service
public class CustomerService {
	
	  List<Customer> customerList=new ArrayList<>();
	  
	  @Autowired
	  private ObservationRegistry observationRegistry;
	  
	  
	  public Customer addCustomer(Customer customer)
	  {
		  customerList.add(customer) ;
		 // return customer;
		  
		  return Observation.createNotStarted("addCustomer", observationRegistry)
				  .observe(()-> customer);
	  }
	  
	  public List<Customer> getCustomer()
	  {
		  //return customerList;
		   return Observation.createNotStarted("getCustomers", observationRegistry)
				  .observe(()-> customerList);
	  }
	  
	  public Customer getCustomer(int id)
	  {
		  return Observation.createNotStarted("getCustomer", observationRegistry)
				  .observe(()-> customerList.stream().filter(customer-> customer.id()==id)
						  .findAny().orElseThrow(()->new RuntimeException("Customer not found with id"+id)));
				  
				  
	  }

}
