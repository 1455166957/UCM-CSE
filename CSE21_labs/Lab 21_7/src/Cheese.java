import java.util.Scanner;

public class Cheese {

	private String name;
	private double price;
	private double amount;

	public static int numCheese = 0;
	
	public Cheese() { // Constructor with no parameters
		name = "";
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name) { // Constructor with name as parameter
		this.name = name;
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name, double price) { // Constructor with 2 parameters
		this.name = name;
		this.price = price;
		amount = 0;
		numCheese++;
	}

	public String getName() { // Accessor
		return name;
	}

	public void setName(String newName) { // Mutator 
		name = newName;
	}

	public double getPrice() {
		// Fix Code
		return price;
	}

	public void setPrice(double newPrice) {
		// Fill-in Code
		price = newPrice;
	}

	public double getAmount() {
		// Fix Code
		return amount;
	}

	public void setAmount(Scanner input) {
		// Fill-in Code
		amount = input.nextDouble();
		while ((amount % 0.5 != 0) || (amount < 0)) {
			if (amount < 0) {
				System.out.print("Invalid input. Enter a value >= 0: ");
			} else {
				System.out.print("Invalid input. Enter a value that's a multiple of 0.5: ");
			}
			amount = input.nextDouble();
		}

	}

}
