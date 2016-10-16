package NIIT;

class User{
	private String name;
	private String email;
	private String phone;
	
	User(){
		this.name = null;
		this.email = null;
		this.phone = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}



