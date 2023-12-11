/**
 * 
 */
package searchapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Junaid Khan
 *
 */

@ControllerAdvice
public class CentralizedExceptionHandler {

	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=NullPointerException.class)
	public String exceptionHandlerNull(Model m) {
		
		m.addAttribute("msg","Null pointer exception....");
		//use expression language to get value in view page 
		return "null_page";
	}
	
	
	// generic exception handling
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandlerNullParent() {

		return "null_page";
	}
	
}
