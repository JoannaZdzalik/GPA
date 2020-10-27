package pl.gpalpin.gpa.dto;


public class TaskDto {

	private Long id;
	private String name;
	private Long price;
    private Long offerId;
    
	public TaskDto(String name, Long price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public TaskDto(String name, Long price, Long offerId) {
		super();
		this.name = name;
		this.price = price;
		this.offerId = offerId;
	}
    
    
	   
    
}
