package pl.gpalpin.gpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.gpalpin.gpa.service.OfferService;


@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;
}
