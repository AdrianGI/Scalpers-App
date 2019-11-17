package Data;

public class Order {

	
	public String ref;
	public String date;
	public double total;
	
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public Order(String ref, String date, double total) {
		super();
		this.ref = ref;
		this.date = date;
		this.total = total;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	

}