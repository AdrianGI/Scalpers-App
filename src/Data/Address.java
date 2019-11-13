package Data;

public class Address {

	public String name;
	public String surname;
	public String enterprise;
	public int phone;
	public String addreess;
	public String city;
	public String country;
	public int pc; // postal code
	public String province;
	public int id;

	public Address(String name, String surname, String enterprise, int phone, String addreess, String city,
			String country, int pc, String province, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.enterprise = enterprise;
		this.phone = phone;
		this.addreess = addreess;
		this.city = city;
		this.country = country;
		this.pc = pc;
		this.province = province;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddreess() {
		return addreess;
	}

	public void setAddreess(String addreess) {
		this.addreess = addreess;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}
