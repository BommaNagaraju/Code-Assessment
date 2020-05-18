package com.filedetails.exception;

import java.io.Serializable;
/**
 * @author BommaNagaraju
 *
 */
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String errorType;
	private String errorMessage;
	private String requestType;
	
	public ErrorResponse(String errorType, String errorMessage, String inputRequest) {
		this.errorType = errorType;
		this.errorMessage=errorMessage;
		this.requestType = inputRequest;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
}
