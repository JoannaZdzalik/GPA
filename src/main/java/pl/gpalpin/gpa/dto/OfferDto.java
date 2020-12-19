package pl.gpalpin.gpa.dto;

import java.util.List;
import pl.gpalpin.gpa.model.Task;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto {

	 Long id;
	 String title;
	 List<TaskDto> scopeOfWork;
	 Long totalCost;
	 String additionalInfo;
	 String validFor;
	 String durationOfWork;
	 double percentVAT;
//	private List<BufferedImage> photos;
	
	
	public OfferDto(String title,List<TaskDto> scopeOfWork, Long totalCost, String additionalInfo, String validFor,
			String durationOfWork, double percentVAT) {
		super();
		this.title = title;
		this.scopeOfWork = scopeOfWork;
		this.totalCost = totalCost;
		this.additionalInfo = additionalInfo;
		this.validFor = validFor;
		this.durationOfWork = durationOfWork;
		this.percentVAT = percentVAT;
	}
	
	public OfferDto(String title, Long totalCost, String additionalInfo, String validFor,
			String durationOfWork, double percentVAT) {
		super();
		this.title = title;
		this.totalCost = totalCost;
		this.additionalInfo = additionalInfo;
		this.validFor = validFor;
		this.durationOfWork = durationOfWork;
		this.percentVAT = percentVAT;
	}
	
	public OfferDto(String title, String additionalInfo) {
		this.title = title;
		this.additionalInfo = additionalInfo;
	}
	
	
	

}
