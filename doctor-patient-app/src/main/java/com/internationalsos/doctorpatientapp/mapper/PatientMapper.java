package com.internationalsos.doctorpatientapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.internationalsos.doctorpatientapp.model.PatientModel;

@Mapper
public interface PatientMapper {

	PatientModel findPatientById(@Param("patientId") long patientId);

	void savePatientDetails(@Param("patient") PatientModel patient);

	void deletePatientById(@Param("patientId") long patientId, @Param("authorization") String authorization);

	void updatePatientDetails(@Param("patient") PatientModel patient, @Param("authorization") String authorization);

}
