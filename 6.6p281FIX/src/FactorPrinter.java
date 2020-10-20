// ADS Period 3
// September 14th, 2020
//
// FactorPrinter.java
//

import java.util.Scanner;

public class FactorPrinter 
{
	/*protected*/ private static Scanner scan;

	//-------------------------------------------------------------------------
	// Prompts user for integer and displays factors 
	//-------------------------------------------------------------------------
	public static void main (String[] args)
	{
		scan = new Scanner(System.in);

		System.out.println("Please enter an integer to factor: ");

		//accepts doubles to avoid mismatch exception, casts to int
		FactorGenerator generator = 
				new FactorGenerator((int) scan.nextDouble());

		System.out.println("Factors: ");

		while (generator.hasMoreFactors())
		{
			System.out.println(generator.nextFactor());
		}
	}
}
