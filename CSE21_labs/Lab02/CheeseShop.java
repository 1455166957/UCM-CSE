import java.util.Scanner;
public class CheeseShop {
	public static void main (String[] args) {
	
		final double fog = 25.00;
		final double hawk = 40.50;
		final double teleme = 17.25;

		double lbsFog;
		double lbsHawk;
		double lbsTeleme;
		byte showList = 0;

		Scanner input = new Scanner(System.in);

		System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):");
		System.out.println("Humbolt Fog: $25.00 per pound");
		System.out.println("Red Hawk: $40.50 per pound");
		System.out.println("Teleme: $17.25 per pound\n");
		
		System.out.print("Enter the amount of Humbolt Fog in lbs: ");
		lbsFog = input.nextDouble();
		while ((lbsFog % 0.5 != 0) || (lbsFog < 0)){
			System.out.print("Invalid input. Enter a value that's a multiple of 0.5 and >=0: ");
			lbsFog = input.nextDouble();
		}


		System.out.print("Enter the amount of Red Hawk in lbs: ");
		lbsHawk = input.nextDouble();
		while ((lbsHawk % 0.5 != 0) || (lbsHawk < 0)) {
			System.out.print("Invalid input. Enter a value that's a multiple of 0.5 and >=0: ");
			lbsHawk = input.nextDouble();
		}


		System.out.print("Enter the amount of Teleme in lbs: ");
		lbsTeleme = input.nextDouble();
		while ((lbsTeleme % 0.5 != 0) || (lbsTeleme < 0)) {
			System.out.print("Invalid input. Enter a value that's a multiple of 0.5 and >=0: ");
			lbsTeleme = input.nextDouble();
		}

		
		System.out.print("\nDisplay the itemized list? (1 for yes) ");
		showList = input.nextByte();

		if (showList == 1) {
			if (lbsFog > 0) 
				System.out.println(lbsFog + " lb of Humboldt Fog @ $25.00 = $" + (fog * lbsFog));
			if (lbsHawk > 0)
				System.out.println(lbsHawk + " lb of Red Hawk @ $40.50 = $" + (hawk * lbsHawk));
			if (lbsTeleme > 0)
				System.out.println(lbsTeleme + "lb of Teleme @ $17.25 = $" + (teleme * lbsTeleme));
		}

		double subtotal = (fog * lbsFog) + (hawk * lbsHawk) + (teleme * lbsTeleme);
		System.out.println("\nSubtotal:                     $" + subtotal);
		System.out.println("Discounts...");
		
		//doing discounts
		double discountFog = (int)(lbsFog) * (fog / 2);
		double discountHawk = (int)(lbsHawk * 2 / 3) * (hawk / 2);
		
		if ((discountFog == 0) && (discountHawk == 0))
			System.out.println("None                         -$0.0");


		if(discountFog > 0)
			System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$" + discountFog);
		if (discountHawk > 0)
			System.out.println("Red Hawk (Buy 2 Get 1 Free):     -$" + discountHawk);

		System.out.println("Final Total:                  $" + (subtotal - discountFog - discountHawk));



	}
}
