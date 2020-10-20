// ADS Period 3
// September 21, 2020
//
// Hopper.java
//

import java.util.ArrayList;

public class Hopper 
{
	private ArrayList<Ball> balls;
	private ArrayList<Ball> winningBalls;

	private int winDrawNum;

	//-------------------------------------------------------------------------
	// constructor, creates ArrayLists based on num of balls to draw and win
	//-------------------------------------------------------------------------
	public Hopper (int numToDraw, int numWin)
	{
		balls = new ArrayList<Ball>();
		winningBalls = new ArrayList<Ball>();

		for (int i = 1; i <= numToDraw; i++)
		{
			balls.add(new Ball(i));
		}

		this.winDrawNum = numWin;
	}

	//-------------------------------------------------------------------------
	// returns the balls in the drawing pool in a string
	//-------------------------------------------------------------------------
	public String ballsToString()
	{
		String temp = "\n";
		for (int i = 0; i < balls.size(); i++)
		{
			temp += balls.get(i).num;
			temp += " ";
			if (i % 10 == 0 && i != 0)
			{
				temp += "\n";
			}
		}

		return temp;
	}

	//-------------------------------------------------------------------------
	// returns the balls in the winning pool in a string
	//-------------------------------------------------------------------------
	public String winningBallsToString()
	{
		String temp = "\n";
		for (int i = 0; i < winningBalls.size(); i++)
		{
			temp += winningBalls.get(i).num;
			temp += " ";
		}

		return temp;
	}

	//-------------------------------------------------------------------------
	// draws ball, adding it to winning ball list and removing it from 
	// draw pool. returns true if there are balls left to draw, else false
	//-------------------------------------------------------------------------
	public boolean draw()
	{
		if (winningBalls.size() < winDrawNum)
		{
			winningBalls.add(balls.remove((int) (Math.random() * balls.size())));
			return true;
		}

		return false;
	}	
}
