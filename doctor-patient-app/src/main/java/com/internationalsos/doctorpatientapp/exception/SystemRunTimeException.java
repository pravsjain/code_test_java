package com.internationalsos.doctorpatientapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class SystemRunTimeException extends RuntimeException {

	public SystemRunTimeException(String message) {
		super(message);
	}

}
