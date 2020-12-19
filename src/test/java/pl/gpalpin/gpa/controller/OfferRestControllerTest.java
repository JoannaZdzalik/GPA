package pl.gpalpin.gpa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.fasterxml.jackson.databind.ObjectMapper;
import pl.gpalpin.gpa.dto.OfferDto;
import pl.gpalpin.gpa.dto.TaskDto;
import pl.gpalpin.gpa.service.OfferService;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(controllers = OfferRestController.class)
public class OfferRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@MockBean
	private OfferService offerService;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	static List<TaskDto> taskDtos = new ArrayList<>();
	static List<TaskDto> emptyList = new ArrayList<>();
	static {
		taskDtos.add(new TaskDto("Montaz abc", 200L));
		taskDtos.add(new TaskDto("Usuniecie xyz", 50L));
		taskDtos.add(new TaskDto("uszczelnienie nwm", 30L));
	}

	@Test
	public void statusOkOnGetForm() throws Exception {
		this.mockMvc.perform(get("/form"))
		.andExpect(status().isOk())
		.andExpect(view().name("form"));
	}

	@Test
	public void responseOKWhenOfferIsCreated() throws Exception {
		when(offerService.addOffer(isA(OfferDto.class))).thenReturn("Oferta zapisana pomyślnie.");
		when(offerService.isValid(isA(OfferDto.class))).thenReturn(true);
		this.mockMvc.perform(post("/addoffer")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("title", "uGGGa")
				.param("additionalInfo", "someInfo")
				.param("validFor", "10 months")
				.param("percentVAT", "10")
				.flashAttr("offerToCreate", new OfferDto()))
		.andDo(print())
		.andExpect(status().isOk());;

		ArgumentCaptor<OfferDto> argument = ArgumentCaptor.forClass(OfferDto.class);
		verify(offerService, times(1)).addOffer(argument.capture());
		verify(offerService, times(1)).isValid(argument.capture());
		verifyNoMoreInteractions(offerService);

		assertEquals("uGGGa", argument.getValue().getTitle());
		//dodac asercje na scopeOfWork gdy juz go ogarne
	}

	@Test
	public void responseBadRequestWhenNoTitle() {
		given()
        .formParams("title","", "totalCost", 220,"additionalInfo", "someinfo","durationOfWork" ,"2tygodnie","percentVAT", 8.5)
        .when()
        .post("http://localhost:8080/gpa/addoffer")
        .then()
        .statusCode(400);
	}

	@Test
	public void responseBadRequestWhenNullTitle() {
		given()
        .formParams("totalCost", 220,"additionalInfo", "12 miesiecy","durationOfWork" ,"2tygodnie","percentVAT", 8.5)
        .when()
        .post("http://localhost:8080/gpa/addoffer")
        .then()
        .statusCode(400);
	}
	
//	@Test
//	public void responseBadRequestWhenNoScopeOfWork() {}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}



}
