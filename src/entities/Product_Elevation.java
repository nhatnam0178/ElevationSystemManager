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

	private double price;

// price
	public void setprice(double value) {
		price = value;
	}

	public double getprice() {
		return price;
	}

	private Date date_of_order;

// date_of_order
	public void setdate_of_order(Date value) {
		date_of_order = value;
	}

	public Date getdate_of_order() {
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

	private int warranty_expire_date;

// warranty_expire_date
	public void setwarranty_expire_date(int value) {
		warranty_expire_date = value;
	}

	public int getwarranty_expire_date() {
		return warranty_expire_date;
	}

	public Product_Elevation(String name, String type, double price, Date date_of_order, int warranty,
			int warranty_expire_date) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.date_of_order = date_of_order;
		this.warranty = warranty;
		this.warranty_expire_date = warranty_expire_date;
	}

	public Product_Elevation() {
		super();
	}

}
