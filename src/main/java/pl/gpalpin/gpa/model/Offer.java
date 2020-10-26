package pl.gpalpin.gpa.model;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.List;
import lombok.*;
import javax.persistence.*;

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
	
	@NonNull
	private String title;
	
	@OneToMany(mappedBy = "offer", cascade = {CascadeType.ALL})
	private List<Task> scopeOfWork;
	
	@Column(name="total_cost", nullable = false)
	private Long totalCost;
	
	@Column(name="additional_info")
	private String additionalInfo;
	
	@Column(name="valid_for")
	private String validFor;
	
	@Column(name="duration")
	private String durationOfWork;
	
//	private List<BufferedImage> photos;
	
}
