package entities;

public class Account {
	private String username;

// username
	public void setusername(String value) {
		username = value;
	}

	public String getusername() {
		return username;
	}

// 
	private String password;

// password
	public void setpassword(String value) {
		password = value;
	}

	public String getpassword() {
		return password;
	}

	private String name;

// name
	public void setname(String value) {
		name = value;
	}

	public String getname() {
		return name;
	}

	private boolean gender;

// gender
	public void setgender(boolean value) {
		gender = value;
	}

	public boolean getgender() {
		return gender;
	}

	private String email;

// email
	public void setemail(String value) {
		email = value;
	}

	public String getemail() {
		return email;
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

	public Account() {
	};

	public Account(String username, String password, String name, boolean gender, String email, String phone,
			String address) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

}