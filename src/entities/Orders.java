package entities;

import java.util.Date;

public class Orders {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int client_id;

	// client_id
	public void setclient_id(int value) {
		client_id = value;
	}

	public int getclient_id() {
		return client_id;
	}

	private int account_id;

	// account_id
	public void setaccount_id(int value) {
		account_id = value;
	}

	public int getaccount_id() {
		return account_id;
	}

	private int total_price;

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	private String date_of_order;

	// date_of_order
	public void setdate_of_order(String value) {
		date_of_order = value;
	}

	public String getdate_of_order() {
		return date_of_order;
	}

	private String date_of_system_installed;

	// date_of_system_installed
	public void setdate_of_system_installed(String value) {
		date_of_system_installed = value;
	}

	public String getdate_of_system_installed() {
		return date_of_system_installed;
	}

	private String date_of_complete;

	// date_of_complete
	public void setdate_of_complete(String value) {
		date_of_complete = value;
	}

	public String getdate_of_complete() {
		return date_of_complete;
	}

	private int status;

	// status
	public void setstatus(int value) {
		status = value;
	}

	public int getstatus() {
		return status;
	}

	public Orders(int client_id, int account_id, int total_price, String date_of_order, String date_of_system_installed,
			String date_of_complete, int status) {
		super();
		this.client_id = client_id;
		this.account_id = account_id;
		this.total_price = total_price;
		this.date_of_order = date_of_order;
		this.date_of_system_installed = date_of_system_installed;
		this.date_of_complete = date_of_complete;
		this.status = status;
	}

	public Orders() {
		super();
	}

}
