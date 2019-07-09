package entities;

public class Client {
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

	private String phone;

	// phone
	public void setphone(String value) {
		phone = value;
	}

	public String getphone() {
		return phone;
	}

	private String address;

	// address
	public void setaddress(String value) {
		address = value;
	}

	public String getaddress() {
		return address;
	}

	private String company_name;

	// company_name
	public void setcompany_name(String value) {
		company_name = value;
	}

	public String getcompany_name() {
		return company_name;
	}

	public Client() {
		super();
	}

	public Client(String name, String phone, String address, String company_name) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.company_name = company_name;
	}
}
