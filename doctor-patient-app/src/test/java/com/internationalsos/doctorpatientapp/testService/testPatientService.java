package com.internationalsos.doctorpatientapp.testService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.internationalsos.doctorpatientapp.mapper.PatientMapper;
import com.internationalsos.doctorpatientapp.model.PatientModel;
import com.internationalsos.doctorpatientapp.service.PatientService;

@ExtendWith(MockitoExtension.class)
public class testPatientService {

	@InjectMocks
	PatientService service;

	@Mock
	PatientMapper dao;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreateOrSavePatients() {
		PatientModel patient = new PatientModel(1l, "Mark", "Mark", "+19012345678", "mark@yopmail.com", "Test1234",
				new Date(), "ASC", "MP", "aschjsd");

		try {
			service.savePatientDetails(patient);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		verify(dao, times(1)).savePatientDetails(patient);
	}

}
