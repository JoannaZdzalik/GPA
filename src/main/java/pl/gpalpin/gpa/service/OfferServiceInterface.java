package pl.gpalpin.gpa.service;

import pl.gpalpin.gpa.dto.OfferDto;
import pl.gpalpin.gpa.model.Offer;
import pl.gpalpin.gpa.dto.TaskDto;
import java.util.List;

public interface OfferServiceInterface {

	Offer addOffer(OfferDto offerDto, List<TaskDto> taskDtos);
	boolean validateFields(OfferDto offerDto, List<TaskDto> tasksDto);
	Long calculateTotalCost(List<TaskDto> taskDtos);
	
}
