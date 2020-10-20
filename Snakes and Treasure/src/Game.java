// ADS Period 3
// September 29, 2020
//
// Game.java
//

import java.awt.Dimension;
import java.awt.Point;

public class Game 
{
	private Tile[][] map;
	private boolean gameStatus;
	private boolean winner;

	//-------------------------------------------------------------------------
	// constructor, sets up map with snakes, treasures, dirt
	//-------------------------------------------------------------------------
	public Game(int numSnakes, int numTreasure, Dimension d)
	{
		map = new Tile[d.height][d.width];

		for (int i = 0; i < map.length; i ++)
		{
			for (int j = 0; j < map[i].length; j ++)
			{
				map[i][j] = new Tile(true, false, false);
			}
		}

		int placedSnakes = 0;
		while (placedSnakes < numSnakes)
		{
			int x = (int) (Math.random() * map.length);
			int y = (int) (Math.random() * map[0].length);

			if (map[x][y].isDirt())
			{
				map[x][y] = new Tile(false, true, false);
				placedSnakes++;
			}
		}
		
		int placedTreasure = 0;
		while (placedTreasure < numTreasure)
		{
			int x = (int) (Math.random() * map.length);
			int y = (int) (Math.random() * map[0].length);
			
			if (map[x][y].isDirt())
			{
				map[x][y] = new Tile(false, false, true);
				placedTreasure++;
			}
		}

		gameStatus = true;
	}

	//-------------------------------------------------------------------------
	// digs at tile, revealing and setting game status accordingly
	//-------------------------------------------------------------------------
	public void dig(Point p)
	{
		map[p.x][p.y].reveal();

		if (map[p.x][p.y].isSnake())
		{
			for (int i = 0; i < map.length; i ++)
			{
				for (int j = 0; j < map[i].length; j ++)
				{
					if (map[i][j].isSnake())
					{
						map[i][j].reveal();
					}
				}
			}

			winner = false;
			gameStatus = false;
		}
		else if (map[p.x][p.y].isTreasure())
		{
			for (int i = 0; i < map.length; i ++)
			{
				for (int j = 0; j < map[i].length; j ++)
				{
					map[i][j].reveal();
				}
			}

			winner = true;
			gameStatus = false;
		}
	}

	//-------------------------------------------------------------------------
	// returns map
	//-------------------------------------------------------------------------
	public Tile[][] getMap()
	{
		return map;
	}

	//-------------------------------------------------------------------------
	// returns game status (true if game ongoing
	//-------------------------------------------------------------------------
	public boolean getGameStatus()
	{
		return gameStatus;
	}

	//-------------------------------------------------------------------------
	// returns true if user is winner
	//-------------------------------------------------------------------------
	public boolean isWinner()
	{
		return winner;
	}

	//-------------------------------------------------------------------------
	// prints map in console (testing purposes)
	//-------------------------------------------------------------------------
	public void printMap()
	{
		System.out.println("Map: \n");

		for (int i = 0; i < map.length; i ++)
		{
			for (int j = 0; j < map[i].length; j ++)
			{
				if (map[j][i].isDirt()) 
				{
					System.out.print(0);
				}
				else if (map[j][i].isSnake()) 
				{
					System.out.print(1);
				}
				else if (map[j][i].isTreasure())
				{
					System.out.print(2);
				}
			}

			System.out.println("");
		}
	}
}
