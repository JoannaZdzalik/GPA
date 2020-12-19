package pl.gpalpin.gpa.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.gpalpin.gpa.dto.OfferDto;
import pl.gpalpin.gpa.dto.TaskDto;
import pl.gpalpin.gpa.service.OfferService;

@Controller
public class OfferController {
	
	
//	  @Autowired private OfferService offerService;
//	
//	 @GetMapping("/form") public String mainPage(Model model) {
//	  model.addAttribute("offerToCreate", new OfferDto()); return "form"; }
//	  
//	 
//	  @PostMapping("/addoffer") public String addOffer(@ModelAttribute OfferDto
//	  offerDto) { List<TaskDto> taskDtos = new ArrayList<>(); taskDtos.add(new
//	  TaskDto("Montaz abc", 200L)); taskDtos.add(new TaskDto("Usuniecie xyz",50L));
//	  taskDtos.add(new TaskDto("uszczelnienie nwm", 30L));
//	  offerService.addOffer(offerDto, taskDtos); return "redirect:/form"; }
	 
	  
//	  @RequestMapping(value="/form", params={"addTask"}) 
	 //public String addTask(final OfferDto offerDto) { 
	 //offerDto.getScopeOfWork().add(new TaskDto()); 
	 //return "form"; }
	 

}
