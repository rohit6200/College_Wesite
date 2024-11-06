package com.College.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.College.Entity.Colleges;

public interface CollegeRepository extends JpaRepository<Colleges, Long>{
	
	

}
