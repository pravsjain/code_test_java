package com.internationalsos.doctorpatientapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.internationalsos.doctorpatientapp.model.DoctorModel;

@Mapper
public interface DoctorMapper {

	DoctorModel findDoctorById(@Param("doctorId") long doctorId);

	void saveDoctorDetails(@Param("doctor") DoctorModel doctor);

	void deleteDoctorById(@Param("doctorId") long doctorId, @Param("authorization") String authorization);

	void updateDoctorDetails(@Param("doctor") DoctorModel doctor, @Param("authorization") String authorization);

}
