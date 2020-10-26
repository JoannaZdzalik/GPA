package pl.gpalpin.gpa.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

	private Long id;
	private String name;
	private int price;
    private Long offerId;
}
