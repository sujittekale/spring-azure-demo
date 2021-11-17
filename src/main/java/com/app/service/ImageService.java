package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Billing;
import com.app.model.Image;
import com.app.repository.BillingRepositary;
import com.app.repository.ImageRepositary;
@Service
@Transactional
public class ImageService {

	@Autowired
	private ImageRepositary imagerepo;
	
	public List<Image> listAllImage(){
		return imagerepo.findAll();
	}
	public void saveImage(Image image) {
		 imagerepo.save(image);
		 
	}
	public Image getImage(Integer id) {
		return imagerepo.findById(id).get();
	}
	public void deleteImage(Integer id) {
		imagerepo.deleteById(id);
	}
}
