package pl.gpalpin.gpa.model;

//import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import lombok.*;

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="offers")
public class Offer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable= false)
	private String title;
	
	@OneToMany(mappedBy = "offer", cascade = {CascadeType.ALL})
	private List<Task> scopeOfWork;
	
	@Column(name="total_cost", nullable = false)
	private Long totalCost;
	
	@Column(name="additional_info", columnDefinition="TEXT")
	private String additionalInfo;
	
	@Column(name="valid_for")
	private String validFor;
	
	@Column(name="duration")
	private String durationOfWork;
	
	@Column(name="percentvat")
	private double percentVAT;

	public Offer(String title, List<Task> scopeOfWork, Long totalCost, String additionalInfo, String validFor,
			String durationOfWork, double percentVAT) {
		super();
		this.title = title;
		this.scopeOfWork = scopeOfWork;
		this.totalCost = totalCost;
		this.additionalInfo = additionalInfo;
		this.validFor = validFor;
		this.durationOfWork = durationOfWork;
		this.percentVAT = percentVAT;
	}


//	private List<BufferedImage> photos;
	
	
}
