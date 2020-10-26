package pl.gpalpin.gpa.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

	private Long id;
	private String name;
	private Long price;
    private Long offerId;
	public TaskDto(String name, Long price) {
		super();
		this.name = name;
		this.price = price;
	}
    
    
	   
    
}
