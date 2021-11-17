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
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Billing;
import com.app.model.Shipping;
import com.app.service.BillingService;
import com.app.service.ShippingService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping
public class ShippingController {

	@Autowired
	ShippingService shippingservice;
	@GetMapping("/shipping")
	public List<Shipping> list(){
		return shippingservice.listAllShips();
	}
	
	@GetMapping("/shipping/{id}")
	public ResponseEntity<Shipping> get(@PathVariable Integer id ){
		try {
		  
			System.err.println("Integer"+id);
			Shipping ship=shippingservice.getShip(id);
			return new ResponseEntity<Shipping>(ship,HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
		return new ResponseEntity<Shipping>(HttpStatus.NOT_FOUND);
		}
		}
	
	@PostMapping("/shipping/add")
	   public String add(@RequestBody Shipping ship) {
		shippingservice.saveShip(ship);
		return "Bill inserted";
	}
	
	@PutMapping("/shipping/put/{id}")
	public ResponseEntity<?> update(@RequestBody Shipping ship,@PathVariable Integer id){
		try {
			Shipping existShip=shippingservice.getShip(id);
			existShip.setId(id);
			shippingservice.saveShip(ship);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/shipping/delete/{id}")
	public void delete(@PathVariable Integer id) {
		shippingservice.deleteShip(id);
	}
	
	
}
