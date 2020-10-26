package pl.gpalpin.gpa.dto;

import java.util.List;
import lombok.*;
import pl.gpalpin.gpa.model.Task;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {

	private Long id;
	private String title;
	private List<Task> scopeOfWork;
	private Long totalCost;
	private String additionalInfo;
	private String validFor;
	private String durationOfWork;
//	private List<BufferedImage> photos;
	

}
