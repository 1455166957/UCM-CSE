import java.util.Random;
import java.util.Scanner;

public class GenericCheeseShop {
    public static void main(String[] args) {
        System.out.print("Enter the number of Cheeses for shop setup: ");
        Scanner input = new Scanner(System.in);
        int maxCheese = input.nextInt();

        String[] names = new String[maxCheese];
        double[] prices = new double[maxCheese];
        double[] amounts = new double[maxCheese];

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

        //Asking for input
        for (int i = 0; i < maxCheese; i++) {
            System.out.print("Enter the amount of " + names[i] + " in lbs: ");
            amounts[i] = input.nextDouble();
            while ((amounts[i] % 0.5 != 0) || (amounts[i] < 0)) {
                System.out.print("Invalid input. Enter a value that's a multiple of 0.5 and >=0: ");
                amounts[i] = input.nextDouble();
            }
        }

        //Showing the list
        if (maxCheese > 0) {
            int showList = 0;
            System.out.print("\nDisplay the itemized list? (1 for yes) ");
            showList = input.nextByte();
            if (showList == 1) {
                double temp = 0;
                for (int i = 0; i < maxCheese; i++) {
                    temp = temp + amounts[i];
                }
                if (temp == 0)
                    System.out.println("No items were purchased.");
                for (int i = 0; i < maxCheese; i++) {
                    if (amounts[i] > 0) {
                        System.out.println(amounts[i] + " lb of " + names[i] + " @ $" + prices[i] + " = $" + (amounts[i] * prices[i]));
                    }
                }
            }
        }

        //Calculating Subtotal
        double subtotal = 0;
        for (int i = 0; i < maxCheese; i++) {
            subtotal = subtotal + (amounts[i] * prices[i]);
        }
        System.out.println("\nOriginal Sub total:           $" + subtotal);
        System.out.println("Specials...");

        //doing discounts
        double discountFog = 0;
        double discountHawk = 0;
        if (maxCheese > 0)
            discountFog = (int)(amounts[0]) * (prices[0] / 2);
        if (maxCheese > 1)
            discountHawk = (int)(amounts[1] * 2 / 3) * (prices[1] / 2);

        if ((discountFog == 0) && (discountHawk == 0))
            System.out.println("None                         -$0.0");

        if(discountFog > 0)
            System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$" + discountFog);
        if (discountHawk > 0)
            System.out.println("Red Hawk (Buy 2 Get 1 Free):     -$" + discountHawk);

        double newSubtotal = subtotal- discountFog - discountHawk;
        System.out.println("New Sub Total:                $" + newSubtotal);

        double  newDiscount = 0;
        if ((newSubtotal > 150) && (newSubtotal < 250)) {
            newDiscount = newSubtotal * 0.10;
            System.out.println("Additional 10% Discount:     -$" + newDiscount);
        } else if (newSubtotal > 250) {
            newDiscount = newSubtotal * 0.25;
            System.out.println("Additional 25% Discount:     -$" + newDiscount);
        } else {
            System.out.println("Additional 0% Discount:      -$" + newDiscount);
        }

        double total;
        total = newSubtotal - newDiscount;
        System.out.println("Final Total:                  $" + total);
    }
}
