package entities;

import java.util.Date;

public class Order_Detail {
	private int order_id;

	// order_id
	public void setorder_id(int i) {
		order_id = i;
	}

	public int getorder_id() {
		return order_id;
	}

	private int product_id;

	// product_id
	public void setproduct_id(int value) {
		product_id = value;
	}

	public int getproduct_id() {
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

	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private int warranty_period;

	// warranty_period
	public void setwarranty_period(int value) {
		warranty_period = value;
	}

	public int getwarranty_period() {
		return warranty_period;
	}

	private String warranty_expire_date;

	// warranty_expire_date
	public void setwarranty_expire_date(String value) {
		warranty_expire_date = value;
	}

	public String getwarranty_expire_date() {
		return warranty_expire_date;
	}

	public Order_Detail(int order_id, int product_id, int num_of_system_installed, int price, int warranty_period,
			String warranty_expire_date) {
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
