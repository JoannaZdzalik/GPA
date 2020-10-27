package pl.gpalpin.gpa.dto;

import java.util.List;
import pl.gpalpin.gpa.model.Task;


public class OfferDto {

	private Long id;
	private String title;
	private List<Task> scopeOfWork;
	private Long totalCost;
	private String additionalInfo;
	private String validFor;
	private String durationOfWork;
//	private List<BufferedImage> photos;
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
	public OfferDto(String title, List<Task> scopeOfWork, Long totalCost, String additionalInfo, String validFor,
			String durationOfWork) {
		super();
		this.title = title;
		this.scopeOfWork = scopeOfWork;
		this.totalCost = totalCost;
		this.additionalInfo = additionalInfo;
		this.validFor = validFor;
		this.durationOfWork = durationOfWork;
	}
	
	
	

}
