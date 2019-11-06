//Author: Adanna Obibuaku
//Date: 8/12/16
//Purpose: To implements an abstract class for the ingredients for a particular food.

public abstract class Ingredients {
	/*
	 * This is set as abstract because no one really needs to access; so it prevents
	 * people from instancing it; used to stop repeating coding and will be extended
	 * by other classes
	 */
	private String name;
	private double price;
	private boolean veg;
	private boolean nutFree;

	public Ingredients(String name, double price, boolean veg, boolean nutFree) {
		this.name = name;
		this.price = price; // A constructor to set the variables.
		this.veg = veg;
		this.nutFree = nutFree;
	}

	public String getName() {
		return name; // returns name
	}

	public double getPrice() {
		return price; // returns the price
	}

	public boolean getVeg() {
		return veg; // returns true if vegetarian
	}

	public boolean getNutFree() {
		return nutFree; // returns true if nut free
	}
}
