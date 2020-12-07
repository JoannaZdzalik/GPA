package pl.gpalpin.gpa.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pl.gpalpin.gpa.dto.OfferDto;
import pl.gpalpin.gpa.model.Offer;
import pl.gpalpin.gpa.model.Task;
import pl.gpalpin.gpa.dto.TaskDto;
import pl.gpalpin.gpa.repository.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OfferService implements OfferServiceInterface {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private OfferRepository offerRepository;

	public Offer addOffer(OfferDto offerDto) {
		Offer offer = mapper.map(offerDto, Offer.class);
		offer.setTotalCost(calculateTotalCost(offerDto.getScopeOfWork()));
		offerRepository.save(offer);
		System.out.println("Dodana oferta: "+ offer.toString());
		return offer;
	}

	public Offer addOffer(OfferDto offerDto, List<TaskDto> taskDtos) {
		Offer offer = mapper.map(offerDto, Offer.class);
		offer.setScopeOfWork(mapTaskDtosToTasks(taskDtos, offer)); //
		// offer.setScopeOfWork(mapList(taskDtos));
		offer.setTotalCost(calculateTotalCost(taskDtos));
		offerRepository.save(offer);
		return offer;
	}

	public boolean validateFields(OfferDto offerDto, List<TaskDto> tasksDto) {
		if (offerDto.getTitle() == null || tasksDto.isEmpty() || tasksDto == null) {
			return false;
		}
		return true;
	}

	public List<Task> mapTaskDtosToTasks(List<TaskDto> taskDtos, Offer offer) {
		List<Task> tasks = new ArrayList<>();
		for (TaskDto taskDto : taskDtos) {
			Task task = new Task();
			task.setName(taskDto.getName());
			task.setPrice(taskDto.getPrice());
			task.setOffer(offer);
			tasks.add(task);
		}
		return tasks;
	}

	public Long calculateTotalCost(List<TaskDto> taskDtos) {
		Long sum = 0L;
		for (TaskDto taskDto : taskDtos) {
			sum += taskDto.getPrice();
		}
		return sum;
	}

	/* 
	 * public List<Task> mapList(List<TaskDto> taskDtos) { return taskDtos.stream()
	 * .map(t -> mapper.map(t, Task.class)) .collect(Collectors.toList()); }
	 */

}
