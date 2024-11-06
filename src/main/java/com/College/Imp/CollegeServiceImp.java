package com.College.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.College.Entity.Colleges;
import com.College.Repository.CollegeRepository;
import com.College.Service.CollegeService;

@Service
public class CollegeServiceImp implements CollegeService {

	private final CollegeRepository collegeRepository;

	public CollegeServiceImp(CollegeRepository collegeRepository) {
		this.collegeRepository = collegeRepository;
	}

	@Override
	public Colleges create(Colleges colleges) {
		return collegeRepository.save(colleges);
	}

	@Override
	public Colleges getById(Long id) {
		Optional<Colleges> collegesOptional = collegeRepository.findById(id);

		return collegesOptional.orElse(null);
	}

	@Override
	public List<Colleges> getAll() {
		return collegeRepository.findAll();
	}

	@Override
	public Colleges update(Colleges colleges) {
		return collegeRepository.save(colleges);
	}

	@Override
	public void delete(Long id) {
		collegeRepository.deleteById(id);
	}

}
