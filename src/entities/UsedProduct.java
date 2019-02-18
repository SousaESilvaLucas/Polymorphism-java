package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date manufacturedDate;
	
	public UsedProduct() {
		
	}

	public UsedProduct(String name, Double price, Date manufacturedDate) {
		super(name, price);
		this.manufacturedDate = manufacturedDate;
	}

	public Date getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder(super.priceTag());
		sb.insert(sb.indexOf("$") -1, " (used)");
		sb.append(" (Manufacture date: " + sdf.format(manufacturedDate) + ")");
		
		return sb.toString();
		
	}
}
