package pl.gpalpin.gpa.model;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    private String sendTo;
    private String subject;
    private String body;
    
}
