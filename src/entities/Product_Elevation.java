package entities;

import java.util.Date;

public class Product_Elevation {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String name;

// name
	public void setname(String value) {
		name = value;
	}

	public String getname() {
		return name;
	}

	private String type;

// type
	public void settype(String value) {
		type = value;
	}

	public String gettype() {
		return type;
	}

	private int price;


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private String date_of_order;

// date_of_order
	public void setdate_of_order(String value) {
		date_of_order = value;
	}

	public String getdate_of_order() {
		return date_of_order;
	}

	private int warranty;

// warranty
	public void setwarranty(int value) {
		warranty = value;
	}

	public int getwarranty() {
		return warranty;
	}

	private String warranty_expire_date;

// warranty_expire_date

	public String getwarranty_expire_date() {
		return warranty_expire_date;
	}

	public void setwarranty_expire_date(String value) {
		this.warranty_expire_date = value;
	}

	public Product_Elevation() {

	}

	public Product_Elevation(int id, String name, String type, int price, String date_of_order, int warranty,
			String warranty_expire_date) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.date_of_order = date_of_order;
		this.warranty = warranty;
		this.warranty_expire_date = warranty_expire_date;
	}

}
