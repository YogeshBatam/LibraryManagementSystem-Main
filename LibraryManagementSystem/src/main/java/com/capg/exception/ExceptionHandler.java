package com.capg.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	//override method of ResponseEntityExceptionHandler class  

	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request)  
	{  
		//creating exception response structure  
		ErrorDetails exceptionResponse= new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));  
		//returning exception structure and specific status   
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);  
	}  


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@org.springframework.web.bind.annotation.ExceptionHandler({LibrarianNotFoundException.class
		,BookNotFoundException.class,
		IssueBookRecordNotFoundException.class,FineNotFoundException.class,
		StudentNotFoundException.class,ReturnBookRecordNotFoundException.class})  
	//override method of ResponseEntityExceptionHandler class  
	public final ResponseEntity<Object> handleUserNotFoundExceptions(Exception ex, WebRequest request)  
	{  
		//creating exception response structure  
		ErrorDetails exceptionResponse= new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));  
		//returning exception structure and specific status   
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);  
	} 

}