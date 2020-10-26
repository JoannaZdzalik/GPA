package pl.gpalpin.gpa.model;

import lombok.*;
import java.io.Serializable;
import javax.persistence.*;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable= false)
	private String name;

	private int price;
	
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;
}
