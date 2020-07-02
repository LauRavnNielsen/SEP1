
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

/**
 * The class which contains the main dashboar. The dashboard consists of the
 * manage schedule window button and the manage employees window button
 * 
 * @author Lau Ravn Nielsen
 * @version 1.0
 */
public class MainPanel extends JFrame {

	/**
	 * The MainPanel is just a small window containing the links to the other
	 * windows which are more complex. Here is the main method of the MainPanel
	 * class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new MainPanel();
	}

	private JFrame window;

	private JPanel mainpanel;
	private JPanel panel;
	private JPanel panel2;

	private JButton button;
	private JButton button2;
/**
 * The main constructor of the Main Panel class
 */
	public MainPanel() {
		super("Main Panel");

		ImageIcon logoIcon = new ImageIcon("eurofins.png");
		JLabel logoLavel = new JLabel();
		logoLavel.setIcon(logoIcon);

		mainpanel = new JPanel();
		mainpanel.setBackground(Color.gray);
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new FlowLayout(FlowLayout.TRAILING));

		panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setLayout(new FlowLayout(FlowLayout.LEADING));

		MyActionListener al = new MyActionListener();
		button = new JButton("Manage employees");
		button.setPreferredSize(new Dimension(175, 150));
		button.addActionListener(al);
		button.setFont(new Font("Arial", Font.BOLD, 25));
		button.setPreferredSize(new Dimension(300, 250));
		button.setBackground(Color.CYAN);

		button2 = new JButton("Manage schedule");
		button2.setPreferredSize(new Dimension(175, 150));
		button2.addActionListener(al);
		button2.setFont(new Font("Arial", Font.BOLD, 25));
		button2.setPreferredSize(new Dimension(300, 250));
		button2.setBackground(Color.CYAN);

		panel.add(logoLavel);
		panel2.add(button);
		panel2.add(button2);
		mainpanel.add(panel);
		mainpanel.add(panel2);
		add(mainpanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(635, 475));
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);

	}
/**
 * The main ActionListener for the 2 big buttons
 * @author Lau Ravn Nielsen
 * @version 1.0
 */
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			if (src == button) {
				new EmployeeFileAdapterGUI();
			} else if (src == button2) {
				new Window();
			}

		}
	}
}
