package com.nttdata.kata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nttdata.kata.domain.Applicant;

@Service
public interface ApplicantService {
	
	public Applicant createApplicant(Applicant applicant);
	public List<Applicant> getAllApplicants();

}
