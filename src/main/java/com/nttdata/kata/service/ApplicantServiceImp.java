package com.nttdata.kata.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nttdata.kata.domain.Applicant;
import com.nttdata.kata.repository.ApplicantRepository;

@Component("applicantService")
@Service
@Transactional
public class ApplicantServiceImp implements ApplicantService {

	@Autowired
	ApplicantRepository applicantRepository;
	
	@Override
	public Applicant createApplicant(Applicant applicant) {
		return applicantRepository.save(applicant);
	}

	@Override
	public List<Applicant> getAllApplicants() {
		return (List<Applicant>) applicantRepository.findAll();
	}

}
