package pl.gpalpin.gpa.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import pl.gpalpin.gpa.dto.OfferDto;
import pl.gpalpin.gpa.dto.TaskDto;
import pl.gpalpin.gpa.service.OfferService;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;
	
	@GetMapping("/form")
	public ModelAndView createNewOffer() {
		return new ModelAndView("form", "offerToCreate", new OfferDto());
	}

	@PostMapping("/addoffer")
	public String addOffer(@ModelAttribute OfferDto offerDto) {
		List<TaskDto> taskDtos = new ArrayList<>();
		taskDtos.add(new TaskDto("Przyniose kawe", 200L));
		taskDtos.add(new TaskDto("Podam bułkę", 50L));
		taskDtos.add(new TaskDto("Uśmiechnę się", 30L));
		offerService.addOffer(offerDto, taskDtos);
		return "redirect:index";
	}
}
