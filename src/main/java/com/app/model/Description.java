
package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity

@Table(name = "descript")
public class Description {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "friend_url")
	private String friendlyUrl;

	@Column(name = "highlights")
	private String highlights;

	@Column(name = "keywords")
	private String keyWords;

	@Column(name = "language")
	private String language;

	@Column(name = "meta_description")
	private String metaDescription;

	@Column(name = "name")
	private String name;

	@Column(name = "title")
	private String title;


}
