/**
 * 
 */
package searchapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import searchapp.model.Student;

/**
 * @author Junaid Khan
 *
 */

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String index() {

		System.out.println("home controller is called method invoke index:::");
		return "home";
	}

	@RequestMapping("/search")
	public RedirectView search(@RequestParam("query") String query) {
		RedirectView redirectView = new RedirectView();
		StringBuilder url = new StringBuilder();
		url.append("https://www.google.com/search?q=");
		url.append(query);

		if (query.isBlank()) {
			redirectView.setUrl("redirect:/home");
			System.out.println("empty url:::");
			return redirectView;

		}

		redirectView.setUrl(url.toString());
		return redirectView;
	}

	@RequestMapping("/form")
	public String form() {

		System.out.println("home controller is called method invoke index:::");
		return "home2";
	}

	/*
	 * @RequestMapping(path = "/processform", method = RequestMethod.POST) public
	 * String handleForm(@RequestParam(name = "name", required = true) String name,
	 * 
	 * @RequestParam("dropDown") String student) {
	 * 
	 * System.out.println("Name " + name); System.out.println("Name " + student);
	 * return "home";
	 * 
	 * }
	 */

	/*@RequestMapping(value = "/processform", method = RequestMethod.POST)
	public String handleForm(@RequestParam("name") String name,
			@RequestParam("dropDown") String dropDown) {
		System.out.println("process form is called :::");
		System.out.println("name is::"+name);
		System.out.println("option  is::"+dropDown);
		return "success";
	}*/
	
	//using model method
	//how  to handke error using bindingresult
	@RequestMapping(value = "/processform", method = RequestMethod.POST)
	public String handleFormMethod(@ModelAttribute("student") Student student,BindingResult result){
		
		
		System.out.println("process  is called :::");
		if(result.hasErrors()) {
			System.out.println("return due to error in form:::");
		return "form";
		}
		
		//student.toString();
		//System.out.println(student.getCourses()+" "+student.getDob());
		System.out.println(student);
		//System.out.println(student.getAddress());
		return "success";
	}
	
	
	//path variable used like query string
	@RequestMapping("/user/{userId}")
	public String  getValueByPath(@PathVariable("userId") int id) {
		
		System.out.println("path variable is called:::"+id);
		return "home2";
	}
		
	//u can use multiple
	@RequestMapping("/user/{userId}/{userName}")
	public String  getValueByPathMultiple(@PathVariable("userId") int id,
			@PathVariable("userName") String userName) {
		
		System.out.println("path variable is called:::"+id);
		System.out.println("path variable is called:::"+userName);
		return "home1";
	}

	@RequestMapping("/abc")
	public String occurExp() {
		
		String num=null;
		System.out.println(num.length());
		
		return "home";
		
	}
	
	
	//for particular exception
	/*
	 * @ExceptionHandler({NullPointerException.class,NumberFormatException.class})
	 * //@ExceptionHandler public String exceptionHandlerNull() {
	 * 
	 * return "null_page"; }
	 */
	
	/*
	 * @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	 * 
	 * @ExceptionHandler(value=NullPointerException.class) public String
	 * exceptionHandlerNull(Model m) {
	 * 
	 * m.addAttribute("msg","Null pointer exception...."); //use expression language
	 * to get value in view page return "null_page"; }
	 * 
	 * 
	 * // generic exception handling
	 * 
	 * @ExceptionHandler(value = Exception.class) public String
	 * exceptionHandlerNullParent() {
	 * 
	 * return "null_page"; }
	 */
}


