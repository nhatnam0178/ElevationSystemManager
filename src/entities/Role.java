package entities;

public class Role {
	private String name;

// name
	public void setname(String value) {
		name = value;
	}

	public String getname() {
		return name;
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public Role() {
		super();
	}

}
