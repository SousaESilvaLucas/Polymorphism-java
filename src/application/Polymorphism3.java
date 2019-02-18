package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.JuridicalPerson;
import entities.LegalEntity;
import entities.PhysicalPerson;

public class Polymorphism3 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List <LegalEntity> persons = new ArrayList<>();
		
		System.out.print("Enter the # of tax payers: ");
		int nTaxPayers = sc.nextInt();
		
		for (int i = 1; i <= nTaxPayers; i++) {
			System.out.print("Individual or Company? (i/c): ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			if (ch == 'c') {
				System.out.print("Number of employees: ");
				int nEmployees = sc.nextInt();
				persons.add(new JuridicalPerson(name, annualIncome, nEmployees));
			}
			else {
				System.out.print("Health expenditures: ");
				double healthExpenses = sc.nextDouble();
				persons.add(new PhysicalPerson(name, annualIncome, healthExpenses));
			}
		}
		
		System.out.println();
		System.out.println("Taxes PAID: ");
		
		double totalTax = 0;
		for (LegalEntity p : persons) {
			totalTax += p.tax();
			System.out.println(p.getName() + ": $ " + String.format("%.2f", p.tax()));
		}

		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", totalTax));
		
		
		sc.close();

		
	}

}
