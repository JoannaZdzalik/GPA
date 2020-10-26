package pl.gpalpin.gpa.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import pl.gpalpin.gpa.dto.OfferDto;
import pl.gpalpin.gpa.model.Offer;
import pl.gpalpin.gpa.model.Task;
import pl.gpalpin.gpa.dto.TaskDto;
import pl.gpalpin.gpa.repository.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OfferService implements OfferServiceInterface{

    @Autowired
    private ModelMapper mapper;
    
    @Autowired
    private OfferRepository offerRepository;
    
    public Offer createOffer(OfferDto offerDto, List<TaskDto> taskDtos) {
    	Offer offer = mapper.map(offerDto, Offer.class);
    	offer.setTitle("Oferta na wymianę ław kominiarskich");
    	offer.setValidFor("6 miesięcy");
    	offer.setAdditionalInfo("additionalInfo");
    	offer.setDurationOfWork("10 dni roboczych");
    	offer.setScopeOfWork(mapTaskDtosToTasks(taskDtos, offer));
    //	offer.setScopeOfWork(mapList(taskDtos));
    	offer.setTotalCost(calculateTotalCost(taskDtos));
    	validateOffer(offerDto);
    	//offerRepository.save(offer);
    	System.out.println("Oferta utworzona: " + offer.getTitle());
    	return offer;
    }
    
    public void validateOffer(OfferDto offerDto) {
    	System.out.println("Here I will make validation");
    }
    
    public List<Task> mapTaskDtosToTasks(List<TaskDto> taskDtos, Offer offer){
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
    	TaskDto task1 = new TaskDto("jeden", 2000L);
    	TaskDto task2 = new TaskDto("fgh", 3000L);
    	TaskDto task3 = new TaskDto("erty", 70L);
    	taskDtos.add(task1);
    	taskDtos.add(task2);
    	taskDtos.add(task3);
    	Long sum = 0L;
     	for (TaskDto taskDto : taskDtos) {
     		sum += taskDto.getPrice();
    	}
     	System.out.println("Calkowity koszt to: " + sum + " PLN");
    	return sum;
    }
    
//    public List<Task> mapList(List<TaskDto> taskDtos){
//    	List<Task> tasks = new ArrayList<>();
//    	for (TaskDto taskDto : taskDtos) {
//    		Task task = mapper.map(taskDto, Task.class);
//    		tasks.add(task);
//    	}
//    	return tasks;
//    }
   
    
    
    
    
	
}
