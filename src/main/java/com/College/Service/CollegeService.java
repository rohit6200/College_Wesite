package com.College.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.College.Entity.Colleges;

@Service
public interface CollegeService {
	
	Colleges create(Colleges colleges);
	
	Colleges getById(Long id);
	
	List<Colleges> getAll();
	
	Colleges update(Colleges colleges);
	
	void delete(Long id);
	
	

}
