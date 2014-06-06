package com.nttdata.kata.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="applicant")
public class Applicant implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private Long id;
    @Column
    @NotNull(message="First name is required")
    @Size(min=2,max=40)
    private String firstName;
    @Column
    @Size(min=2,max=40)
    private String lastName;
    @Column
    @NaturalId
    @NotNull(message="User Id is required")
    private String userId;
    @Column
    @Size(min=2,max=8)
    @NotNull(message="Password is required")
    private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Applicant [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userId=" + userId + "]";
	}
    
    
}


