import java.awt.Point;

public class FactorGenerator 
{
	private int numToFactor;
	private int numDiv;
	private int lessThan;

	public FactorGenerator(int numToFactor)
	{
		this.numToFactor = numToFactor;
		numDiv = 1;
		lessThan = numToFactor / 2;
	}

	public Point nextFactor()
	{
		if (numToFactor % numDiv == 0)
		{
			Point temp = new Point(numToFactor / numDiv , numDiv);
			lessThan = numToFactor / numDiv;
			numDiv++;
			return temp;
		}
		else 
		{
			numDiv++;
			if (hasMoreFactors())
			{
				return nextFactor();
			}
			else
			{
				return null; //will never return
			}
		}
	}

	public boolean hasMoreFactors()
	{
		return numDiv <= lessThan;
	}
}
