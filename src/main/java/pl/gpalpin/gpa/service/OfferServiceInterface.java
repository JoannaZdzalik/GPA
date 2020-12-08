package pl.gpalpin.gpa.service;

import java.util.List;

import pl.gpalpin.gpa.dto.OfferDto;
import pl.gpalpin.gpa.dto.TaskDto;
import pl.gpalpin.gpa.model.Offer;

public interface OfferServiceInterface {
	
	String addOffer(OfferDto offerDto, List<TaskDto> taskDtos); //ta potem do usuniecia
	Offer addOffer(OfferDto offerDto); //docelowa
	boolean isValid(OfferDto offerDto, List<TaskDto> tasksDto);
	Long calculateTotalCost(List<TaskDto> taskDtos);
}
