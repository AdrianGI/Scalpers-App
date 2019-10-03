package Data;

public class Order {

	public String ref;
	public String date;
	public double price;
	public String status;
	public String bill;

	public Order(String ref, String date, double price, String status, String bill) {
		super();
		this.ref = ref;
		this.date = date;
		this.price = price;
		this.status = status;
		this.bill = bill;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

}
