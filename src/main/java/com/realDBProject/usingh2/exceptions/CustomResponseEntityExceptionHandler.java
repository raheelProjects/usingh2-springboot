package com.realDBProject.usingh2.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.realDBProject.usingh2.users.UserNotFoundException;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<ErrorDetail> getAllException(Exception ex, WebRequest request)throws Exception{
//		
//		System.out.println("exception : "+ex.toString());
//		
//		ErrorDetail errordetail = new ErrorDetail(ex.getMessage(), request.getDescription(false));
//		
//		return new ResponseEntity<ErrorDetail>(errordetail,HttpStatus.INTERNAL_SERVER_ERROR);
//		
//	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetail> userNotFoundException(Exception ex, WebRequest request){
		
		ErrorDetail userError = new ErrorDetail(ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<ErrorDetail>(userError,HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
			
		 

			    ErrorDetail userError = new ErrorDetail(ex.getFieldError().getDefaultMessage(), request.getDescription(false));
			    
			   
		
		return new ResponseEntity(userError,HttpStatus.BAD_REQUEST);
	}

	

}
