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
import com.internationalsos.doctorpatientapp.model.PatientModel;
import com.internationalsos.doctorpatientapp.model.Response;
import com.internationalsos.doctorpatientapp.service.PatientService;

/**
 * Patient Controllers have 4 APIs: 1. Fetch Patient data by id: Method: GET
 * URL: /patient/{ID} 2. Save Patient details: Method: POST URL: /patient 3.
 * Update Patient details: Method: PUT URL: /patient 4. Delete Patient details:
 * Method: DELETE URL: /patient/{ID}
 */

@RestController
@Validated
public class PatientController {

	private static final Logger LOGGER = LogManager.getLogger(PatientController.class);

	@Autowired
	private PatientService patientService;

	/**
	 * Path Param: Patient Id Success Response : getting response object with
	 * status: true, message: success and paylod: Patient data
	 */
	@GetMapping("/patient/{id}")
	public Response findPatientDetailsByPatientId(
			@PathVariable("id") @Min(value = 1, message = "Patient id should not be less then 1") long patientId) {
		LOGGER.info("PatientController.findPatientDetailsByPatientId : START" + patientId);
		Response response = new Response();
		PatientModel patientInfo = patientService.findPatientById(patientId);
		if (patientInfo != null) {
			response.setStatus(true);
			response.setMessage("success");
			response.setPayload(patientInfo);
		} else {
			throw new UserNotFoundException("Patient id: " + patientId + " is invalid");
		}
		LOGGER.info("PatientController.findPatientDetailsByPatientId : END");
		return response;
	}

	/**
	 * Request body: PatientModel Success Response : getting response object with
	 * status: true, message: success and paylod: Patient's authorization (which is
	 * required field for delete and update APIs) Response Status: 201
	 */
	@PostMapping("/patient")
	@ResponseStatus(HttpStatus.CREATED)
	public Response savePatientDetails(@Valid @RequestBody PatientModel patient) {
		LOGGER.info("PatientController.savePatientDetails : START");
		Response response = new Response();
		try {

			String authorization = patientService.savePatientDetails(patient);
			Map<String, String> result = new HashMap<String, String>();
			result.put("authorization", authorization);
			response.setStatus(true);
			response.setMessage("success");
			response.setPayload(result);

		} catch (Exception e) {
			LOGGER.error("Error in PatientController.savePatientDetails", e);
			throw new SystemRunTimeException("Sysyem temporarily unavailable. Please try again.");
		}
		LOGGER.info("PatientController.savePatientDetails : END");
		return response;
	}

	/**
	 * Request param : Patient Id Request header: authorization Success Response :
	 * getting response status 200
	 */
	@DeleteMapping("/patient/{id}")
	public void deletePatientDetails(
			@PathVariable("id") @Min(value = 1, message = "Patient id should not be less then 1") long patientId,
			@NotNull(message = "Authorization should not be null") @RequestHeader String authorization) {
		LOGGER.info("PatientController.deletePatientDetails: " + "Patient Id: " + patientId);
		patientService.deletePatientById(patientId, authorization);
	}

	/**
	 * Request param : Patient Id Request header: authorization Success Response :
	 * getting response status 200
	 */
	@PutMapping("/patient")
	@ResponseStatus(HttpStatus.OK)
	public void updatePatientDetails(@Valid @RequestBody PatientModel patient,
			@NotNull(message = "Authorization should not be null") @RequestHeader String authorization) {
		LOGGER.info("PatientController.updatePatientDetails : START");
		try {

			patientService.updatePatientDetails(patient, authorization);

		} catch (Exception e) {
			LOGGER.error("Error in PatientController.updatePatientDetails", e);
			throw new SystemRunTimeException("Sysyem temporarily unavailable. Please try again.");
		}
		LOGGER.info("PatientController.updatePatientDetails : END");

	}
}
