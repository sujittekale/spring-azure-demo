
  package com.app.repository;
  
  import org.springframework.data.jpa.repository.JpaRepository; import
  org.springframework.stereotype.Repository;
  
  import com.app.model.Description;
  
  @Repository public interface DescriptionRepositary extends
  JpaRepository<Description, Integer> {
  
  }
 