package entities;

public class Department {
	private String name;

	// name
	public void setname(String value) {
		name = value;
	}

	public String getname() {
		return name;
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public Department() {
		super();
	}

}
