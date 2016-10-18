import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class GuessPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<JPanelWithBackground> panels;
	
	public GuessPanel(int row, int column){
		panels = new ArrayList<JPanelWithBackground>();
		this.setBounds((column-1)*180+370, ((row-1)*60)+10, 170, 50);
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		for (int i = 0; i < 4; i++) {
			try {
				JPanelWithBackground j = new JPanelWithBackground("white.png");
				j.setBounds((40*i+10), 10, 30, 30);
				this.add(j);
				panels.add(j);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	} 
	
	public void setColors(String c1, String c2, String c3, String c4){
		
		panels.get(0).setImage(c1);
		panels.get(1).setImage(c2);
		panels.get(2).setImage(c3);
		panels.get(3).setImage(c4);
		
		this.repaint();
	}
	
	
}
