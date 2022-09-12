package com.internationalsos.doctorpatientapp.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PatientModel {

	private Long patientId;

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

	@Past(message = "Date of birth should be in the past")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birthdate;

	private String address;

	private String zipCode;

	private String authorization;

	public PatientModel() {
		super();
	}

	public PatientModel(Long doctorId,
			@NotEmpty(message = "First Name should not be null") @Size(min = 2, message = "First Name should have atleast 2 characters") String firstName,
			String lastName,
			@NotEmpty(message = "Contact Number should not be null") @Size(min = 2, message = "Name should have atleast 2 characters") String contactNumber,
			@NotEmpty(message = "Email should not be null") @Email(message = "Name should have atleast 2 characters") String email,
			@NotEmpty(message = "Password should not be null") @Size(message = "Password should have atleast 2 characters") String password,
			@Past(message = "Date of birth should be in the past") Date birthdate, String address, String zipCode,
			String authorization) {
		super();
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.birthdate = birthdate;
		this.address = address;
		this.zipCode = zipCode;
		this.authorization = authorization;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
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

}
