package com.nttdata.kata.repository;

import java.util.List;

import com.nttdata.kata.domain.Applicant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
	
	List<Applicant> findByLastName(String lastName);

}
