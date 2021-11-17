
package com.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity

@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "discounted")
	private boolean discounted = true;

	@Column(name = "final_price")
	private String finalPrice;

	@Column(name = "product_count")
	private int productCount;

	@Column(name = "sort_order")
	private int sortOrder;

	@Column(name = "visible")
	private boolean visible = true;
	
	


}
