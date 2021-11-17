package com.app.model;

import javax.persistence.Column;

import lombok.Data;
@Data
public class ImageData {

	private int id;

	private boolean deafultImage = true;


	private String externalUrl;


	private String imageName;

	
	private int imageType;


	private String imageUrl;


	private String videoUrl;

}
