package com.publicissapient.inventoryservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class InventoryExceptionHandler extends ResponseEntityExceptionHandler{
	
   @ExceptionHandler(ProductNotFoundException.class)
   protected ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException productNotFoundException,WebRequest request)
   {
       ErrorResponse error = new ErrorResponse(new Date(), productNotFoundException.getMessage(), request.getDescription(false));
	   return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(Exception.class)
   public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
	   ErrorResponse errorResponse = new ErrorResponse(new Date(), ex.getMessage(),
         request.getDescription(false));
     return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
   }
}
