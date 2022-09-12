package com.internationalsos.doctorpatientapp.service;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internationalsos.doctorpatientapp.mapper.DoctorMapper;
import com.internationalsos.doctorpatientapp.model.DoctorModel;
import com.internationalsos.doctorpatientapp.secure.MD5EncryptAlgo;

@Service
public class DoctorService {
	private static final Logger LOGGER = LogManager.getLogger(DoctorService.class);

	@Autowired
	private DoctorMapper doctorMapper;

	public DoctorModel findDoctorById(long doctorId) {
		return doctorMapper.findDoctorById(doctorId);
	}

	public String saveDoctorDetails(DoctorModel doctor) throws Exception {
		doctor.setPassword(MD5EncryptAlgo.cryptWithMD5(doctor.getPassword()));
		doctor.setAuthorization(UUID.randomUUID().toString());
		doctorMapper.saveDoctorDetails(doctor);
		return doctor.getAuthorization();
	}

	public void deleteDoctorById(long doctorId, String authorization) {
		doctorMapper.deleteDoctorById(doctorId, authorization);
	}

	public void updateDoctorDetails(DoctorModel doctor, String authorization) throws Exception {
		doctor.setPassword(MD5EncryptAlgo.cryptWithMD5(doctor.getPassword()));
		doctorMapper.updateDoctorDetails(doctor, authorization);
	}

}
