import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
/**
 * A class for generating a JPanel who exclusively allows for the visualisation of schedules
 * @author Denis-Alexandru Turcu
 * @version 1.0
 */
public class ViewSchedulePanel extends JPanel {

	private ScheduleFileAdapter adapter;

	// auxiliary panels
	private JPanel labelViewSchedules;
	private JList scheduleList;
	private JButton view;
	private JButton delete;
	private JScrollPane scrollPane;

     /**
      * The main constructor of the ViewSchedulePanel
      */
	public ViewSchedulePanel() {

		adapter = new ScheduleFileAdapter("data.txt");
		ScheduleList mainScheduleList = adapter.getAllSchedules();

		// View schedule Tab

		setLayout(new BorderLayout());

		// adding the Heading
		JLabel heading1 = new JLabel();
		labelViewSchedules = new JPanel();
		labelViewSchedules.add(heading1);
		add(labelViewSchedules, BorderLayout.NORTH);
		heading1.setText("Select a schedule from the list below");
		heading1.setFont(new Font("Serif", Font.PLAIN, 36));

		// Setting the view Schedule list
		scheduleList = new JList(mainScheduleList.getAllSchedules().toArray());
	   
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(scheduleList);
		 view = new JButton("View");
		Listener listen = new Listener();
		view.addActionListener(listen);
		add(view,BorderLayout.SOUTH);
		add(scrollPane,BorderLayout.CENTER);
		
		delete = new JButton("Delete");
		delete.addActionListener(new Listener());
		add(delete, BorderLayout.EAST);
		

	}
	
	/**
	 * The main listener of the buttons added to the panel
	 * @author Denis-Alexandru Turcu
	 *
	 */
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== view) {
				
				ScheduleList mainScheduleList = adapter.getAllSchedules();
				new WorkScheduleWindow(mainScheduleList.get(scheduleList.getSelectedIndex()),scheduleList.getSelectedIndex());
			}
			else if(e.getSource()== delete) {
				ScheduleFileAdapter meme = new ScheduleFileAdapter("data.txt");
				ScheduleList aux = meme.getAllSchedules();
				aux.getAllSchedules().remove(scheduleList.getSelectedIndex());
				meme.saveSchedules(aux);
				
				aux = meme.getAllSchedules();
				remove(scrollPane);
				scrollPane = new JScrollPane();
				scheduleList = new JList(aux.getAllSchedules().toArray());
				scrollPane.setViewportView(scheduleList);
				add(scrollPane, BorderLayout.CENTER);
				validate();
				repaint();
			}
		}
	}
	

}
