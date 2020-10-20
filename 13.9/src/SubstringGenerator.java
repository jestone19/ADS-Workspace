// ADS Period 2
// October 12, 2020
//
// SubstringGenerator.java
//

import java.util.ArrayList;

public class SubstringGenerator 
{
	private String str;
	private ArrayList<String> enumerations;

	//-------------------------------------------------------------------------
	// Constructor, parameter string for enumeration
	//-------------------------------------------------------------------------
	public SubstringGenerator(String str) 
	{
		this.str = str;
		enumerations = new ArrayList<String>();
	}

	//-------------------------------------------------------------------------
	// recursively gets all substrings of private string instance in class
	//-------------------------------------------------------------------------
	public ArrayList<String> getSubstrings() 
	{
		if (str.length() > 0)
		{
			//finds all enumerations of starting string
			for (int i = 1; i <= str.length(); i ++)
			{
				enumerations.add(str.substring(0, i));
			}
			
			//creats new substringgen with substring of original starting at 1
			SubstringGenerator x = new SubstringGenerator(str.substring(1));
			enumerations.addAll(x.getSubstrings());
			return enumerations;
		}
		else
		{
			ArrayList<String> s = new ArrayList<String>();
			s.add("");
			return s;
		}
	}

}
