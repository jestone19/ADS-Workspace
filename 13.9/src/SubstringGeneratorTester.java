// ADS Period 2
// October 12, 2020
//
// SubstringGeneratorTester.java
//

import java.util.ArrayList;
import java.util.Collections;

/**
   This program tests the substring generator.
 */
public class SubstringGeneratorTester
{
	public static void main(String[] args)
	{
		SubstringGenerator generator 
		= new SubstringGenerator("rum");
		ArrayList<String> substrings = generator.getSubstrings();
		// Sort the result for checking 
		Collections.sort(substrings);
		System.out.println(substrings);
		System.out.println("Expected: [, m, r, ru, rum, u, um]");
	}
}