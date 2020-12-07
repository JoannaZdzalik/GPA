package pl.gpalpin.gpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
//	@RequestMapping("/copy")
//	public String copy() {
//		return "copy";
//	}

}
