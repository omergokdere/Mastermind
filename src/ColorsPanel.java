import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ColorsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<JPanelWithBackground> colors;

	public ColorsPanel() {

		colors = new ArrayList<JPanelWithBackground>();

		this.setBounds(10, 550, 330, 50);
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		try {
			JPanelWithBackground j = new JPanelWithBackground("claretRed.png");
			j.setBounds(10, 10, 30, 30);
			this.add(j);
			colors.add(j);
			
			JPanelWithBackground j2 = new JPanelWithBackground("red.png");
			j2.setBounds(50, 10, 30, 30);
			this.add(j2);
			colors.add(j2);
			
			JPanelWithBackground j3 = new JPanelWithBackground("navyBlue.png");
			j3.setBounds(90, 10, 30, 30);
			this.add(j3);
			colors.add(j3);
			
			JPanelWithBackground j4 = new JPanelWithBackground("blue.png");
			j4.setBounds(130, 10, 30, 30);
			this.add(j4);
			colors.add(j4);
			
			JPanelWithBackground j5 = new JPanelWithBackground("purple.png");
			j5.setBounds(170, 10, 30, 30);
			this.add(j5);
			colors.add(j5);
			
			JPanelWithBackground j6 = new JPanelWithBackground("yellow.png");
			j6.setBounds(210, 10, 30, 30);
			this.add(j6);
			colors.add(j6);
			
			JPanelWithBackground j7 = new JPanelWithBackground("orange.png");
			j7.setBounds(250, 10, 30, 30);
			this.add(j7);
			colors.add(j7);
			
			JPanelWithBackground j8 = new JPanelWithBackground("green.png");
			j8.setBounds(290, 10, 30, 30);
			this.add(j8);
			colors.add(j8);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
