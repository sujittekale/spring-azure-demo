package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Billing;
import com.app.model.Shipping;
import com.app.repository.BillingRepositary;
import com.app.repository.ShippingRepository;
@Service
@Transactional
public class ShippingService {

	@Autowired
	private ShippingRepository shippingrepo;
	
	public List<Shipping> listAllShips(){
		return shippingrepo.findAll();
	}
	public void saveShip(Shipping ship) {
		 shippingrepo.save(ship);
		 
	}
	public Shipping getShip(Integer id) {
		return shippingrepo.findById(id).get();
	}
	public void deleteShip(Integer id) {
		shippingrepo.deleteById(id);
	}
}
