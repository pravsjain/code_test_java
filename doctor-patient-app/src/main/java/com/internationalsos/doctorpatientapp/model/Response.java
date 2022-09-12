package com.internationalsos.doctorpatientapp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Response")
public class Response {

	public static final boolean STATUS_SUCCESS = true;
	public static final boolean STATUS_ERROR = false;

	@ApiModelProperty(notes = "Apis' execution status", example = "true")
	private boolean status;

	@ApiModelProperty(notes = "Message to define the execution status of an APis", example = "success")
	private String message;

	@ApiModelProperty(notes = "Payload which APis returns as a response")
	private Object payload;

	public Response() {

	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", message=" + message + ", payload=" + payload + "]";
	}

}
