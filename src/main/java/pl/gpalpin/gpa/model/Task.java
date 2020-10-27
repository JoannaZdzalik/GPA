package pl.gpalpin.gpa.model;

import java.io.Serializable;
import javax.persistence.*;

@SuppressWarnings("serial")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Task(String name, long price, Offer offer) {
		super();
		this.name = name;
		this.price = price;
		this.offer = offer;
	}

	public Task() {
		super();
	}  
	
    
    
}
