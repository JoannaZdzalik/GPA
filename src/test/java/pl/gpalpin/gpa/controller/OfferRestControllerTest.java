package pl.gpalpin.gpa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.Matchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;

import pl.gpalpin.gpa.GpaApplication;
import pl.gpalpin.gpa.dto.OfferDto;
import pl.gpalpin.gpa.dto.OfferStatusDto;
import pl.gpalpin.gpa.dto.TaskDto;
import pl.gpalpin.gpa.service.OfferService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.mockito.ArgumentMatchers.any;

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

//	@Test  jesli w kontrolerze jesr @RequestBody - przechodzi :)
//	public void shouldCreateOfferWhenValidRequest ()throws Exception {
//		OfferDto offerDto = new OfferDto("zzaa", taskDtos, null, "someInfo", "12 months","12 days", 8.9);
//		when(offerService.addOffer(offerDto)).thenReturn("Oferta zapisana pomyslnie");
//		mockMvc.perform(post("/addoffer")
//		.contentType(MediaType.APPLICATION_JSON)
//		.content(asJsonString(offerDto))
//		.accept(MediaType.APPLICATION_JSON))
//	 	.andDo(print())
//		.andExpect(status().isCreated()) //lub isOk, zależnie co mam w kontroleze
//		.andExpect(jsonPath("$.title").value("zzaa")); mozna dodac wiecej expectow
//	}

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
