package pl.gpalpin.gpa.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

	public TaskDto(String name, Long price, Long offerId) {
		super();
		this.name = name;
		this.price = price;
		this.offerId = offerId;
	}
    
    
	   
    
}
