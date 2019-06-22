package entities;

import java.util.Date;

public class Orders {
	private Client client_id;

	// client_id
	public void setclient_id(Client value) {
		client_id = value;
	}

	public Client getclient_id() {
		return client_id;
	}

	private Account account_id;

	// account_id
	public void setaccount_id(Account value) {
		account_id = value;
	}

	public Account getaccount_id() {
		return account_id;
	}

	private double total_price;

	// total_price
	public void settotal_price(double value) {
		total_price = value;
	}

	public double gettotal_price() {
		return total_price;
	}

	private Date date_of_order;

	// date_of_order
	public void setdate_of_order(Date value) {
		date_of_order = value;
	}

	public Date getdate_of_order() {
		return date_of_order;
	}

	private Date date_of_system_installed;

	// date_of_system_installed
	public void setdate_of_system_installed(Date value) {
		date_of_system_installed = value;
	}

	public Date getdate_of_system_installed() {
		return date_of_system_installed;
	}

	private Date date_of_complete;

	// date_of_complete
	public void setdate_of_complete(Date value) {
		date_of_complete = value;
	}

	public Date getdate_of_complete() {
		return date_of_complete;
	}

	private Status_Order status;

	// status
	public void setstatus(Status_Order value) {
		status = value;
	}

	public Status_Order getstatus() {
		return status;
	}

	public Orders(Client client_id, Account account_id, double total_price, Date date_of_order,
			Date date_of_system_installed, Date date_of_complete, Status_Order status) {
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
