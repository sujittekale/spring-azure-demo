package com.app.model;

import lombok.Data;
@Data
public class ProductData {
	
	private int id;

	private boolean discounted = true;

	
	private String finalPrice;

	
	private int productCount;

	private int sortOrder;
	

	
	private boolean visible = true;
	
	
	private ProductDiscription productDesc;
	private ImageData imageData;
	
}
