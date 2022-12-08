package com.registration.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MemberException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	private String name;
	private int age;
	private String message;

	public MemberException(String messageName) {
		super(messageName);
		
	}

	public String getMessageName() {
		return message;
	}

	public void setMessageName(String messageName) {
		this.message = messageName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public MemberException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with the %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

//	public MemberException(String name) {
//		super(String.format("%s age less than 18 ", name));
//		this.name = name;
//	}
	
	@ExceptionHandler
	ResponseEntity<CustomErrorMessage> handleException(MemberException exception){
		CustomErrorMessage errorMessage = new CustomErrorMessage();
		errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
		
	}

}
