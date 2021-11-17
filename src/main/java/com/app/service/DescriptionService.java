package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Billing;
import com.app.model.Description;
import com.app.repository.BillingRepositary;
import com.app.repository.DescriptionRepositary;
@Service
@Transactional
public class DescriptionService {

	@Autowired
	private DescriptionRepositary descrrepo;
	
	public List<Description> listAllDescription(){
		return descrrepo.findAll();
	}
	public void saveDescription(Description desc) {
		 descrrepo.save(desc);
		 
	}
	public Description getDescription(Integer id) {
		return descrrepo.findById(id).get();
	}
	public void deleteDescription(Integer id) {
		descrrepo.deleteById(id);
	}
}
