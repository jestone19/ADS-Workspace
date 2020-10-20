// ADS Period 3
// September 29, 2020
//
// GUIManager.java
//

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUIManager implements ActionListener
{
	private JFrame frame;
	private JPanel container;
	private JPanel contentPane;
	private JPanel contentPane2;

	private JButton[][] buttons;
	private JLabel isDugLabel;

	private Game game;

	private ImageIcon dirt;
	private ImageIcon snake;
	private ImageIcon treasure;
	private ImageIcon nonRevealed;

	private final String dirtImage = "dirt.jpg";
	private final String snakeImage = "snake.jpg";
	private final String treasureImage = "treasure.jpg";
	private final String nonRevealedImage = "nonreveal.jpg";
	
	private int numSnakes;
	private int numTreasure;
	private Dimension d;

	//-------------------------------------------------------------------------
	// constructor; sets up gui with jbuttons representing tiles
	//-------------------------------------------------------------------------
	public GUIManager(int numSnakes, int numTreasure, Dimension d)
	{
		this.numSnakes = numSnakes;
		this.numTreasure = numTreasure;
		this.d = d;
		
		game = new Game(numSnakes, numTreasure, d);
		game.printMap();

		buttons = new JButton[game.getMap().length][game.getMap()[0].length];

		dirt = new ImageIcon(dirtImage);
		snake = new ImageIcon(snakeImage);
		treasure = new ImageIcon(treasureImage);
		nonRevealed = new ImageIcon(nonRevealedImage);

		Image temp = dirt.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		dirt = new ImageIcon(temp);
		Image temp1 = snake.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		snake = new ImageIcon(temp1);
		Image temp2 = treasure.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		treasure = new ImageIcon(temp2);
		Image temp3 = nonRevealed.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		nonRevealed = new ImageIcon(temp3);

		GridBagConstraints gameBagC = new GridBagConstraints();
		gameBagC.anchor = GridBagConstraints.PAGE_START;

		frame = new JFrame("Snakes and Treasures");

		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		for (int i = 0; i < buttons.length; i ++)
		{
			for (int j = 0; j < buttons[i].length; j ++)
			{
				buttons[i][j] = new JButton(nonRevealed);
				buttons[i][j].addActionListener(this);
				gameBagC.gridx = i + 1;
				gameBagC.gridy = j + 1;
				buttons[i][j].setBorder(null);
				buttons[i][j].setMargin(new Insets(0, 0, 0, 0));
				buttons[i][j].setActionCommand("" + i + " " + j);
				contentPane.add(buttons[i][j], gameBagC);
			}
		}

		contentPane2 = new JPanel();
		isDugLabel = new JLabel("");
		contentPane2.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
		contentPane2.add(isDugLabel);

		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

		container.add(contentPane);
		container.add(contentPane2);

		frame.setContentPane(container);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	//-------------------------------------------------------------------------
	// called when one of the buttons is pressed. handles gui logic based
	// on reveals
	//-------------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (game.getGameStatus())
		{
			String actionCommand = e.getActionCommand();
			Point p = new Point(
					Integer.parseInt(actionCommand.substring(0, actionCommand.indexOf(" "))),
					Integer.parseInt(actionCommand.substring(actionCommand.indexOf(" ") + 1)));
			if (!game.getMap()[p.x][p.y].isRevealed())
			{
				game.dig(p);
				isDugLabel.setText("");
			}
			else
			{
				isDugLabel.setText("Already Dug Here");
			}

			update();

			if (!game.getGameStatus())
			{
				@SuppressWarnings("unused")
				WinDisplay winPanel = new WinDisplay(game.isWinner(), frame);
			}
		}
	}
	
	private void update()
	{
		for (int i = 0; i < buttons.length; i ++)
		{
			for (int j = 0; j < buttons[i].length; j ++)
			{
				if (game.getMap()[i][j].isRevealed())
				{
					if (game.getMap()[i][j].isDirt())
					{
						buttons[i][j].setIcon(dirt);
					}
					else if (game.getMap()[i][j].isSnake())
					{
						buttons[i][j].setIcon(snake);
					}
					else if (game.getMap()[i][j].isTreasure())
					{
						buttons[i][j].setIcon(treasure);
					}
				}
			}
		}
	}
	
	private class WinDisplay extends JFrame
	{
		private static final long serialVersionUID = 1L;
		private JLabel text;
		private JButton restart;
		private JPanel panel;
		
		//-------------------------------------------------------------------------
		// Constructor; displays winner or loser after game ends
		//-------------------------------------------------------------------------
		public WinDisplay(boolean isWinner, JFrame gameFrame)
		{			
			panel = new JPanel();

			text = new JLabel((isWinner) ? "Win!" : "Lose!");
			panel.add(text);

			restart = new JButton("Restart");
			restart.addActionListener(e -> {
				this.dispose();
				gameFrame.dispose();
				SwingUtilities.invokeLater(new Runnable()
				{
					public void run() 
					{
						GUIManager gui = new GUIManager(numSnakes, numTreasure, d);
					}
				});
			});
			panel.add(restart);

			this.setContentPane(panel);
			this.pack();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
	}
}
