package com.internationalsos.doctorpatientapp.service;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internationalsos.doctorpatientapp.mapper.PatientMapper;
import com.internationalsos.doctorpatientapp.model.PatientModel;
import com.internationalsos.doctorpatientapp.secure.MD5EncryptAlgo;

@Service
public class PatientService {
	private static final Logger LOGGER = LogManager.getLogger(PatientService.class);

	@Autowired
	private PatientMapper patientMapper;

	public PatientModel findPatientById(long patientId) {
		return patientMapper.findPatientById(patientId);
	}

	public String savePatientDetails(PatientModel patient) throws Exception {
		patient.setPassword(MD5EncryptAlgo.cryptWithMD5(patient.getPassword()));
		patient.setAuthorization(UUID.randomUUID().toString());
		patientMapper.savePatientDetails(patient);
		return patient.getAuthorization();
	}

	public void deletePatientById(long patientId, String authorization) {
		patientMapper.deletePatientById(patientId, authorization);
	}

	public void updatePatientDetails(PatientModel patient, String authorization) throws Exception {
		patient.setPassword(MD5EncryptAlgo.cryptWithMD5(patient.getPassword()));
		patientMapper.updatePatientDetails(patient, authorization);
	}

}
