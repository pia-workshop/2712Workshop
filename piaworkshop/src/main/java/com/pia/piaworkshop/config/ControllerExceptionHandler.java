package com.pia.piaworkshop.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pia.piaworkshop.error.DefaultExceptionMessage;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ResponseBody
	@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DefaultExceptionMessage> contraintsMethodArgumentNotValidException(
			MethodArgumentNotValidException e) {
		DefaultExceptionMessage dex = new DefaultExceptionMessage();
		dex.setCode(HttpStatus.PRECONDITION_FAILED.value());
		dex.setMessage("Senihcan"+e.getFieldErrors().get(0).getDefaultMessage());
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(dex);
	}
	
	
	
	@ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<DefaultExceptionMessage> objectNotFoundException(NullPointerException e) {
        DefaultExceptionMessage dex = new DefaultExceptionMessage();
        dex.setCode(HttpStatus.NOT_FOUND.value());
        dex.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dex);
    }
}
