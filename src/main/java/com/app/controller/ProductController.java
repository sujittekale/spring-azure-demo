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
import com.app.model.Product;
import com.app.service.BillingService;
import com.app.service.ProductService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping
public class ProductController {

	@Autowired
	ProductService productservice;
	@GetMapping("/product")
	public List<Product> list(){
		return productservice.listAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id ){
		try {
		  
			System.err.println("Integer"+id);
			Product product=productservice.getProduct(id);
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		}
	
	@PostMapping("/product/add")
	public String add(@RequestBody Product product) {
		productservice.saveProduct(product);
		return "Product inserted";
	}
	
	@PutMapping("/product/put/{id}")
	public ResponseEntity<?> update(@RequestBody Product product,@PathVariable Integer id){
		try {
			Product existProduct=productservice.getProduct(id);
			existProduct.setId(id);
			productservice.saveProduct(product);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/product/delete/{id}")
	public void delete(@PathVariable Integer id) {
		productservice.deleteProduct(id);
	}
	
	
}
