
//Author: Adanna Obibuaku
//Date: 8/12/16
//Purpose: This holds class demonstrates the sandwich class working
import java.util.ArrayList;
import java.util.List;

public class SandwichBuild {

	public static void main(String[] args) {

		List<Filling> fillings = new ArrayList<>(); // creates new list for the fillings
		fillings.add(new Filling("Chicken", 0.5, false, true)); // add these fillings data type to the list
		// fillings.add(new Filling("MeatBalls", 0.7, false, true));

		List<Topping> toppings = new ArrayList<>(); // creates new list for the toppings
		toppings.add(new Topping("Onions", 0.2, true, true)); // add these fillings data type to the list
		toppings.add(new Topping("Cheese", 0.4, true, true));
		toppings.add(new Topping("Mayonnaise", 0.1, true, true));

		// creates a sandwich class with the ingredients put into the receipt
		Sandwich s = new Sandwich(new Bread("Italian", 5, true, true), fillings, toppings);
		System.out.println(s.facet());
		System.out.println(s.recipt()); // prints recipts indicating its working
	}

}
