
//Author: Adanna Obibuaku
//Date: 10/12/16
//Purpose: This sandwich has predefined sandwiches set up for the user to choose from
import java.util.Arrays;
import java.util.Scanner;

public class SandwichMenu extends TypeSandwich {
	private String choice;

	public void setChoice(String choice) {
		/*
		 * This function sets the user choice, by firstly checking if the choice is a
		 * valid choice within the menu
		 */
		if (Arrays.asList("1", "2", "3").contains(choice)) { // ...of user choice is within the list
			this.choice = choice; // set choice
		} else {// ...else throw an error
			throw new IllegalArgumentException("This choice is not available");
		}
	}

	public String getChoice() {
		return choice; // returns users choice
	}

	public String menu() { // returns the menu for the user to see
		String menu = "\n------------------------Menu-------------------------\n" + "\t\t(1) Tuna\n"
				+ "\t\t(2) Steak and Cheese\n" + "\t\t(3) Ham"
				+ "\n-----------------------------------------------------\n";

		return menu;
	}

	public String tuna() {
		/*
		 * Creates a predefined sandwich called tuna which calls upon methods of set up
		 * the type of ingredients (bread, fillings, toppings etc) for the tuna sandwich
		 */
		setChoiceBread("2");
		addChoiceFillings("5");
		addChoiceToppings("9");
		addChoiceToppings("5");
		return recipt();
	}

	public String steakAndCheese() {
		/*
		 * Creates a predefined sandwich called steak and cheese which calls upon
		 * methods of set up the type of ingredients (bread, fillings, toppings etc) for
		 * the steak and cheese sandwich
		 */
		setChoiceBread("1");
		addChoiceFillings("8");
		addChoiceToppings("2");
		addChoiceToppings("6");
		addChoiceToppings("A");
		return recipt();
	}

	public String ham() {
		/*
		 * Creates a predefined sandwich called ham which calls upon methods of set up
		 * the type of ingredients (bread, fillings, toppings etc) for the ham Sandwich
		 */
		setChoiceBread("5");
		addChoiceFillings("4");
		addChoiceToppings("5");
		addChoiceToppings("6");
		addChoiceToppings("9");
		return recipt();
	}

	public String choosen() {
		/*
		 * Returns the corresponding sandwich from the user input indicated by the the
		 * key code
		 */
		String choosen = "";
		if (getChoice().equals("1")) { // if input is "1"
			choosen = tuna(); // the user wants a tuna sandwich
		}
		if (getChoice().equals("2")) { // if input is "2"
			choosen = steakAndCheese(); // the user wants a steak and cheese sandwich
		}
		if (getChoice().equals("3")) { // if input is "3"
			choosen = ham(); // the user wants a ham sandwich
		}
		return choosen; // return information about chosen sandwich
	}

	public static void main(String[] args) {
		SandwichMenu c = new SandwichMenu();
		Scanner n = new Scanner(System.in);

		boolean invalid = true; // set invalid to true
		while (invalid) {
			try { // trying looping until provides a valid input
				System.out.println(c.menu()); // return the menu for the user to see
				// prompt below printed to the user; so the user should know what to do.
				System.out.println("Select ONLY one sandwich by key code\n" + "\t\t**note*** "
						+ "\nFirst input would ONLY be taken on " + "\nA line with multiple key code inputs");
				System.out.print("Select a Sandwhich by key code> "); // prompt asking for input for key code
				String choice = n.nextLine(); // taken in input
				c.setChoice(choice);// to makes sure its takes the whole input
				System.out.println(c.choosen()); // returns information about receipt & info about sandwich
				System.out.println(c.build().facet()); // return characteristics of sandwich if its vegetarian etc
				invalid = false; // set invalid false
			} catch (Exception e) { // catch all exceptions
				System.out.println("Inputs appear to be wrong "// inform user they did something wrong
						+ "\nPlease Try again by selecting any key\nOr Select key (-) to stop program");
				System.out.print("> "); // prompt for their input
				System.out.flush();
				String stop = n.nextLine().substring(0);
				if (stop.equals("-")) { // when key is "-" program stops
					System.out.println("-------------------Program Stopped-------------------");
					invalid = false; // stop loop
				}
			}
		}
		n.close();
	}

}
