// ADS Period 2
// October 12, 2020
//
// Polygon.java
//

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
   A polygon with a number of Point2D.Double corners
 */
public class Polygon
{
	private ArrayList<Point2D.Double> corners;
	/**
      Constructs a Polygon object with no corners
	 */
	public Polygon()
	{
		corners = new ArrayList<Point2D.Double>();
	}

	/**
      Adds a point to the list.
      @param p the point to add
	 */
	public void add(Point2D.Double p)
	{
		corners.add(p);   
	}

	/**
      Computes the area of a polygon.
      Assumes sorted
      @return area of a polygon
	 */
	public double getArea()
	{
		if (corners.size() == 3)
		{
			//area of triangle given xy coordinates
			return 0.5 * Math.abs(
					(corners.get(0).x * corners.get(1).y) 
					+ (corners.get(1).x * corners.get(2).y) 
					+ (corners.get(2).x * corners.get(0).y)
					- (corners.get(1).x * corners.get(0).y)
					- (corners.get(2).x * corners.get(1).y)
					- (corners.get(0).x * corners.get(2).y));
		}
		else
		{
			//creates triangle off of first 3 coordinates
			Polygon p1 = new Polygon();
			p1.add(corners.get(0));
			p1.add(corners.get(1));
			p1.add(corners.get(2));

			//creates second polygon, with 1 side shorter than
			//original polygon (n-1), excluding second point 
			//of triangle in p1
			Polygon p2 = new Polygon();
			for (int i = 2; i < corners.size(); i ++)
			{
				p2.add(corners.get(i));
			}
			p2.add(corners.get(0));
			
			return p1.getArea() + p2.getArea();
		}
	}
}