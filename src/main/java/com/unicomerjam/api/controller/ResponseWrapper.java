package com.unicomerjam.api.controller;

import lombok.Data;

@Data
public class ResponseWrapper<T> {

	private Integer code;
	private String message;
	private T responseData;

	public ResponseWrapper(Integer code, String message, T obj) {
		this.code = code;
		this.message = message;
		this.responseData = obj;
	}
}
