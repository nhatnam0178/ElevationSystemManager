package entities;

public class Status_Complain {
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

	public Status_Complain(String name) {
		super();
		this.name = name;
	}

	public Status_Complain() {
		super();
	}

}
