package entities;

public abstract class LegalEntity {

	protected String name;
	protected Double annualIncome;
	
	public LegalEntity(){
		
	}

	public LegalEntity(String name, Double annualIncome) {
		this.name = name;
		this.annualIncome = annualIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getannualIncome() {
		return annualIncome;
	}

	public void setannualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}
	
	public abstract Double tax();
}
