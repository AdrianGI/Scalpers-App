package Data;

public class Product {

	public String type;
	public String colour;
	public int size;
	public int ref;
	public String title;
	public String desc;
	public int stock;
	public double prize;
	//public double discount;
	
	
	public Product(String type, String colour, int size, int ref, String title, String desc, int stock, double prize) {
		super();
		this.type = type;
		this.colour = colour;
		this.size = size;
		this.ref = ref;
		this.title = title;
		this.desc = desc;
		this.stock = stock;
		this.prize = prize;
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


	public int getRef() {
		return ref;
	}


	public void setRef(int ref) {
		this.ref = ref;
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


	public double getPrize() {
		return prize;
	}


	public void setPrize(double prize) {
		this.prize = prize;
	}
	
	
	
	
}
