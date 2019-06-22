package entities;

import java.util.Date;

public class Order_Detail {
	private Orders order_id;

	// order_id
	public void setorder_id(Orders value) {
		order_id = value;
	}

	public Orders getorder_id() {
		return order_id;
	}

	private Product_Elevation product_id;

	// product_id
	public void setproduct_id(Product_Elevation value) {
		product_id = value;
	}

	public Product_Elevation getproduct_id() {
		return product_id;
	}

	private int num_of_system_installed;

	// num_of_system_installed
	public void setnum_of_system_installed(int value) {
		num_of_system_installed = value;
	}

	public int getnum_of_system_installed() {
		return num_of_system_installed;
	}

	private double price;

	// price
	public void setprice(double value) {
		price = value;
	}

	public double getprice() {
		return price;
	}

	private int warranty_period;

	// warranty_period
	public void setwarranty_period(int value) {
		warranty_period = value;
	}

	public int getwarranty_period() {
		return warranty_period;
	}

	private Date warranty_expire_date;

	// warranty_expire_date
	public void setwarranty_expire_date(Date value) {
		warranty_expire_date = value;
	}

	public Date getwarranty_expire_date() {
		return warranty_expire_date;
	}

	public Order_Detail(Orders order_id, Product_Elevation product_id, int num_of_system_installed, double price,
			int warranty_period, Date warranty_expire_date) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.num_of_system_installed = num_of_system_installed;
		this.price = price;
		this.warranty_period = warranty_period;
		this.warranty_expire_date = warranty_expire_date;
	}

	public Order_Detail() {
		super();
	}

}
