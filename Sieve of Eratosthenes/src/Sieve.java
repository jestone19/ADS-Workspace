// ADS Period 3
// September 14, 2020
//
// Sieve.java
//

public class Sieve 
{
	//-------------------------------------------------------------------------
	// crates boolean array, uses sieve algorithm to determine primes, returns
	// array with primes
	//-------------------------------------------------------------------------
	public static int[] sieve(int num)
	{
		//creates boolean array and sets all values above 2 to true
		boolean[] primes = new boolean[num + 1];
		for (int i = 0; i < primes.length; i ++)
		{
			primes[i] = i > 1;
		}

		//sieve algorithm starts factor at 2 and increases a check by i 
		//for each iteration
		//could improve because this is slow	
		for (int i = 2; i < primes.length; i ++)
		{
			for (int j = i + i; j < primes.length; j += i)
			{
				primes[j] = false;
			}
		}

		//determines how many primes for array
		int numPrimes = 0;
		for (int i = 0; i < primes.length; i ++)
		{
			if (primes[i])
			{
				numPrimes++;
			}
		}

		//puts all primes in array
		int[] tempPrime = new int[numPrimes];
		int j = 0;
		for (int i = 0; i < primes.length; i ++)
		{
			if (primes[i])
			{
				tempPrime[j] = i;
				j++;
			}
		}

		return tempPrime;
	}
}
