// ADS Period 3
// September 14, 2020
//
// Sieve.java
//

import java.util.Scanner;

public class Main 
{
	private static Scanner scan;
	
	public static void main (String[] args)
	{
		scan = new Scanner(System.in);
		
		System.out.println("Enter an integer: ");

		int[] primes = Sieve.sieve((int) scan.nextDouble());
		for (int i = 0; i < primes.length; i ++)
		{
			System.out.print("" + primes[i] + " ");
		}
	}
}
