import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelWithBackground extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private ImageIcon image;

	public JPanelWithBackground(String fileName) {
		try {

			image = new ImageIcon(fileName);
			label = new JLabel(image);
			this.add(label);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void setImage(String fileName) {
		image = new ImageIcon(fileName);
		label.setIcon(image);
		this.add(label);
		this.repaint();
	}

}