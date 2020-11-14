package pl.gpalpin.gpa.dto;

import java.util.List;
import pl.gpalpin.gpa.model.Task;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto {

	private Long id;
	private String title;
	private List<Task> scopeOfWork;
	private Long totalCost;
	private String additionalInfo;
	private String validFor;
	private String durationOfWork;
	private double percentVAT;
//	private List<BufferedImage> photos;
	
	
	public OfferDto(String title,List<Task> scopeOfWork, Long totalCost, String additionalInfo, String validFor,
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
	
	
	

}
