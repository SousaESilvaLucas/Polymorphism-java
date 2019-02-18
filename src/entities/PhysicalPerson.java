package entities;

public class PhysicalPerson extends LegalEntity {

	private Double healthExpenses;
	
	public PhysicalPerson() {

	}

	public PhysicalPerson(String name, Double annualIncome, Double healthExpenses) {
		super(name, annualIncome);
		this.healthExpenses = healthExpenses;
	}

	@Override
	public Double tax() {
		double tax = 0;
		if (annualIncome < 20000.00) {
			tax = annualIncome * 0.15 - 0.5*healthExpenses;	// 15% marginal tax
		}
		else {
			tax = annualIncome * 0.25 - 0.5*healthExpenses;	// 25% marginal tax
		}
		
		return Math.max(tax, 0);		// If tax is negative, then tax = 0
	}

}
