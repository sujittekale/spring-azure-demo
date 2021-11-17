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
import com.app.model.Description;
import com.app.service.BillingService;
import com.app.service.DescriptionService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping
public class DescriptionController {

	@Autowired
	DescriptionService descservice;
	@GetMapping("/desc")
	public List<Description> list(){
		return descservice.listAllDescription();
	}
	
	@GetMapping("/desc/{id}")
	public ResponseEntity<Description> get(@PathVariable Integer id ){
		try {
		  
			Description desc=descservice.getDescription(id);
			return new ResponseEntity<Description>(desc,HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
		return new ResponseEntity<Description>(HttpStatus.NOT_FOUND);
		}
		}
	
	@PostMapping("/desc/add")
	public String add(@RequestBody Description desc) {
		descservice.saveDescription(desc);
		return "Description inserted";
	}
	
	@PutMapping("/desc/put/{id}")
	public ResponseEntity<?> update(@RequestBody Description desc,@PathVariable Integer id){
		try {
		Description existDesc=descservice.getDescription(id);
			existDesc.setId(id);
			descservice.saveDescription(desc);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/desc/delete/{id}")
	public void delete(@PathVariable Integer id) {
		descservice.deleteDescription(id);
	}
	
	
}
