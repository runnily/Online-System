
//Author: Adanna Obibuaku
//Date: 8/12/16
//Purpose: This holds the properties of the sandwich; including the type of bread, fillings and toppings
import java.util.List;
import java.util.ArrayList;

public class Sandwich implements Food {

	private Bread bread;
	private List<Filling> fillings = new ArrayList<>();
	private List<Topping> toppings = new ArrayList<>();
	private final double VAT_APPLIED = 0.05;

	public Sandwich(Bread bread, List<Filling> fillings, List<Topping> toppings) {
		this.bread = bread;
		this.fillings = fillings;
		this.toppings = toppings;
	}

	public Bread getBread() {
		return bread; // returns the bread data type
	}

	public List<Filling> getFillings() {
		return fillings; // returns all the fillings within a list
	}

	public List<Topping> getToppings() {
		return toppings; // returns all the toppings within a list
	}

	public boolean isVeg() {
		/*
		 * This function searches through all the ingredients contained in the sandwich
		 * including the bread, fillings and toppings to check whether each ingredient
		 * Property isVeg is set to true. If true for all ingredients; it indicates the
		 * whole sandwich is vegetarian
		 */
		boolean isVeg = true; // initially assume isVeg is true

		if (getBread().getVeg() == false) {
			isVeg = false; // change to false when the property of isVeg is set to false
		}

		for (Ingredients fill : getFillings()) {
			if (fill.getVeg() == false) {
				isVeg = false; // change to false once found the property of a fill where isVeg is set to false
			}
		}

		for (Ingredients top : getToppings()) {
			if (top.getVeg() == false) {
				isVeg = false; // change to false once found the property of a top where isVeg is set to false
			}
		}

		return isVeg; // returns the true indicating all the ingredients contained in sandwich is
						// vegetarian
	}

	public boolean isNutFree() {
		/*
		 * This function searches through all the ingredients contained in the sandwich
		 * including the bread, fillings and toppings to check whether each ingredient
		 * Property isNutFree is set to true. If true for all ingredients; it indicates
		 * the whole sandwich is nut free.
		 */
		boolean isNut = true; // initially assume isNutFree is true

		if (getBread().getNutFree() == false) {
			isNut = false; // change to false when the property of isNurFree is set to false
		}

		for (Ingredients fill : getFillings()) {
			if (fill.getNutFree() == false) {
				isNut = false; // change to false once found the property of a fill where isNutFree is set to
								// false
			}
		}

		for (Ingredients top : getToppings()) {
			if (top.getNutFree() == false) {
				isNut = false; // change to false once found the property of a top where isNutFree is set to
								// false
			}
		}

		return isNut; // returns the true indicating all the ingredients contained in sandwich is nut
						// free
	}

	public String fillings() {
		/*
		 * This functions searches through the fill list to get the name of the sandwich
		 * and get the price of the fill. These property is then formatted into a String
		 * to show the name and price of fill in appropriate format to be used later for
		 * the user.
		 */
		String scriptFill = ""; // initially set variable
		for (Ingredients fill : getFillings()) {
			// within each fill in the list it adds the property into the formatted string
			scriptFill += String.format("Fillings: %-20s\t Price:\t %.2f \n", fill.getName(), fill.getPrice());

		}
		return scriptFill; // returns the formatted string
	}

	public String toppings() {
		/*
		 * This functions searches through the top list to get the name of the sandwich
		 * and get the price of the top. These property is then formatted into a String
		 * to show the name and price of top in appropriate format to be used later for
		 * the user.
		 */
		String scriptTop = ""; // initially set variable
		for (Ingredients top : getToppings()) {
			// within each top in the list it adds the property into the formatted string
			scriptTop += String.format("Toppings: %-20s\t Price:\t %.2f \n", top.getName(), top.getPrice());
		}
		return scriptTop; // returns the formatted string
	}

	public String bread() {
		/*
		 * This function returns the formatted string containing property of the bread
		 * including name and price. This displays the property of the bread in
		 * appropriate format to be later used for the user.
		 */
		return String.format("Bread:    %-20s\t Price:\t %.2f \n", getBread().getName(), getBread().getPrice());
	}

	public String script() {
		/*
		 * This function returns a string containing the information about the
		 * ingredients of the sandwich including the price of each ingredient and name
		 */
		String script = " "; // initially set variable
		script = fillings() + toppings() + bread(); // concentration of strings
		return script; // returns the string
	}

	public double tax() {
		// This function returns the tax applied to the sandwich
		double tax = 0;
		tax = taxExclusive() * VAT_APPLIED; // Calculates tax
		return tax; // returns tax
	}

	public double taxExclusive() {
		/*
		 * This function calculates the price of the sandwich by going through each fill
		 * and top contained in the sandwich and adding their price property. It then
		 * gets the price of the bread property and returns full total of sandwich
		 */
		double price = 0;
		for (Ingredients fill : fillings) {
			price += fill.getPrice(); // going through each fill to add to the price
		}
		for (Ingredients top : toppings) {
			price += (top.getPrice()); // going through each top to add to the price

		}
		price += this.bread.getPrice(); // lastly adding the bread price
		price = Math.round(price); // the rounding it
		return price; // To return the overall price
	}

	public double taxInclusive() {
		/*
		 * This function calculates the overall total of the sandwich by adding the tax
		 * and the overall price together.
		 */
		double total;
		total = taxExclusive() + tax(); // Calculates total
		return total; // returns total
	}
}
