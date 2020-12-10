package pl.gpalpin.gpa.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.gpalpin.gpa.service.OfferService;

@Configuration
public class SpringConfig {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
    

}
