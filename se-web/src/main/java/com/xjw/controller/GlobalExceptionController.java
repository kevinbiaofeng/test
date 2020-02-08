package com.xjw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.xjw.common.result.ModelResult;

@RestControllerAdvice
public class GlobalExceptionController {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);
	
	/**
	 * 全局异常
	 */
	@ExceptionHandler({Exception.class})
	public ModelResult<String> handleMotanServiceException(Exception e){
		logger.error(e.getMessage(), e);
		return new ModelResult<>().withError("1000", "系统繁忙，请稍后再试");
	}
}
