package Data;

import java.util.Date;

public class Cart {

	private String title;
	private String colour;
	private String size;
	private int uds;
	private String ref;
	private double price;
	private String route;

	public Cart(String title, String colour, String size, int uds, String ref, double price, String route) {
		super();
		this.title = title;
		this.colour = colour;
		this.size = size;
		this.uds = uds;
		this.ref = ref;
		this.price = price;
		this.route = route;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getUds() {
		return uds;
	}

	public void setUds(int uds) {
		this.uds = uds;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
