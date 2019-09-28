package Data;

public class User {

	public String name;
	public String surname;
	public String email;
	public String password;
	public int phone;
	public int pc; // postal code
	public String gender;
	public String birthDate;

	public User(String name, String surname, String email, String password, int phone, int postalCode, String gender,
			String birthDate) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.pc = postalCode;
		this.gender = gender;
		this.birthDate = birthDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getPostalCode() {
		return pc;
	}

	public void setPostalCode(int postalCode) {
		this.pc = postalCode;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

}