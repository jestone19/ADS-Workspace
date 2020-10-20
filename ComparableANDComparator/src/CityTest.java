// ADS Period 2
// October 19, 2020
//
// CityTest.java
//

import java.util.ArrayList;
import java.util.Collections;

public class CityTest 
{
	public static void main (String[] args)
	{
		City a = new City("New York", "New York");
		City b = new City("Dover", "Deleware");
		City c = new City("Baltimore", "Maryland");
		City d = new City("Baltimore", "Texas");
		City e = new City("Nashville", "Tennesee");
		City f = new City("Cleveland", "Ohio");
		City g = new City("Minneapolis", "Minnesota");
		City h = new City("San Diego", "California");
		City i = new City("Los Angeles", "California");
		
		ArrayList<City> cities = new ArrayList<City>();
		cities.add(a);
		cities.add(b);
		cities.add(c);
		cities.add(d);
		cities.add(e);
		cities.add(f);
		cities.add(g);
		cities.add(h);
		cities.add(i);
		
		System.out.println(cities);
		
		Collections.sort(cities);
		CityComparator cc = new CityComparator();
		Collections.sort(cities, cc);
		
		System.out.println(cities);
	}
}
