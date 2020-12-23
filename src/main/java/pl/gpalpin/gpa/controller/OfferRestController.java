package pl.gpalpin.gpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.gpalpin.gpa.dto.OfferDto;
import pl.gpalpin.gpa.dto.OfferStatusDto;
import pl.gpalpin.gpa.dto.TaskDto;
import pl.gpalpin.gpa.service.OfferService;

@RestController
public class OfferRestController {

	@Autowired
	private OfferService offerService;

	@GetMapping("/form")
	public ModelAndView createNewOffer() {
		return new ModelAndView("form", "offerToCreate", new OfferDto());
	}

	@PostMapping("/addoffer")
	public OfferStatusDto addOffer(@ModelAttribute OfferDto offerDto, HttpServletResponse response) { // a jakby zwracalo obiekt ze statusem a nie status?
		List<TaskDto> taskDtos = new ArrayList<>();
		taskDtos.add(new TaskDto("Montaz abc", 200L));
		taskDtos.add(new TaskDto("Usuniecie xyz", 50L));
		taskDtos.add(new TaskDto("uszczelnienie nwm", 30L));
		offerDto.setScopeOfWork(taskDtos);
		boolean valid = offerService.isValid(offerDto); //taskDtos
		if (valid == true) {
			response.setStatus(200);
		} else {
			 response.setStatus(400);
		}
		String status = offerService.addOffer(offerDto); // taskDtos
		return new OfferStatusDto(offerDto,status);
	}

//	@PostMapping("/addoffer")
//	public ResponseEntity<String> addOffer(@ModelAttribute OfferDto offerDto) { //a jakby zwracalo obiekt ze statusem a nie status?
//		List<TaskDto> taskDtos = new ArrayList<>();
//		taskDtos.add(new TaskDto("Montaz abc", 200L));
//		taskDtos.add(new TaskDto("Usuniecie xyz", 50L));
//		taskDtos.add(new TaskDto("uszczelnienie nwm", 30L));
//	//	URI location = URI.create(String.format("/addodffer")); zmieniajac status na created
//		String status = offerService.addOffer(offerDto, taskDtos);
//		boolean valid = offerService.isValid(offerDto, taskDtos);
//
//		return valid ? ResponseEntity.ok().body(status) : ResponseEntity.badRequest().body(status);
//	}
}
