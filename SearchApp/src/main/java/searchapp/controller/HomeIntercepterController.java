/**
 * 
 */
package searchapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Junaid Khan
 *
 */

@Controller
public class HomeIntercepterController {

	
	@RequestMapping("/interceptor")
	public String index() {

		System.out.println("interceptor controller is called method invoke index:::");
		return "field";
	}

	@RequestMapping("/welcome")
	public String welcomeHandler(@RequestParam("user") String name,Model m) {

		System.out.println("  "+name);
		m.addAttribute("name",name);
		
		System.out.println("welcome method invoke index:::");
		
		return "welcome";
	}

	
}
