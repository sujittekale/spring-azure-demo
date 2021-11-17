package com.app.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Invoice {
	private Billing billing;
	private Shipping shipping;
	private ProductData productData;
	//private Description description;
	//private Image image;
	//private Product product;
	
}
