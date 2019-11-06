//Author: Adanna Obibuaku
//Date: 8/12/16
//Purpose: To implements an abstract class food for the prototype for the online system

public interface Food {

	public double taxInclusive(); // returns the cost without tax

	public double taxExclusive(); // returns the cost of tax

	public double tax(); // returns the tax

	public String script(); // returns a description of food

	public boolean isVeg(); // returns true if the food is vegetarian

	public boolean isNutFree(); // returns true if the food is nut free

	public default String facet() {
		/*
		 * A function which will returns a string indicating if the food is vegetarian
		 * or nut free. This is dependent on the methods isVeg() and isNutFree() to
		 * return true or false; so the corresponding message would display.
		 */
		String facet = "\n-------------------Characteristics-------------------"; // display Title
		if (isVeg()) {
			facet += "\nVeggie: True"; // Indication that its vegetarian
		}

		if (isNutFree()) {
			facet += "\nNutFree: True"; // Indication that its nut free
		}

		facet += "\n-----------------------------------------------------";
		return facet;
	}

	public default String recipt() {
		// Gives the user their receipt
		return String.format(
				"\n======================Receipt========================\n" + script()
						+ "\n=====================================================\n"
						+ "\t\tSUBTOTAL £%5.2f \n\t\tSales Tx £%5.2f"
						+ "\n\t\tTotal    £%5.2f \n=====================================================\n",
				taxExclusive(), tax(), taxInclusive());
	}

}
