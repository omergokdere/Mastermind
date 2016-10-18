import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class ResultFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GuessPanel results;

	/**
	 * Create the frame.
	 */
	public ResultFrame() {
		setTitle("COLORS");
		setBounds(100, 100, 343, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		results = new GuessPanel(1, 1);
		contentPane.add(results);
	}
	
	public void setContent(JPanel panel){
		contentPane = panel;
		this.repaint();
	}
	
	public GuessPanel getPanel(){
		return results;
	}

}
