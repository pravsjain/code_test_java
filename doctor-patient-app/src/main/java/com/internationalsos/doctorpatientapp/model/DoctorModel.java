package com.internationalsos.doctorpatientapp.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DoctorModel {

	private Long doctorId;

	@NotEmpty(message = "First Name should not be null")
	@Size(min = 2, message = "First Name should have atleast 2 characters")
	private String firstName;

	private String lastName;

	@NotEmpty(message = "Contact Number should not be null")
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String contactNumber;

	@NotEmpty(message = "Email should not be null")
	@Email(message = "Name should have atleast 2 characters")
	private String email;

	@NotEmpty(message = "Password should not be null")
	@Size(message = "Password should have atleast 2 characters")
	private String password;

	@NotEmpty(message = "Specialties should not be null")
	@Size(message = "Specialties should have atleast 2 characters")
	private String specialties;

	private String address;

	private String zipCode;

	private String authorization;

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	public String getSpecialties() {
		return specialties;
	}

	public void setSpecialties(String specialties) {
		this.specialties = specialties;
	}

}
