package pl.gpalpin.gpa.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

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

	private long price;
	
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

	public Task(String name, long price, Offer offer) {
		super();
		this.name = name;
		this.price = price;
		this.offer = offer;
	}
    
}
