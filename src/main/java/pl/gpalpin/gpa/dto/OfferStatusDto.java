package pl.gpalpin.gpa.dto;

import java.util.List;

import org.springframework.http.ResponseEntity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferStatusDto {
	
	OfferDto offerDto;
	String status;
}
