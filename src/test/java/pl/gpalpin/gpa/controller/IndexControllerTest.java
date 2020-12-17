package pl.gpalpin.gpa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(IndexController.class)
public class IndexControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnStatusOKAndView() throws Exception {
		this.mockMvc.perform(get("/index"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("index"));;
	}
}
