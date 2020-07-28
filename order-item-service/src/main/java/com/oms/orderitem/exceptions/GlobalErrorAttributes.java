package com.oms.orderitem.exceptions;

import java.util.Date;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class GlobalErrorAttributes  extends DefaultErrorAttributes  {
	
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		Map<String, Object> errorAttributes = getErrorAttributes(webRequest, options.isIncluded(Include.STACK_TRACE));
		Throwable error = getError(webRequest);
		HttpStatus status = determineStatus(error);
		errorAttributes.put("status", status);
		errorAttributes.put("timestamp", new Date());
		errorAttributes.put("message", error.getLocalizedMessage());
		errorAttributes.remove("exception");
		return errorAttributes;
		
	}
	
	private HttpStatus determineStatus(Throwable error) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		if(error instanceof OrderItemNotFoundException) {
			status = HttpStatus.NOT_FOUND;
		}
		return status;
	}
	
	

}
