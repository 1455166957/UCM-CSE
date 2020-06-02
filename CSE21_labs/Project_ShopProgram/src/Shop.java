import java.util.Scanner;

public class Shop {

    public static void intro() {
        System.out.println("\nThis program supports 4 functions:");
        System.out.println("     1. Set Up Shop");
        System.out.println("     2. Buy");
        System.out.println("     3. List Items");
        System.out.println("     4. Checkout");
        System.out.print("Please choose the function you want: ");
    }

    public static int chooseFunction(Scanner input) {
        int funcNum = input.nextInt();
        System.out.println();
        //checking if the input is correct
        while ((funcNum < 1) || (funcNum > 4)) {
            System.out.print("Wrong function number! Enter the number from 1 to 4: ");
            funcNum = input.nextInt();
            System.out.println();
        }
        return funcNum;
    }


    //This method sets total amount of items in the store
    public static int setTotalItems(Scanner input) {
        int items;
        System.out.print("Please enter the number of items to setup shop: ");
        items = input.nextInt();
        while (items < 1) {
            System.out.print("Invalid input. Enter number that is > 1: ");
            items = input.nextInt();
        }
        return items;
    }

    //This method sets up names, prices and special discounts
    public static void setupItems(int totalItems, String[] names, double[] prices, int[] freeItems, Scanner input) {
        for (int i = 1; i <= totalItems; i++) {
            System.out.print("Enter the name of the " + numSuffix(i) + " product: ");
            names[i] = input.next();
            System.out.print("Enter the per package price of " + names[i] + ": ");
            prices[i] = input.nextDouble();
            System.out.print("Enter the number of packages ('x') to qualify for Special Discount (buy 'x' get 1 free) ");
            System.out.print("for " + names[i] + ", or 0 if no Special Discount offered: ");
            freeItems[i] = input.nextInt();
        }
    }

    //This method is to set threshold for Additional Discount
    public static double setThreshold(Scanner input) {
        double thresholdAmt;
        System.out.print("\nEnter the dollar amount to qualify for Additional Discount (or 0 if none offered): ");
        thresholdAmt = input.nextDouble();
        while (thresholdAmt < 0) {
            System.out.print("Invalid input. Enter positive value: ");
            thresholdAmt = input.nextDouble();
        }
        return thresholdAmt;
    }

    //this method is to set Additional Discount rate
    public static double setAddDisRate(Scanner input) {
        double addDisc;
        System.out.print("Enter the Additional Discount rate (e.g., 0.1 for 10%): ");
        addDisc = input.nextDouble();
        while ((addDisc <= 0) || (addDisc > 0.5)) {
            System.out.print("Invalid input. Enter a value > 0 and <= 0.5: ");
            addDisc = input.nextDouble();
        }
        return addDisc;
    }

    //this method buys packages
    public static void buy(int totalItems, int[] amounts, String[] names, Scanner input) {
        for (int i = 1; i <= totalItems; i++) {
            System.out.print("Enter the number of " + names[i] + " packages to buy: ");
            amounts[i] = input.nextInt();
            while (amounts[i] < 0) {
                System.out.print("Invalid input. Enter a value >= 0: ");
                amounts[i] = input.nextInt();
            }
        }
    }

    //this method checks if there's anything bought
    public static boolean ifBought(int totalItems, int[] amounts) {
        int sum = 0;
        for (int i = 1; i <= totalItems; i++) {
            sum += amounts[i];
        }
        if (sum > 0)
            return true;
        else
            return false;
    }

    //this method prints out list of purchased items
    public static void itemizedList(int totalItems, String[] names, double[] prices, int[] amounts) {
        int sum = 0;
        for (int i = 1; i <= totalItems; i++) {
            sum = sum + amounts[i];
        }
        if (sum == 0)
            System.out.println("No items were purchased.");
        else {
            for (int i = 1; i <= totalItems; i++) {
                if (amounts[i] > 0) {
                    if (amounts[i] == 1)
                        System.out.printf("%d package of %s @ $%.2f per pkg = $%.2f\n", amounts[i], names[i], prices[i], prices[i] * amounts[i]);
                    else
                        System.out.printf("%d packages of %s @ $%.2f per pkg = $%.2f\n", amounts[i], names[i], prices[i], prices[i] * amounts[i]);
                }
            }
        }
    }

    //this method calculates subtotal
    public static double calcSubTotal(int totalItems, double[] prices, int[] amounts) {
        double subtotal = 0;
        for (int i = 1; i <= totalItems; i++) {
            subtotal += amounts[i] * prices[i];
        }
        return subtotal;
    }

