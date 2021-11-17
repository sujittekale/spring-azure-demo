package com.app.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Billing;
import com.app.service.BillingService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping
public class BilllingController {

	@Autowired
	BillingService billingservice;
	@GetMapping("/billing")
	public List<Billing> list(){
		return billingservice.listAllBills();
	}
	
	@GetMapping("/billing/{id}")
	public ResponseEntity<Billing> get(@PathVariable Integer id ){
		try {
		  
			System.err.println("Integer"+id);
			Billing bill=billingservice.getBill(id);
			return new ResponseEntity<Billing>(bill,HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
		return new ResponseEntity<Billing>(HttpStatus.NOT_FOUND);
		}
		}
	
	@PostMapping("/billing/add")
	public String add(@RequestBody Billing bill) {
		billingservice.saveBill(bill);
		return "Bill inserted";
	}
	
	@PutMapping("/billing/put/{id}")
	public ResponseEntity<?> update(@RequestBody Billing bill,@PathVariable Integer id){
		try {
			Billing existBill=billingservice.getBill(id);
			existBill.setId(id);
			billingservice.saveBill(bill);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/billing/delete/{id}")
	public void delete(@PathVariable Integer id) {
		billingservice.deleteBill(id);
	}
	
	
}
