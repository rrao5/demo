package com.nttdata.kata.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "APPLICANT_PACKET")
public class ApplicationPacket {
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private DegreeTypeEnum degreeType;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@NotNull
	private Applicant applicant;
	@Basic
	@Enumerated(EnumType.STRING)
	@NotNull
	private DepartmentEnum deparment;
	@Enumerated(EnumType.STRING)
	@NotNull
	private ApplicationStatusEnum applicationStatus = ApplicationStatusEnum.DRAFT;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime submiteddDate;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Document> documents = new HashSet<Document>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DegreeTypeEnum getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(DegreeTypeEnum degreeType) {
		this.degreeType = degreeType;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public DepartmentEnum getDeparment() {
		return deparment;
	}

	public void setDeparment(DepartmentEnum deparment) {
		this.deparment = deparment;
	}

	public DateTime getSubmiteddDate() {
		return submiteddDate;
	}

	public void setSubmiteddDate(DateTime submiteddDate) {
		this.submiteddDate = submiteddDate;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	public ApplicationStatusEnum getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(ApplicationStatusEnum applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

}
