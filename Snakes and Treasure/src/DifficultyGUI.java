// ADS Period 3
// September 29, 2020
//
// DifficultyGUI.java
//

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class DifficultyGUI extends JFrame implements ChangeListener, 
													 ActionListener
{
	private JSlider snakes;
	private final int SNAKE_MIN = 3;
	private final int SNAKE_MAX = 30;
	private final int SNAKE_INIT = 3;
	private JLabel snakeLabel;

	private JSlider treasure;
	private final int TREASURE_MIN = 1;
	private final int TREASURE_MAX = 3;
	private final int TREASURE_INIT = 1;
	private JLabel treasureLabel;

	private JSlider dimensionsX;
	private JSlider dimensionsY;
	private final int DIMENSION_MIN = 5;
	private final int DIMENSION_MAX = 15;
	private final int DIMENSION_INIT = 5;
	private JLabel dimensionLabel;

	private JPanel panelA;
	private JPanel panelB;
	private JPanel container;

	private JButton launch;
	private JLabel invalid;

	//-------------------------------------------------------------------------
	// constructor; sets up sliders to select difficulty and, once ready,
	// creates a Game gui to start snakes and treasure.
	//-------------------------------------------------------------------------
	public DifficultyGUI()
	{
		super("Chose Difficulty");
		panelA = new JPanel();
		panelA.setLayout(new BoxLayout(panelA, BoxLayout.PAGE_AXIS));
		panelB = new JPanel();
		panelB.setLayout(new BoxLayout(panelB, BoxLayout.PAGE_AXIS));
		container = new JPanel();

		snakes = new JSlider(JSlider.HORIZONTAL, 
				SNAKE_MIN, SNAKE_MAX, SNAKE_INIT);
		treasure = new JSlider(JSlider.HORIZONTAL, 
				TREASURE_MIN, TREASURE_MAX, TREASURE_INIT);
		dimensionsX = new JSlider(JSlider.HORIZONTAL,
				DIMENSION_MIN, DIMENSION_MAX, DIMENSION_INIT);
		dimensionsY = new JSlider(JSlider.VERTICAL,
				DIMENSION_MIN, DIMENSION_MAX, DIMENSION_INIT);

		snakes.addChangeListener(this);
		treasure.addChangeListener(this);
		dimensionsX.addChangeListener(this);
		dimensionsY.addChangeListener(this);

		snakes.setMajorTickSpacing(3);
		snakes.setMinorTickSpacing(1);
		snakes.setPaintTicks(true);
		snakes.setPaintLabels(true);

		treasure.setMajorTickSpacing(1);
		treasure.setMinorTickSpacing(1);
		treasure.setPaintTicks(true);
		treasure.setPaintLabels(true);

		dimensionsX.setMajorTickSpacing(5);
		dimensionsX.setMinorTickSpacing(1);
		dimensionsX.setPaintTicks(true);
		dimensionsX.setPaintLabels(true);

		dimensionsY.setMajorTickSpacing(5);
		dimensionsY.setMinorTickSpacing(1);
		dimensionsY.setPaintTicks(true);
		dimensionsY.setPaintLabels(true);

		snakeLabel = new JLabel("Select Number of Snakes:", JLabel.CENTER);
		snakeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		treasureLabel = new JLabel("Select Number of Treasures:", 
				JLabel.CENTER);
		treasureLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		dimensionLabel = new JLabel("Select Dimensions:", JLabel.CENTER);
		dimensionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		panelA.add(snakeLabel);
		panelA.add(snakes);
		panelA.add(treasureLabel);
		panelA.add(treasure);
		panelA.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		panelB.add(dimensionLabel);
		panelB.add(dimensionsY);
		panelB.add(dimensionsX);
		panelB.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
		container.add(panelA);
		container.add(panelB);

		launch = new JButton("LAUNCH!");
		launch.addActionListener(this);
		launch.setAlignmentX(Component.CENTER_ALIGNMENT);
		invalid = new JLabel("");
		invalid.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(launch);
		container.add(invalid);

		this.setContentPane(container);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	//-------------------------------------------------------------------------
	// updates X and Y dimension states based on the other
	// updates max number of snakes depending on dimensions
	//-------------------------------------------------------------------------
	@Override
	public void stateChanged(ChangeEvent e) 
	{
		if (e.getSource().equals(dimensionsX))
		{
			dimensionsY.setValue(dimensionsX.getValue());
		}
		else if (e.getSource().equals(dimensionsY))
		{
			dimensionsX.setValue(dimensionsY.getValue());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(launch))
		{
			if (snakes.getValue() + treasure.getValue() <= 
					dimensionsX.getValue() * dimensionsY.getValue())
			{
				this.dispose();

				SwingUtilities.invokeLater(new Runnable()
				{
					public void run()
					{
						@SuppressWarnings("unused")
						GUIManager gameGUI = new GUIManager(
								snakes.getValue(), treasure.getValue(),
								new Dimension(dimensionsX.getValue(), 
										dimensionsY.getValue()));
					}
				});
			}
			else
			{
				invalid.setText("Invalid entry; Too many Snakes!");
			}
		}
	}
}
