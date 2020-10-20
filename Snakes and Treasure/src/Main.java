// ADS Period 3
// September 29, 2020
//
// Main.java
//

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main 
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				runGUI();
			}
		});
	}
	
	//-------------------------------------------------------------------------
	// runs difficulty gui
	//-------------------------------------------------------------------------
	protected static void runGUI() 
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		@SuppressWarnings("unused")
		DifficultyGUI difGUI = new DifficultyGUI();
	}
}
