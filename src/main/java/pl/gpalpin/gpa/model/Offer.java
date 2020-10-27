package pl.gpalpin.gpa.model;

//import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@SuppressWarnings("serial")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
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
	
	@Column(name="additional_info")
	private String additionalInfo;
	
	@Column(name="valid_for")
	private String validFor;
	
	@Column(name="duration")
	private String durationOfWork;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Task> getScopeOfWork() {
		return scopeOfWork;
	}

	public void setScopeOfWork(List<Task> scopeOfWork) {
		this.scopeOfWork = scopeOfWork;
	}

	public Long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getValidFor() {
		return validFor;
	}

	public void setValidFor(String validFor) {
		this.validFor = validFor;
	}

	public String getDurationOfWork() {
		return durationOfWork;
	}

	public void setDurationOfWork(String durationOfWork) {
		this.durationOfWork = durationOfWork;
	}

	public Offer(String title, List<Task> scopeOfWork, Long totalCost, String additionalInfo, String validFor,
			String durationOfWork) {
		super();
		this.title = title;
		this.scopeOfWork = scopeOfWork;
		this.totalCost = totalCost;
		this.additionalInfo = additionalInfo;
		this.validFor = validFor;
		this.durationOfWork = durationOfWork;
	}
	
//	private List<BufferedImage> photos;
	
	
}
