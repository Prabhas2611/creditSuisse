package com.credit.suisse.creditSuisse.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.credit.suisse.creditSuisse.exception.LogException;

@ControllerAdvice
public class HandleException {

	@ExceptionHandler(LogException.class)
	public ResponseEntity<LogException> handleLogException() {
		LogException logException = new LogException("ERROR_CODE_001", "Exception occurred while processing the file");
		return new ResponseEntity<LogException>(logException, HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<LogException> handleIOException() {
		LogException logException = new LogException("ERROR_CODE_001", "Exception occurred in file handling");
		return new ResponseEntity<LogException>(logException, HttpStatus.BAD_REQUEST);
	}
}
