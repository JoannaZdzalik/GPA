package pl.gpalpin.gpa.service;

import pl.gpalpin.gpa.dto.OfferDto;
import pl.gpalpin.gpa.model.Offer;
import pl.gpalpin.gpa.dto.TaskDto;
import java.util.List;

public interface OfferServiceInterface {

	Offer createOffer(OfferDto offerDto, List<TaskDto> taskDtos);
	void validateOffer(OfferDto offerDto);
	Long calculateTotalCost(List<TaskDto> taskDtos);
	
}
