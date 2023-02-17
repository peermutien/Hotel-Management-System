package com.lcwd.hotel.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	//Resource not found exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> notFoundHandler(ResourceNotFoundException ex) {
        Map map = new HashMap();
        map.put("message", ex.getMessage());
        map.put("success", false);
        map.put("status", HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
    
    //validation
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
       Map<String,String> errorMap=new HashMap();
       
       ex.getBindingResult().getFieldErrors().forEach(error -> {
    	   errorMap.put(error.getField(),error.getDefaultMessage());
       });
       return errorMap;
    }
    
    //HOTEL ALREADY EXIST EXCEPTION
   // @Value(value="${data.exception.dataExists}")
    private String dataExists="Hotel already Exsists.";
    @ExceptionHandler(HotelAlreadyExistException.class)
	public ResponseEntity<String> HotelAlreadyExistException(HotelAlreadyExistException ex){
	        return new ResponseEntity<String>(dataExists, HttpStatus.CONFLICT);
	   }
}