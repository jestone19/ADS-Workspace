// ADS Period 2
// October 19, 2020
//
// BubbleSorter.java
//

public class BubbleSorter 
{
	private int[] a;
	//private int counter;

	public BubbleSorter(int[] a)
	{
		this.a = a;
		//counter = 0;
	}

	public void sort()
	{
		for (int j = 0; j < a.length - 1; j ++)
		{
			for (int i = a.length - 1; i > 1 + j; i --)
			{
				if (a[i] < a[i-1])
				{
					int temp = a[i];
					a[i] = a[i-1];
					a[i-1] = temp;
				}
			}
		}
	}
	
	public void sortRock()
	{
		for (int j = 0; j < a.length - 1; j ++)
		{
			for (int i = 0; i < a.length - 1 - j; i ++)
			{
				if (a[i] > a[i+1])
				{
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		}
	}
	
	public int[] getArray()
	{
		return a;
	}
}