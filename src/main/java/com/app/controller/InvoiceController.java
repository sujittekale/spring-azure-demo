package com.app.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mapper.ProductMapper;
import com.app.model.Billing;
import com.app.model.Description;
import com.app.model.Image;
import com.app.model.Invoice;
import com.app.model.Product;
import com.app.model.Shipping;
import com.app.service.BillingService;
import com.app.service.DescriptionService;
import com.app.service.ImageService;

import com.app.service.ProductService;
import com.app.service.ShippingService;

@RestController
@RequestMapping
public class InvoiceController {
	@Autowired
	BillingService billingservice;
	@Autowired
	ShippingService shippingService;
	@Autowired 
	
	ProductService productService;
	@Autowired
	ImageService imageservice;
	@Autowired
	DescriptionService descservice;
	
	@GetMapping("/invoice/{id}")
	public ResponseEntity<Invoice> get(@PathVariable Integer id ){
		try {
		  
			System.err.println("Integer"+id);
			Billing bill=billingservice.getBill(id);
			Shipping shipping=shippingService.getShip(id);
			Product product=productService.getProduct(id);
			Image image=imageservice.getImage(id);
			Description desc=descservice.getDescription(id);
			Invoice invoice=new Invoice();
			
			invoice.setBilling(bill);
			invoice.setShipping(shipping);
			//invoice.setProduct(product);
			invoice.setProductData(ProductMapper.mapProuct(product,desc, image));
			
			
			return new ResponseEntity<Invoice>(invoice,HttpStatus.OK);			
		}
		catch(NoSuchElementException e) {
			
			return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
		}
		}

}
