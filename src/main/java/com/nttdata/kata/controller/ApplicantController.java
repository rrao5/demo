package com.nttdata.kata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.kata.domain.Applicant;
import com.nttdata.kata.service.ApplicantService;

@RestController
public class ApplicantController {

	@Autowired
	ApplicantService applicantService;

	@RequestMapping(value = "/applicants",method = RequestMethod.GET)
	public List<Applicant> getAllApplicants() {
		return applicantService.getAllApplicants();

	}
	
	@RequestMapping(value = "/applicants",method = RequestMethod.POST,headers = {"Content-type=application/json"})
	public Applicant addApplicant(@RequestBody Applicant applicant) {
		return applicantService.createApplicant(applicant);

	}	

}
