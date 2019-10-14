package Data;

public class Product {

	public int ref;
	public String type;
	public String colour;
	public int size;
	public String title;
	public String desc;
	public int stock;
	public double price;
	public String gender;
	public String route;
	// public double discount;

	public Product(int ref, String type, String colour, int size, String title, String desc, int stock, double price,
			String gender, String route) {
		super();
		this.ref = ref;
		this.type = type;
		this.colour = colour;
		this.size = size;
		this.title = title;
		this.desc = desc;
		this.stock = stock;
		this.price = price;
		this.gender = gender;
		this.route = route;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

}
