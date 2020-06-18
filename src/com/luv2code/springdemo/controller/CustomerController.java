package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//I need to inject the customerDAO in order to implement it an operate with it
//	@Autowired
//	private CustomerDAO customerDAO;
	
	@Autowired
    private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		//get the customers from the DAO
		List<Customer> theCustomers = customerService.getCustomers();
		//add the customers to the model
		theModel.addAttribute("customers",theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//create a new model attribute to bind the form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer (@ModelAttribute("customer") Customer theCustomer) {
		//save the customer
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("CustomerId") int theId, Model theModel) {
		
		//get the customer from the service
		Customer theCustomer =  customerService.getCustomer(theId);
		//set customer as a model attribute to prepopulate the form
		theModel.addAttribute("customer", theCustomer);
		//send over to our form
		return "customer-form";
	}
	
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("CustomerId") int theId) {
		
		//get the customer from the service
		customerService.deleteCustomer(theId);
		//set customer as a model attribute to prepopulate the form
		//theModel.addAttribute("customer", theCustomer);
		//send over to our form
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";        
    }

}
