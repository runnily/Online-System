
//Author: Adanna Obibuaku
//Date: 10/12/16
//Purpose: An abstract class to be used later to create choices for the user.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeSandwich {
	private Bread breadChoice;
	private List<Filling> fillingsChoice = new ArrayList<>();
	private List<Topping> toppingsChoice = new ArrayList<>();

	public Map<String, Bread> bread() {
		/*
		 * A hash map which contains the key codes corresponding to a different bread
		 * data type ingredient.
		 */
		Map<String, Bread> bread = new HashMap<>();
		bread.put("1", new Bread("Hearty Italian", 5, true, true));
		bread.put("2", new Bread("French Baguette", 5, true, true));
		bread.put("3", new Bread("Jalapeño Cheese", 6, true, true));
		bread.put("4", new Bread("Monterey Cheddar", 6, true, true));
		bread.put("5", new Bread("Parmesan Oregano", 7, true, true));
		bread.put("6", new Bread("Roasted Garlic", 7, true, false));
		bread.put("7", new Bread("Rosemary & Sea Salt", 8, true, false));
		bread.put("7", new Bread("Rye Bread", 8, true, false));
		bread.put("9", new Bread("Nut-Free Bread", 5, true, true));
		return bread; // returns the map
	}

	public Map<String, Filling> fillings() {
		/*
		 * A hash map which contains the key codes corresponding to a different fillings
		 * data type ingredient.
		 */
		Map<String, Filling> fillings = new HashMap<>();
		fillings.put("1", new Filling("MeatBalls", 0.1, false, true));
		fillings.put("2", new Filling("Chicken Tika", 0.1, false, true));
		fillings.put("3", new Filling("Chicken Mayo", 0.1, false, true));
		fillings.put("4", new Filling("Ham", 0.5, false, true));
		fillings.put("5", new Filling("Tuna", 0, false, true));
		fillings.put("6", new Filling("Egg (White) Omelet", 0, false, true));
		fillings.put("7", new Filling("Chicken & Bacon", 0.5, false, true));
		fillings.put("8", new Filling("Steak", 0.5, false, true));
		fillings.put("9", new Filling("Veggie Delight", 0, true, true));
		return fillings; // returns the fillings
	}

	public Map<String, Topping> toppings() {
		/*
		 * A hash map which contains the key codes corresponding to a different toppings
		 * data type ingredient.
		 */
		Map<String, Topping> toppings = new HashMap<>();
		toppings.put("1", new Topping("Banana Peppers", 0.1, true, true));
		toppings.put("2", new Topping("Jalapenos", 0.1, true, true));
		toppings.put("3", new Topping("Olives", 0.1, true, true));
		toppings.put("4", new Topping("Pickles", 0.2, true, true));
		toppings.put("5", new Topping("Vegetables", 0.1, true, false));
		toppings.put("6", new Topping("Cheese", 0.2, false, true));
		toppings.put("7", new Topping("Onions", 0.1, true, true));
		toppings.put("8", new Topping("BBQ", 0.1, true, true));
		toppings.put("9", new Topping("Mayo", 0.2, true, true));
		toppings.put("A", new Topping("Ranch", 0.3, true, true));
		toppings.put("B", new Topping("Sweet Onions", 0.1, true, false));
		toppings.put("C", new Topping("Honey Mustard", 0.1, true, false));
		return toppings; // returns the toppings
	}

	public void setChoiceBread(String breadChoice) {
		/*
		 * This function gets the user bread choice indicated using the key and creates
		 * a new bread class corresponding to the class within the map, bread
		 */

		if (bread().containsKey(breadChoice)) { // ...if the string (breadChoice) obtained by the user is valid
			// set the variable breadChoice to class within the map bread with the
			// corresponding key code
			this.breadChoice = bread().get(breadChoice);
		} else { // ...else
			// throw an error
			throw new IllegalArgumentException("This choice is not available");
		}
	}

	public void addChoiceFillings(String fillingsChoice) {
		/*
		 * This function gets the user fill choice indicated using the key and creates a
		 * new filling class corresponding to the class within the map, fillings
		 */
		if (fillings().containsKey(fillingsChoice)) { // ...if the string (fillingsChoice) obtained by the user is valid
			// set the variable fillingChoice to class within the map bread with the
			// corresponding key code
			this.fillingsChoice.add(fillings().get(fillingsChoice));
		} else {// ...else
			// throw an error
			throw new IllegalArgumentException("This choice is not available");
		}
	}

	public void addChoiceToppings(String toppingsChoice) {
		/*
		 * This function gets the user top choice indicated using the key and creates a
		 * new toppings class corresponding to the class within the map, toppings
		 */
		if (toppings().containsKey(toppingsChoice)) {// ...if the string (toppingsChoice) obtained by the user is valid
			// set the variable toppingChoice to class within the map bread with the
			// corresponding key code
			this.toppingsChoice.add(toppings().get(toppingsChoice));
		} else {// ...else
			// throw an error
			throw new IllegalArgumentException("This choice is not available");
		}
	}

	public Bread getChoiceBread() {
		return breadChoice; // returns the users bread choice
	}

	public List<Filling> getChoiceFillings() {
		return fillingsChoice; // returns the fillings choice
	}

	public List<Topping> getChoiceToppings() {
		return toppingsChoice; // returns the toppings choice
	}

	public Food build() {
		// this function builds a sandwich corresponding to the choices of ingredients
		// by the user.
		Food s = new Sandwich(getChoiceBread(), getChoiceFillings(), getChoiceToppings()); // create food
		return s;
	}

	public String recipt() {
		return build().recipt(); // returns the receipt of the sandwich
	}

}
