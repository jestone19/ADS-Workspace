// ADS Period 3
// September 21, 2020
//
// Main.java
//

import java.util.Scanner;

public class Main 
{
	private static final int maxDrawn = 54;
	private static final int maxWin = 6;

	private static int drawIn;
	private static int winIn;

	protected static Scanner scan;

	public static void main (String[] args)
	{
		scan = new Scanner(System.in);

		// gets input of balls for drawing pool
		while (true)
		{
			System.out.println("Enter the number of balls to be drawn from: ");

			drawIn = scan.nextInt();
			if (drawIn > maxDrawn)
			{
				System.out.println("Number too large! (Must be at or below "
						+ maxDrawn + ")");
			}
			else if (drawIn <= 0)
			{
				System.out.println("Number too small! (Must be at or below "
						+ maxDrawn + " and above 0)");
			}
			else
			{
				break;
			}
		}

		// gets input of balls for winning pool
		while (true)
		{
			System.out.println("Enter the number of winning balls: ");

			winIn = scan.nextInt();
			if (winIn > maxWin)
			{
				System.out.println("Number too large! (Must be at or below "
						+ maxWin + ")");
			}
			else if (winIn <= 0)
			{
				System.out.println("Number too small! (Must be at or below "
						+ maxWin + " and above 0)");
			}
			else
			{
				break;
			}
		}

		//creates hopper object using inputs
		Hopper hopper = new Hopper(drawIn, winIn);

		// draws using the hopper and prints the pool of balls and winning
		// balls after each draw
		while (hopper.draw())
		{
			System.out.println("Current Pool: " + hopper.ballsToString());
			System.out.println("Winning Pool: " 
					+ hopper.winningBallsToString());
		}

		System.out.println("The final winning pool is " 
				+ hopper.winningBallsToString() + "! Thank you for playing!");
	}
}
