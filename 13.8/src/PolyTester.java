// ADS Period 2
// October 12, 2020
//
// PolyTester.java
//

import java.awt.geom.Point2D;

/**
   A tester class for Polygon.
*/
public class PolyTester
{
   public static void main(String[] args)
   {
      // square
      Polygon p = new Polygon();
      p.add(new Point2D.Double(10, 20));
      p.add(new Point2D.Double(20, 20));
      p.add(new Point2D.Double(20, 10));
      p.add(new Point2D.Double(10, 10));
      
      System.out.println("Area: " + p.getArea());
      System.out.println("Expected: 100");

      // regular hexagon with radius 1
      p = new Polygon();
      for (int i = 0; i < 6; i++)
         p.add(new Point2D.Double(Math.sin(i * Math.PI / 3),
               Math.cos(i * Math.PI / 3)));
      System.out.println("Area: " + p.getArea());
      System.out.println("Expected: " + 3 * Math.sqrt(3) / 2);
   }
}