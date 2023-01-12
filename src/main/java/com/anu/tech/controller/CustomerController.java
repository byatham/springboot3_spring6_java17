package com.anu.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anu.tech.dto.Customer;
import com.anu.tech.service.CustomerService;

@RestController
@RequestMapping("/customerInfo")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/save")
	public Customer addCustomer(@RequestBody  Customer customer)
	{
		return customerService.addCustomer(customer);
	}

	@GetMapping("/getAll")
	public List<Customer> getCustomers()
	{
		return customerService.getCustomer();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable int id)
	{
		return customerService.getCustomer(id);
	}
}
