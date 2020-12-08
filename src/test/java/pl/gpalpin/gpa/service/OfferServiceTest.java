package pl.gpalpin.gpa.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import pl.gpalpin.gpa.GpaApplication;
import pl.gpalpin.gpa.dto.OfferDto;
import pl.gpalpin.gpa.dto.TaskDto;

@SpringBootTest(classes = GpaApplication.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class OfferServiceTest {

	@Autowired 
	OfferService offerService;
	
	static List<TaskDto> taskDtos = new ArrayList<>();
	static List<TaskDto> emptyList = new ArrayList<>();
	static {
	taskDtos.add(new TaskDto("Montaz abc", 200L));
	taskDtos.add(new TaskDto("Usuniecie xyz", 50L));
	taskDtos.add(new TaskDto("uszczelnienie nwm", 30L));
	}
	
	@Before
	public void init() throws Exception {
		offerService = new OfferService();
	}
	
	@Test //only working with jupiter
	public void shouldCreateOfferWithAllValidParameters() {
		OfferDto offerDto = new OfferDto("Oferta na prace wysokosciowe",taskDtos,280L, "Dostęp do klucza", "12 miesięcy", "7 dni roboczych", 8.5);
		Assert.assertEquals("Oferta zapisana pomyślnie.", offerService.addOffer(offerDto));
	}
	
	@Test
	public void shouldNotCreateOfferWithoutTitle() {
		OfferDto offer1 = new OfferDto(null,taskDtos,280L, "Dostęp do klucza", "12 miesięcy", "7 dni roboczych", 8.5);
		OfferDto offer2 = new OfferDto("",taskDtos,280L, "Dostęp do klucza", "12 miesięcy", "7 dni roboczych", 8.5);
		Assert.assertEquals("Pole 'tytuł' nie może pozostać puste.", offerService.addOffer(offer1));
		Assert.assertEquals("Pole 'tytuł' nie może pozostać puste.", offerService.addOffer(offer2));
		
	}
	@Test
	public void shouldNotCreateOfferWithoutScopeOfWork() {
		OfferDto offer1 = new OfferDto("Oferta na prace wysokosciowe",null,280L, "Dostęp do klucza", "12 miesięcy", "7 dni roboczych", 8.5);
		OfferDto offer2 = new OfferDto("Oferta na prace wysokosciowe",emptyList,280L, "Dostęp do klucza", "12 miesięcy", "7 dni roboczych", 8.5);
		Assert.assertEquals("Nie określono zakresu prac.", offerService.addOffer(offer1));
		Assert.assertEquals("Nie określono zakresu prac.", offerService.addOffer(offer2));
	}
	
	@Test
	public void shouldCheckIsValid() {
		OfferDto scopeNullOffer = new OfferDto("Oferta na prace wysokosciowe",null,280L, "Dostęp do klucza", "12 miesięcy", "7 dni roboczych", 8.5);
		OfferDto scopeEmptyOffer = new OfferDto("Oferta na prace wysokosciowe",emptyList,280L, "Dostęp do klucza", "12 miesięcy", "7 dni roboczych", 8.5);
		OfferDto titleNullOffer = new OfferDto(null,taskDtos,280L, "Dostęp do klucza", "12 miesięcy", "7 dni roboczych", 8.5);
		OfferDto titleEmptyOffer = new OfferDto("",taskDtos,280L, "Dostęp do klucza", "12 miesięcy", "7 dni roboczych", 8.5);
		OfferDto correctOffer = new OfferDto("Oferta na prace wysokosciowe",taskDtos,280L, "Dostęp do klucza", "12 miesięcy", "7 dni roboczych", 8.5);
		
		Assert.assertFalse(offerService.isValid(scopeNullOffer));
		Assert.assertFalse(offerService.isValid(scopeEmptyOffer));
		Assert.assertFalse(offerService.isValid(titleNullOffer));
		Assert.assertFalse(offerService.isValid(titleEmptyOffer));
		Assert.assertTrue(offerService.isValid(correctOffer));
	}
	
	@Test
	public void shouldCalculateTotalCost() {
		long sum = offerService.calculateTotalCost(taskDtos);
		assertEquals(280, sum);
	}
	

}
