// ADS Period 3
// October 5, 2020
//
// Test.java
//

public class Test 
{
	public static void main (String[] args)
	{
		String str = "Hello World";
		String t = "o W";
		Sentence s = new Sentence(str);
		System.out.println(s.find(t));
		System.out.println(s.findInt(t));
	}
}
