// ADS Period 3
// September 14th, 2020
//
// FactorGenerator.java
//

public class FactorGenerator 
{
	private int numToFactor;
	private int factor;

	//-------------------------------------------------------------------------
	// Constructor; sets factor to 2
	//-------------------------------------------------------------------------
	public FactorGenerator(int numToFactor)
	{
		this.numToFactor = numToFactor;
		factor = 2;
	}

	//-------------------------------------------------------------------------
	// returns next factor
	//-------------------------------------------------------------------------
	public int nextFactor()
	{
		return factor;
	}

	//-------------------------------------------------------------------------
	// returns if there are any more factors left by incrementing factor 
	// and lowering number to factor accordingly
	//-------------------------------------------------------------------------
	public boolean hasMoreFactors()
	{
		if (factor <= numToFactor)
		{
			while (numToFactor % factor != 0)
			{
				factor++;
			}

			numToFactor /= factor;

			return true;
		}

		return false;
	}
}
