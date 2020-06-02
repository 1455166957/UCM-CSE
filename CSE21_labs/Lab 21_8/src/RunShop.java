import java.util.Scanner;

public class RunShop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		int cheeseNum = input.nextInt();
		while (cheeseNum < 0) {
			System.out.print("Invalid input. Enter positive number: ");
			cheeseNum = input.nextInt();
		}
		ShopArr shop = new ShopArr(cheeseNum);
		shop.run();
		System.out.println("Ran with Cheese Total: " + Cheese.numCheese);
		input.close();
	}

}
