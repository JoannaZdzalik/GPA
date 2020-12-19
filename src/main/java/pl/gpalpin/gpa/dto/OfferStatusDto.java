package pl.gpalpin.gpa.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferStatusDto {
	
	OfferDto offerDto;
	String status;
}