    //this method calculates Special Discount Total
    public static double specialDiscountTotal(int totalItems, int[] amounts, double[] prices, int[] freeItems) {
        double specialDiscount = 0;
        for (int i = 1; i <= totalItems; i++) {
            if (freeItems[i] != 0)
                specialDiscount += (amounts[i] / (1 + freeItems[i])) * prices[i];
        }
        return specialDiscount;
    }

    //this method calculates new subtotal
    public static double newSubtotal(int totalItems, double[] prices, int[] amounts, int[] freeItems) {
        return (calcSubTotal(totalItems, prices, amounts) - specialDiscountTotal(totalItems, amounts, prices, freeItems));
    }

    //this method is to calculate additional discount
    public static double addDiscount(double threshold, double disRate, double newSubtotal) {
        double discount = 0;
        if (newSubtotal > threshold)
            discount = newSubtotal * disRate;
        return discount;
    }

    //this method does output for checkout
    public static void printCheckout (int totalItems, String[] names, double[] prices, int[] amounts, int[] freeItems, double threshold, double disrate) {
        System.out.printf("Original Sub Total:                $%.2f\n", calcSubTotal(totalItems, prices, amounts));

        double specialDiscounts = specialDiscountTotal(totalItems, amounts, prices, freeItems);
        if (specialDiscounts > 0)
            System.out.printf("Special Discounts:                -$%.2f\n", specialDiscounts);
        else
            System.out.println("No Special Discounts applied");

        System.out.printf("New Sub Total:                     $%.2f\n", newSubtotal(totalItems, prices, amounts, freeItems));

        double addDiscount = addDiscount(threshold, disrate, newSubtotal(totalItems, prices, amounts, freeItems));
        if (addDiscount > 0)
            System.out.printf("Additional %.0f%% Discount:          -$%.2f\n", (disrate * 100), addDiscount);
        else
            System.out.println("You did not qualify for an Additional Discount");

        System.out.printf("Final Sub Total:                   $%.2f\n", (newSubtotal(totalItems, prices, amounts, freeItems) - addDiscount));
        System.out.println("\nThanks for coming!\n");
    }

    public static boolean ifRerun(Scanner input) {
        System.out.println("-------------------------------------------------");
        System.out.print("Would you like to re-run (1 for yes, 0 for no)? ");
        int ifRerun = input.nextInt();
        System.out.println("-------------------------------------------------");
        if (ifRerun == 0)
            return false;
        else
            return true;
    }


    public static String numSuffix(int i) {
        int rem = i % 10;
        switch (rem) {
            case 0:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return (i + "th");
            case 1:
                if (i % 100 != 11)
                    return (i + "st");
                else
                    return (i + "th");
            case 2:
                if (i % 100 != 12)
                    return (i + "nd");
                else
                    return (i + "th");
            case 3:
                if (i % 100 != 13)
                    return (i + "rd");
                else
                    return (i + "th");
            default:
                break;
        }
        return "";
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int overSizedArraySize = 9999;
        String[] names = new String[overSizedArraySize];
        double[] prices = new double[overSizedArraySize];
        int[] amounts = new int[overSizedArraySize];
        int[] freeItems = new int[overSizedArraySize];
        boolean ifSetup = false;
        boolean ifBought = false;
        int totalItems = 0;
        double threshold = 0;
        double disRate = 0;

        while (true) {
            intro();
            int chooseFunc = chooseFunction(input);

            if (chooseFunc == 1) {
                ifBought = false;
                ifSetup = true;
                totalItems = setTotalItems(input);
                setupItems(totalItems, names, prices, freeItems, input);
                threshold = setThreshold(input);
                if (threshold > 0) {
                    disRate = setAddDisRate(input);
                } else {
                    disRate = 0;
                }
            }

            if (chooseFunc == 2) {
                if (ifSetup) {
                    buy(totalItems, amounts, names, input);
                    ifBought = true;
                } else {
                    System.out.println("Shop is not set up yet!");
                }
            }

            if (chooseFunc == 3) {
                if (!ifSetup || !ifBought) {
                    if (!ifSetup)
                        System.out.println("Shop is not set up yet!");
                    else
                        System.out.println("You have not bought anything!");
                } else
                    itemizedList(totalItems, names, prices, amounts);
            }


            if (chooseFunc == 4) {
                if (!ifSetup || !ifBought) {
                    if (!ifSetup)
                        System.out.println("Shop is not set up yet!");
                    else
                        System.out.println("You have not bought anything!");
                } else {
                    printCheckout(totalItems, names, prices, amounts, freeItems, threshold, disRate);
                    boolean ifRerun = ifRerun(input);
                    if (ifRerun)
                        ifSetup = false;
                    else
                        break;
                }
            }
        }
    }
}