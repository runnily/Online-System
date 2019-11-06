
//Author: Adanna Obibuaku
//Date: 11/12/16
//Purpose: This class builds and interface for the user to select their choices.
import java.util.Scanner;

public class SandwichChoice extends TypeSandwich {

	public String choicesBread() {
		/*
		 * This function goes through each element (of data type bread) within the map
		 * and gets the property of the bread name and price, to create a menu of bread
		 * choices the user can choose from.
		 */
		String bread = "\n--------------------Bread Choices--------------------";
		for (String k : bread().keySet()) { // ...looping through all the keys in the map bread
			bread += String.format("\n(%s) Bread:\t %-20s Price:\t %.2f", k, bread().get(k).getName(),
					bread().get(k).getPrice());
			// with each key it can now address each value (of data type bread) and get the
			// price and name
			// to be formatted in a string of appropriate to a user to see the bread
			// choices.
		}
		bread += "\n-----------------------------------------------------\n";
		return bread; // returns a menu of bread choices
	}

	public String choicesFillings() {
		/*
		 * This function goes through each element (of data type fillings) within the
		 * map and gets the property of the filling name and price, to create a menu of
		 * filling choices the user can choose from.
		 */
		String fill = "\n-----------------Filling Choices---------------------";
		for (String k : fillings().keySet()) { // ...looping through all the keys in the map filling
			fill += String.format("\n(%s) Filling:\t %-20s Price:\t %.2f", k, fillings().get(k).getName(),
					fillings().get(k).getPrice());
			// with each key it can now address each value (of data type filling) and get
			// the price and name
			// to be formatted in a string of appropriate to a user to see the filling
			// choices.
		}
		fill += "\n-----------------------------------------------------";
		return fill; // returns a menu of filling choices
	}

	public String choicesToppings() {
		/*
		 * This function goes through each element (of data type toppings) within the
		 * map and gets the property of the toppings name and price, to create a menu of
		 * toppings choices the user can choose from.
		 */
		String top = "\n-------------------Topping Choices-------------------";
		for (String k : toppings().keySet()) { // ...looping through all the keys in the map toppings
			top += String.format("\n(%s) Topping:\t %-20s Price:\t %.2f", k, toppings().get(k).getName(),
					toppings().get(k).getPrice());
			// with each key it can now address each value (of data type toppings) and get
			// the price and name
			// to be formatted in a string of appropriate to a user to see the fillings
			// choices.
		}
		top += "\n-----------------------------------------------------\n";
		return top; // returns a menu of toppings choices
	}

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		SandwichChoice s = new SandwichChoice();

		boolean invalidInputs = true;
		do { // loops until the user inputs become valid; (key codes correspond the the maps)
			try { // try to create a sandwich, once inputs are obtains else catches error when
					// inputs are invalid
				System.out.println(s.choicesBread()); // output choice of breads
				System.out.print("Select ONLY one Bread by the number code> "); // prompt for an input
				System.out.flush();
				String choice = key.nextLine();// obtain input
				if (choice.length() > 1) { // if length is more than 1 (-->to catch errors like '1 2')
					extracted(); // throw error
				}
				s.setChoiceBread(choice);/// get user choice to create the bread class

				System.out.println(s.choicesFillings()); // output choice of fillings
				System.out.print("\nHow many FILLINGS would you like> "); // prompt for an input
				System.out.flush();
				choice = key.nextLine(); // obtain input
				if (choice.length() > 1) { // if length is more than 1 (-->to catch errors like '1 2')
					extracted(); // throw error
				}
				int num = Integer.valueOf(choice);// change choice to a integer (--> it was taken in as a string to
													// check length
				for (int i = 0; i < num; i += 1) { // loop through the amount of fillings they choose
					// to ask for their choice
					System.out.print("Select a Filling by the number code> "); // prompt for an input
					System.out.flush();
					choice = key.nextLine(); // obtain input

					if (choice.length() > 1) { // if length is more than 1
						extracted(); // throw an error
					}
					s.addChoiceFillings(choice);// get user choice to create the fillings class

				}
				System.out.println(s.choicesToppings()); // output choice of toppings
				System.out.print("How many TOPPINGS would you like> "); // prompt for an input
				System.out.flush();
				choice = key.nextLine(); // obtain input
				if (choice.length() > 1) { // if length is more than 1
					extracted(); // throw error
				}
				num = Integer.valueOf(choice); // change to an integer
				for (int i = 0; i < num; i += 1) { // loop through the amount of toppings they choose
					// to ask for their choice
					System.out.print("Select a Topping by the number code> "); // prompt
					System.out.flush();
					choice = key.nextLine(); // obtain input
					if (choice.length() > 1) {
						extracted(); // ditto
					}
					s.addChoiceToppings(choice); // get user choice to create the toppings class
				}

				System.out.println(s.build().facet()); // prints out facet (characteristic of sandwich
				// if its nutFree or vegetarian (etc)
				System.out.println(s.recipt()); // print receipt
				invalidInputs = false; // set to false to stop loop
			} catch (Exception e) { // catches any exception
				System.out.println("Inputs appear to be wrong " // prompt to indicate inputs are invalid
						+ "\nPlease Try again by selecting any key\nOr Select key (-) to stop program");
				System.out.print("> "); // prompt to get input
				System.out.flush();
				String stop = key.nextLine().substring(0); // get input
				if (stop.equals("-")) { // if input is "-" make program stop
					System.out.println("-------------------Program Stopped-------------------"); // prompt
					invalidInputs = false; // to stop loop
				}
			}

		} while (invalidInputs);
		key.close();
	}

	private static void extracted() { // throw an error method.
		throw new IllegalArgumentException("Only 1 input");
	}
}
