// ADS Period 3
// September 29, 2020
//
// Tile.java
//

public class Tile 
{
	private boolean dirt;
	private boolean snake;
	private boolean treasure;

	private boolean revealed;
	
	//-------------------------------------------------------------------------
	// Tile constructor; sets type of tile using booleans
	//-------------------------------------------------------------------------
	public Tile(boolean dirt, boolean snake, boolean treasure)
	{
		this.dirt = dirt;
		this.snake = snake;
		this.treasure = treasure;

		revealed = false;
	}

	//-------------------------------------------------------------------------
	// returns true if tile is dirt
	//-------------------------------------------------------------------------
	public boolean isDirt()
	{
		return dirt;
	}

	//-------------------------------------------------------------------------
	// returns true if tile is snake
	//-------------------------------------------------------------------------
	public boolean isSnake()
	{
		return snake;
	}

	//-------------------------------------------------------------------------
	// returns true if tile is treasure
	//-------------------------------------------------------------------------
	public boolean isTreasure()
	{
		return treasure;
	}

	//-------------------------------------------------------------------------
	// reveals tile
	//-------------------------------------------------------------------------
	public void reveal()
	{
		if (!revealed)
		{
			revealed = true;
		}
	}

	//-------------------------------------------------------------------------
	// returns true if tile is revealed
	//-------------------------------------------------------------------------
	public boolean isRevealed()
	{
		return revealed;
	}
}
