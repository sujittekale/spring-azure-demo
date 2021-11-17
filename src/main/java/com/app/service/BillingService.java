package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Billing;
import com.app.repository.BillingRepositary;
@Service
@Transactional
public class BillingService {

	@Autowired
	private BillingRepositary billingrepo;
	
	public List<Billing> listAllBills(){
		return billingrepo.findAll();
	}
	public void saveBill(Billing bill) {
		 billingrepo.save(bill);
		 
	}
	public Billing getBill(Integer id) {
		return billingrepo.findById(id).get();
	}
	public void deleteBill(Integer id) {
		billingrepo.deleteById(id);
	}
}
