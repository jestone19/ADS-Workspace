// ADS Period 3
// September 14th, 2020
//
// PrimePrinter.java
//

import java.util.Scanner;

public class PrimePrinter 
{
	private static Scanner scan;

	//-------------------------------------------------------------------------
	// Prompts user for integer and displays prime numbers
	//-------------------------------------------------------------------------
	public static void main (String[] args)
	{
		scan = new Scanner(System.in);

		System.out.println("Please enter an integer: ");
		
		//accepts doubles to avoid mismatch exception, casts to int
		PrimeGenerator generator = 
				new PrimeGenerator((int) scan.nextDouble());

		System.out.println("Primes: ");
		
		while (generator.hasMorePrime())
		{
			System.out.println(generator.nextPrime());
		}
	}
}
