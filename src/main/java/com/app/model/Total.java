
  package com.app.model;
  
  import javax.persistence.Column; import javax.persistence.Entity; import
  javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
  import javax.persistence.Id; import javax.persistence.Table;
  
  import lombok.Data;
  
  @Data
  
  @Entity
  
  @Table(name = "totalinvoice") public class Total {
  
  @Id
  
  @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
  
  @Column private String code;
  
  @Column private String module;
  
  @Column private int orders;
  
  @Column private String text;
  
  @Column private String title;
  
  @Column private int val;
  
  
  
  }
 