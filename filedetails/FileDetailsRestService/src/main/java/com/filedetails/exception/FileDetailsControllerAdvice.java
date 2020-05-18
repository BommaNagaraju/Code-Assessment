package com.filedetails.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.filedetails.controller.FileDetailsController;
/**
 * @author BommaNagaraju
 *
 */
@ControllerAdvice(assignableTypes= {FileDetailsController.class})
public class FileDetailsControllerAdvice extends ResponseEntityExceptionHandler{
	private static final Log LOG = LogFactory.getLog(FileDetailsControllerAdvice.class);

	 @Override
	    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
	            HttpHeaders headers, HttpStatus status, WebRequest request) {

	        return getMisiingParamsErrorResponse(ex.getMessage(), status, request);
	    }

	    @Override
	    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
	            HttpHeaders headers, HttpStatus status, WebRequest request) {

	        return getMisiingParamsErrorResponse(ex.getMessage(), status, request);
	    }

	    private ResponseEntity<Object> getMisiingParamsErrorResponse(String msg, HttpStatus status, WebRequest request) {
	    	ErrorResponse errorResponse = new ErrorResponse("Missing Required Parameters",  msg,request.getDescription(false));
	        return new ResponseEntity<Object>(errorResponse, status);
	    }


	    /**
	     * Handle error response for Exception
	     * 
	     * @param req
	     * @param exp
	     * @return
	     */
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponse> handleGenericException(HttpServletRequest req, Exception exp) {

	        LOG.error("UnExpected Exception Occoured", exp);

	        ErrorResponse errorResponse = new ErrorResponse("Unexpected Error Occoured while execution.", exp.getLocalizedMessage(),null);

	        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

	        ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<ErrorResponse>(errorResponse, httpStatus);

	        LOG.error("Sending Error Response : " + responseEntity.toString());

	        return responseEntity;
	    }


	    /**
	     * Handle error response for NullPointerException
	     * 
	     * @param req
	     * @param exp
	     * @return
	     */
	    @ExceptionHandler(NullPointerException.class)
	    public ResponseEntity<ErrorResponse> handleNullPointerException(HttpServletRequest req, Exception exp) {

	        LOG.error("UnExpected Exception Occoured", exp);

	        ErrorResponse errorResponse = new ErrorResponse("Null pointerException.", exp.getMessage(),null);

	        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

	        ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<ErrorResponse>(errorResponse, httpStatus);

	        LOG.error("Sending Error Response : " + responseEntity.toString());

	        return responseEntity;
	    }
}
