import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	/*
	 * Displays the intro message informing the user of various cheeses sold 
	 * while populating the names and prices arrays, and initializing the
	 * amounts array.
	 */
	public static void intro(String[] names, double[] prices, double[] amounts) {
		int maxCheese = names.length;
		System.out.println("\nWe sell " + maxCheese + " kinds of Cheese:");

		// Three Special Cheeses
		if (maxCheese > 0) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
			System.out.println(names[0] + ": $" + prices[0] + " per pound");
		}
		if (maxCheese > 1) {
			names[1] = "Red Hawk";
			prices[1] = 40.50;
			System.out.println(names[1] + ": $" + prices[1] + " per pound");
		}
		if (maxCheese > 2) {
			names[2] = "Teleme";
			prices[2] = 17.25;
			System.out.println(names[2] + ": $" + prices[2] + " per pound");
		}

		Random ranGen = new Random(100);

		for (int i = 3; i < maxCheese; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;

			System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}

	}
	
	/*
	 * Gets the amount of each cheese the user would like to purchase and populates
	 * the amounts array with the user inputs. Performs with input validation 
	 * (amount >= 0 and multiple of 0.5).
	 */
	public static void getAmount(Scanner sc, String[] names, double[] amounts) {
		int maxCheese = names.length;
		for (int i = 0; i < maxCheese; i++) {
			System.out.print("Enter the amount of " + names[i] + " in lbs: ");
			amounts[i] = sc.nextDouble();
			while ((amounts[i] % 0.5 != 0) || (amounts[i] < 0)) {
				if (amounts[i] < 0) {
					System.out.print("Invalid input. Enter a value >= 0: ");
				} else {
					System.out.print("Invalid input. Enter a value that's a multiple of 0.5: ");
				}
				amounts[i] = sc.nextDouble();
			}
		}
	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	public static void itemizedList(String[] names, double[] prices, double[] amounts) {
		int maxCheese = names.length;
		double temp = 0;
		for (int i = 0; i < maxCheese; i++) {
			temp = temp + amounts[i];
		}
		if (temp == 0)
			System.out.println("No items were purchased.");
		for (int i = 0; i < maxCheese; i++) {
			if (amounts[i] > 0) {
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amounts[i], names[i], prices[i], prices[i]*amounts[i]);
			}
		}
		
	}
	
	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	public static double calcSubTotal(double[] prices, double[] amounts) {
		int maxCheese = prices.length;
		double subtotal = 0;
		for (int i = 0; i < maxCheese; i++) {
			subtotal = subtotal + (amounts[i] * prices[i]);
		}
		return subtotal;
	}

	/*
	 *  Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 *  stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 */
	public static double[] discountSpecials(double[] amounts, double[] prices){
		int maxCheese = amounts.length;
		double[] disSpecials = new double[amounts.length];
		if (maxCheese > 0)
			disSpecials[0] = (int)(amounts[0]) * (prices[0] / 2);
		if (maxCheese > 1)
			disSpecials[1] = (int)(amounts[1] * 2 / 3) * (prices[1] / 2);
		return disSpecials;		
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total.
	 */
	public static double printSubTotals(double subTotal, double[] disSpecials) {
		System.out.printf("\nOriginal Sub Total:               $%.2f\n", subTotal);
		System.out.println("Specials...");

		double newSubtotal = subTotal;
		for (int i = 0; i < disSpecials.length; i++) {
			if (disSpecials[i] > 0) {
				if (i == 0)
					System.out.printf("Humboldt Fog (Buy 1 Get 1 Free): -$%.2f\n", disSpecials[i]);
				if (i == 1)
					System.out.printf("Red Hawk (Buy 2 Get 1 Free):     -$%.2f\n", disSpecials[i]);
				newSubtotal = newSubtotal - disSpecials[i];
			}
		}
		if (newSubtotal == subTotal)
			System.out.println("None                             -$0.0");
		System.out.printf("New Sub Total:                    $%.2f\n", newSubtotal);
		return newSubtotal;
	}


	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total.
	 */
	public static void printFinalTotal(double newSubTotal) {
		double newDiscount = 0;
		if ((newSubTotal > 150) && (newSubTotal < 250)) {
			newDiscount = newSubTotal * 0.10;
			System.out.printf("Additional 10%% Discount:         -$%.2f\n", newDiscount);
		} else if (newSubTotal > 250) {
			newDiscount = newSubTotal * 0.25;
			System.out.printf("Additional 25%% Discount:         -$%.2f\n", newDiscount);
		} else {
			System.out.printf("Additional 0%% Discount:          -$%.2f\n", newDiscount);
		}
		double finalTotal = newSubTotal - newDiscount;
		System.out.printf("Final Total:                      $%.2f\n", finalTotal);
	}
	
	/*
	 * Program starts here
	 */
	public static void main(String[] args) {

		final int MAXCHEESE;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		MAXCHEESE = sc.nextInt();


		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		intro(names, prices, amounts);

		getAmount(sc, names, amounts);

		double subTotal = calcSubTotal(prices, amounts);
		
		
		if (MAXCHEESE != 0 ) {
			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			int display = sc.nextInt();
			
			if (display == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));
		
		printFinalTotal(newSubTotal);
		
		sc.close();
	}
}