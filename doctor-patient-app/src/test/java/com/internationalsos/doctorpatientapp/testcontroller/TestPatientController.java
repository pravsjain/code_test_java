package com.internationalsos.doctorpatientapp.testcontroller;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.internationalsos.doctorpatientapp.controller.PatientController;
import com.internationalsos.doctorpatientapp.model.PatientModel;
import com.internationalsos.doctorpatientapp.model.Response;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestPatientController {

	@Autowired
	PatientController patientController;

	@Test
	public void testCreateReadDelete() {

		PatientModel patient = new PatientModel(1l, "Mark", "Mark", "+19012345678", "mark@yopmail.com", "Test1234",
				new Date(), "ASC", "MP", "aschjsd");

		patientController.savePatientDetails(patient);

		Response patientResponse = patientController.findPatientDetailsByPatientId(1l);
		Assertions.assertEquals("success", patientResponse.getMessage());

		patientController.deletePatientDetails(patient.getPatientId(), patient.getAuthorization());
//		Assertions.assertThat(patientController.findPatientDetailsByPatientId(1l)).isEmpty();
	}

}
