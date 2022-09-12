package com.internationalsos.doctorpatientapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.internationalsos.doctorpatientapp.exception.SystemRunTimeException;
import com.internationalsos.doctorpatientapp.exception.UserNotFoundException;
import com.internationalsos.doctorpatientapp.model.DoctorModel;
import com.internationalsos.doctorpatientapp.model.Response;
import com.internationalsos.doctorpatientapp.service.DoctorService;

/**
 * Doctor Controllers have 4 APIs: 1. Fetch Doctor data by id: Method: GET URL:
 * /doctor/{ID} 2. Save Doctor details: Method: POST URL: /doctor 3. Update
 * Doctor details: Method: PUT URL: /doctor 4. Delete Doctor details: Method:
 * DELETE URL: /doctor/{ID}
 */

@RestController
@Validated
public class DoctorController {
	private static final Logger LOGGER = LogManager.getLogger(DoctorController.class);

	@Autowired
	private DoctorService doctorService;

	/**
	 * Path Param: Doctor Id Success Response : getting response object with status:
	 * true, message: success and paylod: Doctor data
	 */
	@GetMapping("/doctor/{id}")
	public Response findDoctorDetailsByDoctorId(
			@PathVariable("id") @Min(value = 1, message = "Doctor id should not be less then 1") long doctorId) {
		LOGGER.info("DoctorController.findDoctorDetailsByDoctorId : START " + doctorId);
		Response response = new Response();
		DoctorModel doctorInfo = doctorService.findDoctorById(doctorId);
		if (doctorInfo != null) {
			response.setStatus(true);
			response.setMessage("success");
			response.setPayload(doctorInfo);
		} else {
			throw new UserNotFoundException("Doctor id: " + doctorId + " is invalid");
		}
		LOGGER.info("DoctorController.findDoctorDetailsByDoctorId : END");
		return response;
	}

	/**
	 * Request body: DoctorModel Success Response : getting response object with
	 * status: true, message: success and paylod: Doctor's authorization (which is
	 * required field for delete and update APIs) Response Status: 201
	 */
	@PostMapping("/doctor")
	@ResponseStatus(HttpStatus.CREATED)
	public Response saveDoctorDetails(@Valid @RequestBody DoctorModel doctor) {
		LOGGER.info("DoctorController.saveDoctorDetails : START");
		Response response = new Response();
		try {

			String authorization = doctorService.saveDoctorDetails(doctor);
			Map<String, String> result = new HashMap<String, String>();
			result.put("authorization", authorization);
			response.setStatus(true);
			response.setMessage("success");
			response.setPayload(result);

		} catch (Exception e) {
			LOGGER.error("Error in DoctorController.saveDoctorDetails", e);
			throw new SystemRunTimeException("Sysyem temporarily unavailable. Please try again.");
		}
		LOGGER.info("DoctorController.saveDoctorDetails : END");
		return response;
	}

	/**
	 * Request param : Doctor Id Request header: authorization Success Response :
	 * getting response status 200
	 */
	@DeleteMapping("/doctor/{id}")
	public void deleteDoctorDeatils(
			@PathVariable("id") @Min(value = 1, message = "Doctor id should not be less then 1") long doctorId,
			@NotNull(message = "Authorization should not be null") @RequestHeader String authorization) {
		LOGGER.info("DoctorController.deleteDoctorDeatils: " + "Doctor Id: " + doctorId);
		doctorService.deleteDoctorById(doctorId, authorization);
	}

	/**
	 * Request param : Doctor Id Request header: authorization Success Response :
	 * getting response status 200
	 */
	@PutMapping("/doctor")
	@ResponseStatus(HttpStatus.OK)
	public void updateDoctorDetails(@Valid @RequestBody DoctorModel doctor,
			@NotNull(message = "Authorization should not be null") @RequestHeader String authorization) {
		LOGGER.info("DoctorController.updateDoctorDetails : START");
		try {

			doctorService.updateDoctorDetails(doctor, authorization);

		} catch (Exception e) {
			LOGGER.error("Error in DoctorController.updateDoctorDetails", e);
			throw new SystemRunTimeException("Sysyem temporarily unavailable. Please try again.");
		}
		LOGGER.info("DoctorController.updateDoctorDetails : END");

	}

}
