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
import com.app.model.Image;
import com.app.service.BillingService;
import com.app.service.ImageService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping
public class ImageController {

	@Autowired
	ImageService imageservice;
	@GetMapping("/image")
	public List<Image> list(){
		return imageservice.listAllImage();
	}
	
	@GetMapping("/image/{id}")
	public ResponseEntity<Image> get(@PathVariable Integer id ){
		try {
		  
			
			Image image=imageservice.getImage(id);
			return new ResponseEntity<Image>(image,HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
		return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
		}
		}
	
	@PostMapping("/image/add")
	public String add(@RequestBody Image image) {
		imageservice.saveImage(image);
		return "Image inserted";
	}
	
	@PutMapping("/image/put/{id}")
	public ResponseEntity<?> update(@RequestBody Image image,@PathVariable Integer id){
		try {
			Image existImage=imageservice.getImage(id);
			image.setId(id);
			imageservice.saveImage(existImage);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/image/delete/{id}")
	public void delete(@PathVariable Integer id) {
	     imageservice.deleteImage(id);
	}
	
	
}
