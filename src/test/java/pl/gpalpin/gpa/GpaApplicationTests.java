package pl.gpalpin.gpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import pl.gpalpin.gpa.controller.IndexController;
import pl.gpalpin.gpa.controller.OfferRestController;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class GpaApplicationTests {

	
	  @Autowired private IndexController indexcontroller;
	  
	  @Autowired private OfferRestController offercontroller;
	  
	  @Test public void contextLoads() throws Exception {
	  assertThat(indexcontroller).isNotNull();
	  assertThat(offercontroller).isNotNull(); }
	 
	


}
