package entities;

import java.util.Date;

public class Complain {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int order_id;

	// order_id
	public void setorder_id(int value) {
		order_id = value;
	}

	public int getorder_id() {
		return order_id;
	}

	private int account_id;

	// account_id
	public void setaccount_id(int value) {
		account_id = value;
	}

	public int getaccount_id() {
		return account_id;
	}

	private boolean is_chargeable;

	// is_chargeable
	public void setis_chargeable(boolean value) {
		is_chargeable = value;
	}

	public boolean getis_chargeable() {
		return is_chargeable;
	}

	private String problem;

	// problem
	public void setproblem(String value) {
		problem = value;
	}

	public String getproblem() {
		return problem;
	}

	private Date date_complain;

// date_complain
	public void setdate_complain(Date value) {
		date_complain = value;
	}

	public Date getdate_complain() {
		return date_complain;
	}

	private int status_id;

// status_id
	public void setstatus_id(int value) {
		status_id = value;
	}

	public int getstatus_id() {
		return status_id;
	}

	private String technician_person;

// technician_person
	public void settechnician_person(String value) {
		technician_person = value;
	}

	public String gettechnician_person() {
		return technician_person;
	}

	public Complain(int order_id, int account_id, boolean is_chargeable, String problem, Date date_complain,
			int status_id, String technician_person) {
		super();
		this.order_id = order_id;
		this.account_id = account_id;
		this.is_chargeable = is_chargeable;
		this.problem = problem;
		this.date_complain = date_complain;
		this.status_id = status_id;
		this.technician_person = technician_person;
	}

	public Complain() {
		super();
	}

}
