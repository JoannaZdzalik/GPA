package pl.gpalpin.gpa.service;

import java.util.List;

import pl.gpalpin.gpa.dto.OfferDto;
import pl.gpalpin.gpa.dto.TaskDto;

public interface OfferServiceInterface {
	
	String addOffer(OfferDto offerDto, List<TaskDto> taskDtos); //ta potem do usuniecia
	String addOffer(OfferDto offerDto); //docelowa
	boolean isValid(OfferDto offerDto); //docelowe
	Long calculateTotalCost(List<TaskDto> taskDtos);
}
