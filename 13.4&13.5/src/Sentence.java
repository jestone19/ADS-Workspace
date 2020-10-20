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
	// returns true if parameter is found in instance string; recursive
	//-------------------------------------------------------------------------
	public boolean find(String t)
	{
		if (str.startsWith(t))
		{
			return true;
		}

		try
		{
			Sentence s = new Sentence (str.substring(1, str.length()));
			return s.find(t);
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	//-------------------------------------------------------------------------
	// returns index of parameter in instance string; calls helper method
	//-------------------------------------------------------------------------
	public int findInt(String t)
	{
		return findInt(t, 0);
	}
	
	//-------------------------------------------------------------------------
	// helper method, returns index of parameter in instance string; recursive
	//-------------------------------------------------------------------------
	private int findInt(String t, int n)
	{
		if (str.startsWith(t))
		{
			return 1;
		}
		
		try
		{
			Sentence s = new Sentence(str.substring(1, str.length()));
			return s.findInt(t, n + 1) + 1;
		}
		catch (Exception e)
		{
			return -(n + 1);
		}
	}
}
