// ADS Period 3
// September 14th, 2020
//
// PrimeGenerator.java
//

public class PrimeGenerator 
{
	private int numToPrime;
	private int num;

	//-------------------------------------------------------------------------
	// Constructor; sets start num to 2
	//-------------------------------------------------------------------------
	public PrimeGenerator(int numToPrime)
	{
		this.numToPrime = numToPrime;
		num = 2;
	}

	//-------------------------------------------------------------------------
	//	returns next prime number
	//-------------------------------------------------------------------------
	public int nextPrime()
	{		
		return num++;
	}

	//-------------------------------------------------------------------------
	// checks if there are any more prime left by incrementing num integer 
	// to next prime
	//-------------------------------------------------------------------------
	public boolean hasMorePrime()
	{
		if (num <= numToPrime)
		{
			while(!isPrime())
			{
				if (num > numToPrime)
				{
					return false;
				}
				
				num++;
			}
			
			return true;
		}

		return false;
	}

	//-------------------------------------------------------------------------
	// checks if current num is prime
	//-------------------------------------------------------------------------
	private boolean isPrime()
	{
		for (int i = 2; i < num ; i++)
		{
			if (num % i == 0)
			{
				return false;
			}
		}

		return true;
	}
}
