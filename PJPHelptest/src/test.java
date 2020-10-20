public class test 
{
	public static void main (String[] test)
	{
		int[] a = {1,2,3,4,5};
		int[] b = {5,6,7,8};
		
		a = b;
		
		for (int x : a)
		{
			System.out.print(x);
		}
		
		System.out.println("");
		
		for (int x : b)
		{
			System.out.print(x);
		}
	}
}

