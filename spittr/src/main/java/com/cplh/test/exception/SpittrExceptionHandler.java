package com.cplh.test.exception;


import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SpittrExceptionHandler {

	@ExceptionHandler(DuplicateSpittrException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView  duplicateSpittrExceptionHandler(DuplicateSpittrException dpexception,WebRequest request) {
		ModelAndView modelAndView=new ModelAndView("400");
		modelAndView.addObject("message", dpexception.getLocalizedMessage());
		return modelAndView;
	}
	
	@ExceptionHandler(BindException.class)
	public String bindExceptionHandler(){
		return "/";
	}
	
	@ExceptionHandler(SQLException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView sqlException(SQLException sqlExp,WebRequest request){
		ModelAndView modelAndView=new ModelAndView("400");
		modelAndView.addObject("message", sqlExp.getLocalizedMessage());
		return modelAndView;
	}

}
