package com.nttdata.kata.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="DOCUMENTS")
public class Document {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
    @Column
	private String description;
	@Enumerated(EnumType.STRING)
	@NotNull
	private DocumentStatusEnum documentStatus = DocumentStatusEnum.SUBMITTED;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DocumentStatusEnum getDocumentStatus() {
		return documentStatus;
	}
	public void setDocumentStatus(DocumentStatusEnum documentStatus) {
		this.documentStatus = documentStatus;
	}
   
	
	

}
