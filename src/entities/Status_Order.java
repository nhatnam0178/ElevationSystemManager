package entities;

public class Status_Order {
	private int id;

	// id
	public void setid(int value) {
		id = value;
	}

	public int getid() {
		return id;
	}
	private String name;

// name
	public void setname(String value) {
		name = value;
	}

	public String getname() {
		return name;
	}

	public Status_Order(String name) {
		super();
		this.name = name;
	}

	public Status_Order() {
		super();
	}

}
