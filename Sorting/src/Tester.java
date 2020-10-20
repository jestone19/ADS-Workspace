// ADS Period 2
// October 19, 2020
//
// Tester.java
//

public class Tester 
{
	public static void main (String[] args)
	{
		int n = 100000;
		int[] a = new int[n];

		for (int i = 0; i < n; i ++)
		{
			a[i] = n - i;
		}

		MergeSorter m = new MergeSorter(a);
		m.sort();
		System.out.println(m.getCounter());

		int[] a1 = new int[25];
		
		for (int i = 0; i < a1.length; i ++)
		{
			a1[i] = (int) (Math.random() * 9);
		}
		
		BubbleSorter b = new BubbleSorter(a1);
		b.sort();
		BubbleSorter b1 = new BubbleSorter(a1);
		b.sortRock();
		
		int[] bsort = b.getArray();
		int[] b1sort = b1.getArray();
		for (int i = 0; i < bsort.length; i ++)
		{
			System.out.print(bsort[i]);
		}
		System.out.println("");
		for (int i = 0; i < bsort.length; i ++)
		{
			System.out.print(b1sort[i]);
		}
	}
}
