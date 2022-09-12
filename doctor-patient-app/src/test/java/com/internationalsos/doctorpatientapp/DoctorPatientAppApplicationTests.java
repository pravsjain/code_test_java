package com.internationalsos.doctorpatientapp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.internationalsos.doctorpatientapp.controller.PatientController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DoctorPatientAppApplicationTests {

	@Autowired
	PatientController patientController;

	@Test
	public void contextLoads() {
		Assertions.assertThat(patientController).isNotNull();
	}

}
