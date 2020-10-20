import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the change in cents:");
		double changeDue = input.nextDouble();

		double pennies = (changeDue)*100;

		int quarters = (int) (pennies/25);
		pennies = pennies%25;

		int dimes = (int) (pennies/10);
		pennies = pennies%10;

		int nickels = (int) (pennies/5);
		pennies = pennies%5;

		int pennies1 = (int) (pennies/1);
		pennies = pennies%1;

		System.out.println("The minimum number of coins is:");
		//System.out.println(dollars + "dollars");
		System.out.println(quarters + " quarters");
		System.out.println(dimes + " dimes");
		System.out.println(nickels + " nickels");
		System.out.println(pennies1 + " pennies");

	}
}

