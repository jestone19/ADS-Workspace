import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FactorPrinter 
{
	private static Scanner scan;

	public static void main (String[] args)
	{
		scan = new Scanner(System.in);

		FactorGenerator factorNum = new FactorGenerator(scan.nextInt());
		
		ArrayList<Integer> factors = new ArrayList<Integer>();

		while (factorNum.hasMoreFactors()) 
		{
			Point temp = factorNum.nextFactor();
			factors.add(temp.x);
			factors.add(temp.y);
		}

		//sorts
		Collections.sort(factors);

		//removes repeats
		if (factors.size() > 1)
		{
			ArrayList<Integer> temp = new ArrayList<Integer>();

			int j = 0; 
			for (int i = 0; i < factors.size() - 1; i++)
			{
				if (factors.get(i) != factors.get(i + 1))
				{
					temp.add(factors.get(i));
				}
			}

			temp.add(factors.get(factors.size() - 1)); 

			factors = temp;			
		}

		System.out.println(factors);
	}
}
