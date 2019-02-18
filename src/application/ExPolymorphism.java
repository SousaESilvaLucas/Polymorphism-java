package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class ExPolymorphism {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products ");
		int nProducts = sc.nextInt();
		
		for (int i = 1; i <= nProducts; i++) {
			System.out.println("Product data #" +i);
			System.out.print("Common, used or imported (c/u/i): ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if (ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
			}
			else if (ch == 'u') {
				System.out.print("Manufactured Date (dd/MM/yyyy): ");
				Date manufacturedDate = sdf.parse(sc.next());
				products.add(new UsedProduct(name, price, manufacturedDate));
			}
			else {
				products.add(new Product(name, price));			
			}
		}
		
		System.out.println("PRICE TAGS:");
		
		for (Product p : products)
			System.out.println(p.priceTag());
		
		sc.close();
	}

}
