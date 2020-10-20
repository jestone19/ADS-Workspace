// ADS Period 3
// October 5, 2020
//
// Sentence.java
//

public class Sentence 
{
	private String str;

	//-------------------------------------------------------------------------
	// Constructor; Takes 1 string to represent sentence
	//-------------------------------------------------------------------------
	public Sentence(String str)
	{
		this.str = str;
	}

	//-------------------------------------------------------------------------
	// reverses string using recursion
	//-------------------------------------------------------------------------
	public String reverse()
	{
		if (str.length() == 0)
		{
			return str;
		}

		Sentence s = new Sentence(str.substring(1));
		return s.reverse() + str.charAt(0);
	}

	//-------------------------------------------------------------------------
	// reverses string iteratively using a for loop
	//-------------------------------------------------------------------------
	public String iterativeReverse()
	{
		char[] strChar = str.toCharArray();

		for (int i = 0; i < str.length(); i ++)
		{
			strChar[i] = str.charAt(str.length() - 1 - i);
		}

		return new String(strChar);
	}
}
