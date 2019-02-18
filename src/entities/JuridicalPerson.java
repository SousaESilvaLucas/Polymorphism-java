package entities;

public class JuridicalPerson extends LegalEntity {
	
	private Integer nEmployees;
	
	public JuridicalPerson() {
		
	}

	public JuridicalPerson(String name, Double annualIncome, Integer nEmployees) {
		super(name, annualIncome);
		this.nEmployees = nEmployees;
	}

	public int getnEmployees() {
		return nEmployees;
	}

	public void setnEmployees(Integer nEmployees) {
		this.nEmployees = nEmployees;
	}

	@Override
	public Double tax() {
		double tax = 0;
		if (nEmployees > 10) {
			tax = annualIncome * 0.14;
		}
		else {
			tax = annualIncome * 0.16;
		}
		return tax;
	}

}
