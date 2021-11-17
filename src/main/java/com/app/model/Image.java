
package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity

@Table(name = "image")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;

	@Column(name = "default_image")
	private boolean deafultImage = true;

	@Column(name = "external_url")
	private String externalUrl;

	@Column(name = "image_name")
	private String imageName;

	@Column(name = "image_type")
	private int imageType;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "video_url")
	private String videoUrl;

}
