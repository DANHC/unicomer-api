package com.unicomerjam.api.excp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.unicomerjam.api.controller.ResponseWrapper;

@ControllerAdvice
public class ClientApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<ResponseWrapper<Void>> handleClientNotFound(NoRecordFoundException ex, WebRequest req) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseWrapper<Void>(99, ex.getMessage(), null));
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status,
            WebRequest request) {
		
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper<Map<String, String>>(99, "Fields contain erros: ", errors));
	}

}
