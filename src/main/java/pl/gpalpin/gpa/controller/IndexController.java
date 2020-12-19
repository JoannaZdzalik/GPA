package pl.gpalpin.gpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}

//	@GetMapping("/form") 
//	public String form() {
//		return "form";
//	}
	
//	@RequestMapping("/copy")
//	public String copy() {
//		return "copy";
//	}

}
