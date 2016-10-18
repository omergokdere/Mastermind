import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;

public class GameFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	private ArrayList<GuessPanel> guessPanels;
	private ArrayList<GuessPanel> resultPanels;

	
	private String color1 = "";
	private String color2 = "";
	private String color3 = "";
	private String color4 = "";

	private int guessCount = 0;
	private JTextField txtThisProgramIs;

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		determineRandomColor();
		guessPanels = new ArrayList<GuessPanel>();
		resultPanels = new ArrayList<GuessPanel>();
		setResizable(false);
		setTitle("MasterMind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ColorsPanel colors = new ColorsPanel();
		contentPane.add(colors);

		JComboBox<String> comboBox1 = new JComboBox<String>();
		JComboBox<String> comboBox2 = new JComboBox<String>();
		JComboBox<String> comboBox3 = new JComboBox<String>();
		JComboBox<String> comboBox4 = new JComboBox<String>();
		this.addCombo(comboBox1, 10);
		this.addCombo(comboBox2, 95);
		this.addCombo(comboBox3, 180);
		this.addCombo(comboBox4, 265);

		JButton button_guess = new JButton("GUESS");
		button_guess.setBounds(115, 50, 100, 25);
		button_guess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				guessPanels.get(guessCount).setColors(getColor(comboBox1),
						getColor(comboBox2), getColor(comboBox3),
						getColor(comboBox4));
				int samePlace = 0;
				int sameColor = 0;
				System.out.println("colors: "
						+ comboBox1.getSelectedItem().toString() + " "
						+ comboBox2.getSelectedItem().toString() + " "
						+ comboBox3.getSelectedItem().toString() + " "
						+ comboBox4.getSelectedItem().toString() + " ");
				if (color1.equals(getColorByCombo(comboBox1.getSelectedItem()
						.toString()))) {
					samePlace++;
				} else if (color2.equals(getColorByCombo(comboBox1
						.getSelectedItem().toString()))
						|| color3.equals(getColorByCombo(comboBox1
								.getSelectedItem().toString()))
						|| color4.equals(getColorByCombo(comboBox1
								.getSelectedItem().toString()))) {
					sameColor++;
				}

				if (color2.equals(getColorByCombo(comboBox2.getSelectedItem()
						.toString()))) {
					samePlace++;
				} else if (color1.equals(getColorByCombo(comboBox2
						.getSelectedItem().toString()))
						|| color3.equals(getColorByCombo(comboBox2
								.getSelectedItem().toString()))
						|| color4.equals(getColorByCombo(comboBox2
								.getSelectedItem().toString()))) {
					sameColor++;
				}

				if (color3.equals(getColorByCombo(comboBox3.getSelectedItem()
						.toString()))) {
					samePlace++;
				} else if (color1.equals(getColorByCombo(comboBox3
						.getSelectedItem().toString()))
						|| color2.equals(getColorByCombo(comboBox3
								.getSelectedItem().toString()))
						|| color4.equals(getColorByCombo(comboBox3
								.getSelectedItem().toString()))) {
					sameColor++;
				}

				if (color4.equals(getColorByCombo(comboBox4.getSelectedItem()
						.toString()))) {
					samePlace++;
				} else if (color1.equals(getColorByCombo(comboBox4
						.getSelectedItem().toString()))
						|| color2.equals(getColorByCombo(comboBox4
								.getSelectedItem().toString()))
						|| color3.equals(getColorByCombo(comboBox4
								.getSelectedItem().toString()))) {
					sameColor++;
				}

				if (samePlace == 0) {
					if (sameColor == 0) {
						resultPanels.get(guessCount).setColors("", "", "", "");
					} else if (sameColor == 1) {
						resultPanels.get(guessCount).setColors("black.png", "",
								"", "");
					} else if (sameColor == 2) {
						resultPanels.get(guessCount).setColors("black.png",
								"black.png", "", "");
					} else if (sameColor == 3) {
						resultPanels.get(guessCount).setColors("black.png",
								"black.png", "black.png", "");
					} else if (sameColor == 4) {
						resultPanels.get(guessCount).setColors("black.png",
								"black.png", "black.png", "black.png");
					}
				} else if (samePlace == 1) {
					if (sameColor == 0) {
						resultPanels.get(guessCount).setColors("white.png", "",
								"", "");
					} else if (sameColor == 1) {
						resultPanels.get(guessCount).setColors("white.png",
								"black.png", "", "");
					} else if (sameColor == 2) {
						resultPanels.get(guessCount).setColors("white.png",
								"black.png", "black.png", "");
					} else if (sameColor == 3) {
						resultPanels.get(guessCount).setColors("white.png",
								"black.png", "black.png", "black.png");
					}
				} else if (samePlace == 2) {
					if (sameColor == 0) {
						resultPanels.get(guessCount).setColors("white.png",
								"white.png", "", "");
					} else if (sameColor == 1) {
						resultPanels.get(guessCount).setColors("white.png",
								"white.png", "black.png", "");
					} else if (sameColor == 2) {
						resultPanels.get(guessCount).setColors("white.png",
								"white.png", "black.png", "black.png");
					}
				} else if (samePlace == 3) {
					if (sameColor == 0) {
						resultPanels.get(guessCount).setColors("white.png",
								"white.png", "white.png", "");
					} else if (sameColor == 1) {
						resultPanels.get(guessCount).setColors("white.png",
								"white.png", "white.png", "black.png");
					}
				} else if (samePlace == 4) {
					resultPanels.get(guessCount).setColors("white.png",
							"white.png", "white.png", "white.png");
					JOptionPane.showMessageDialog(null, "You won the game");
					restart();
				}

				System.out.println("place: " + samePlace + " color: "
						+ sameColor);

				guessCount++;
				if (guessCount == 10) {
					showResults();
					int response = JOptionPane.showConfirmDialog(null,
							"You loss the game! Do you want to try again?",
							"Confirm", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.NO_OPTION) {
						close();
					} else if (response == JOptionPane.YES_OPTION) {
						restart();
					} else if (response == JOptionPane.CLOSED_OPTION) {
						close();
					}
				}
			}
		});
		contentPane.add(button_guess);
		
		txtThisProgramIs = new JTextField();
		txtThisProgramIs.setBackground(Color.BLACK);
		txtThisProgramIs.setForeground(Color.WHITE);
		txtThisProgramIs.setText("This program is coded by OG");
		txtThisProgramIs.setBounds(31, 482, 184, 20);
		contentPane.add(txtThisProgramIs);
		txtThisProgramIs.setColumns(10);

		for (int i = 0; i < 10; i++) {
			GuessPanel panel;
			panel = new GuessPanel((i + 1), 1);
			guessPanels.add(panel);
			contentPane.add(panel);

			GuessPanel panel2;
			panel2 = new GuessPanel((i + 1), 2);
			panel2.setColors("", "", "", "");
			resultPanels.add(panel2);
			contentPane.add(panel2);
		}

	}

	public void restart() {
		determineRandomColor();
		guessCount = 0;
		if(frame != null)
			frame.setVisible(false);
		for (int i = 0; i < guessPanels.size(); i++) {
			guessPanels.get(i).setColors("white.png", "white.png", "white.png",
					"white.png");
			resultPanels.get(i).setColors("", "", "",
					"");
		}
	}

	public void close() {
		System.exit(0);
	}

	public String getColor(JComboBox<String> combo) {

		String result = "";

		if (combo.getSelectedItem().toString().equals("Claret Red")) {
			result = "claretRed.png";
		} else if (combo.getSelectedItem().toString().equals("Red")) {
			result = "red.png";
		} else if (combo.getSelectedItem().toString().equals("Navy Blue")) {
			result = "navyBlue.png";
		} else if (combo.getSelectedItem().toString().equals("Blue")) {
			result = "blue.png";
		} else if (combo.getSelectedItem().toString().equals("Purple")) {
			result = "purple.png";
		} else if (combo.getSelectedItem().toString().equals("Yellow")) {
			result = "yellow.png";
		} else if (combo.getSelectedItem().toString().equals("Orange")) {
			result = "orange.png";
		} else if (combo.getSelectedItem().toString().equals("Green")) {
			result = "green.png";
		}

		return result;

	}

	public void addCombo(JComboBox<String> combo, int x) {
		combo.setBounds(x, 10, 75, 20);
		combo.addItem("Claret Red");
		combo.addItem("Red");
		combo.addItem("Navy Blue");
		combo.addItem("Blue");
		combo.addItem("Purple");
		combo.addItem("Yellow");
		combo.addItem("Orange");
		combo.addItem("Green");
		contentPane.add(combo);
	}

	public void determineRandomColor() {
		
		int c1;
		int c2;
		int c3;
		
		
		int color = getRandom();
		c1 = color;
		
		switch (color) {
		case 0:
			color1 = "claretRed.png";
			break;
		case 1:
			color1 = "red.png";
			break;
		case 2:
			color1 = "navyBlue.png";
			break;
		case 3:
			color1 = "blue.png";
			break;
		case 4:
			color1 = "purple.png";
			break;
		case 5:
			color1 = "yellow.png";
			break;
		case 6:
			color1 = "orange.png";
			break;
		case 7:
			color1 = "green.png";
			break;

		default:
			color1 = "green.png";
			break;
		}

		int newOne = getRandom();
		while(newOne == c1){newOne = getRandom();}
		color = newOne;
		c2 = color;
		switch (color) {
		case 0:
			color2 = "claretRed.png";
			break;
		case 1:
			color2 = "red.png";
			break;
		case 2:
			color2 = "navyBlue.png";
			break;
		case 3:
			color2 = "blue.png";
			break;
		case 4:
			color2 = "purple.png";
			break;
		case 5:
			color2 = "yellow.png";
			break;
		case 6:
			color2 = "orange.png";
			break;
		case 7:
			color2 = "green.png";
			break;

		default:
			color2 = "green.png";
			break;
		}

		newOne = getRandom();
		while(newOne == c1 || newOne == c2 ){newOne = getRandom();}
		color = newOne;
		c3 = color;
		switch (color) {
		case 0:
			color3 = "claretRed.png";
			break;
		case 1:
			color3 = "red.png";
			break;
		case 2:
			color3 = "navyBlue.png";
			break;
		case 3:
			color3 = "blue.png";
			break;
		case 4:
			color3 = "purple.png";
			break;
		case 5:
			color3 = "yellow.png";
			break;
		case 6:
			color3 = "orange.png";
			break;
		case 7:
			color3 = "green.png";
			break;

		default:
			color3 = "green.png";
			break;
		}

		newOne = getRandom();
		while(newOne == c1 || newOne == c2 || newOne == c3 ){newOne = getRandom();}
		color = newOne;
		switch (color) {
		case 0:
			color4 = "claretRed.png";
			break;
		case 1:
			color4 = "red.png";
			break;
		case 2:
			color4 = "navyBlue.png";
			break;
		case 3:
			color4 = "blue.png";
			break;
		case 4:
			color4 = "purple.png";
			break;
		case 5:
			color4 = "yellow.png";
			break;
		case 6:
			color4 = "orange.png";
			break;
		case 7:
			color4 = "green.png";
			break;

		default:
			color4 = "green.png";
			break;
		}

		System.out.println("colors: " + color1 + " " + color2 + " " + color3
				+ " " + color4 + " ");
		
		
	}
	
	public int getRandom(){
		return new Random().nextInt(8);
	}

	public String getColorByCombo(String color) {

		String result = "";

		if (color.equals("Claret Red")) {
			result = "claretRed.png";
		} else if (color.equals("Red")) {
			result = "red.png";
		} else if (color.equals("Navy Blue")) {
			result = "navyBlue.png";
		} else if (color.equals("Blue")) {
			result = "blue.png";
		} else if (color.equals("Purple")) {
			result = "purple.png";
		} else if (color.equals("Yellow")) {
			result = "yellow.png";
		} else if (color.equals("Orange")) {
			result = "orange.png";
		} else if (color.equals("Green")) {
			result = "green.png";
		}

		return result;
	}
	
	public void showResults(){
		
		frame = new JFrame("Results");
		frame.setBounds(100, 100, 200, 200);
		
		GuessPanel g = new GuessPanel(0, 0);
		g.setColors(color1, color2, color3, color4);
		frame.getContentPane().add(g);
		frame.setVisible(true);
		
	}
}
