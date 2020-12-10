package pl.gpalpin.gpa.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;

import pl.gpalpin.gpa.dto.OfferDto;
import pl.gpalpin.gpa.dto.TaskDto;
import pl.gpalpin.gpa.service.OfferService;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(controllers = OfferRestController.class)
public class OfferRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OfferService offerService;

	static List<TaskDto> taskDtos = new ArrayList<>();
	static List<TaskDto> emptyList = new ArrayList<>();
	static {
		taskDtos.add(new TaskDto("Montaz abc", 200L));
		taskDtos.add(new TaskDto("Usuniecie xyz", 50L));
		taskDtos.add(new TaskDto("uszczelnienie nwm", 30L));
	}

	@Test
	public void shouldReturnStatusOKOnGetForm() throws Exception {
		this.mockMvc.perform(get("/form"))
		.andExpect(status().isOk())
		.andExpect(view().name("form"));
	}

	@Test
	public void whenOfferDtoCorrect_responseHttpStatus201() throws Exception { 
		given()
		.formParams("title", "testtitle", "totalCost", 220, "additionalInfo", "Keys needed",
				"validFor", "12 miesiecy", "durationOfWork", "2tygodnie", "percentVAT", 8.5)
		.when()
		.post("http://localhost:8080/gpa/addoffer")
		.then()
		.statusCode(200);
	}

	//@Test //using mockmvc
//	public void responseOKWhenOfferIsCreated() throws Exception {
	//	OfferDto offerDto = new OfferDto("Oferta na prace wysokosciowe", null, 280L, "Dostęp do klucza", "12 miesięcy","7 dni roboczych", 8.5);
//		.param("title", "uaaaa")
//		.param("totalCost", "280L")
//		.param("additionalInfo", "someInfo")
//		.param("validFor", "12 months")
//		.param("durationOfWork", "12 days")
//		.param("percentVat", "8.9")
//		.flashAttr("offerToCreate", new OfferDto()))

//		this.mockMvc.perform(post("/addoffer")
//				.accept(MediaType.APPLICATION_JSON)
//				.content(asJsonString(new OfferDto("Oferta na prace wysokosciowe", null, 280L, "Dostęp do klucza", "12 miesięcy","7 dni roboczych", 8.5)))
//			      .contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(content().string(containsString("Oferta zapisana pomyślnie.")));
//	}

	@Test
	public void responseBadRequestWhenNoTitle() {
		given()
        .formParams("title","", "totalCost", 220,"additionalInfo", "12 miesiecy","durationOfWork" ,"2tygodnie","percentVAT", 8.5)
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
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  

//	@Test
//	public void responseBadRequestWhenNoScopeOfWork() {}

}
