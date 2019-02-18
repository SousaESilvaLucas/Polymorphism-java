package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class ExPolymorphism2 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List <Shape> shapeList = new ArrayList<>();
		
		System.out.print("Enter numer of shapes: ");
		int nShapes = sc.nextInt();
		
		for (int i = 1; i <= nShapes; i++) {
			System.out.println("Shape #" + i + " data:");
			System.out.print("Rectangle or Circle (r/c): ");
			char shapeType = sc.next().charAt(0);
			System.out.print("COLOR (BLACK/BLUE/RED): ");
			String color = sc.next();
			
			if (shapeType == 'c') {
				System.out.print("Radius: ");
				double radius = sc.nextDouble();
				shapeList.add(new Circle(Color.valueOf(color), radius));
			}
			else {
				System.out.print("Width: ");
				double width = sc.nextDouble();
				System.out.print("Height: ");
				double height = sc.nextDouble();
				shapeList.add(new Rectangle(Color.valueOf(color), height, width));
			}
		}
		
		System.out.println("SHAPE AREAS");
		for (Shape s : shapeList)
			System.out.println(String.format("%.2f", s.area()));
		
		sc.close();

	}

}
