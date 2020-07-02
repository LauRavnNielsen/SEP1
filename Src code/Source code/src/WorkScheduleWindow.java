import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
/**
 * A class which generates the main window for viewing and editing the Schedule
 * @author Denis-Alexandru Turcu
 * @version 1.0
 */
public class WorkScheduleWindow extends JFrame{

	private JPanel mainPanel;
	WorkScheduleTable table;
	Schedule input;
	int index;
	JScrollPane scrollPane;
		
		
			
		
	/**
	 * The main constructor of the WorkScheduleWindow
	 * @param var the Schedule that needs to be visualized
	 * @param index The index of the schedule inside the ScheduleList
	 */
	public WorkScheduleWindow(Schedule var, int index) {
		
		super("Assign employees to schedule");
		mainPanel = new JPanel();
		input = var;
		this.index = index;
		
		 table = new WorkScheduleTable();
		 
		 
		 for(int i = 0 ; i<var.getMonday().getNumberOfTasks();i++) {
			 mainPanel.setMaximumSize(new Dimension(table.getPreferredSize().width + 30, table.getPreferredSize().height));
				mainPanel.validate();
			ArrayList<Task> auxList =	var.getMonday().getTaskList();
			
			
			
			String aux = auxList.get(i).getAnalysis().toString();
		   	
			scrollPane = new JScrollPane( table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setPreferredSize(new Dimension(table.getPreferredSize().width + 30, 250));
				table.addNewRow(aux,var.getMonday().getTask(aux).toString(),var.getTuesday().getTask(aux).toString(),var.getWednesday().getTask(aux).toString(),var.getThursday().getTask(aux).toString(),var.getFriday().getTask(aux).toString(),var.getSaturday().getTask(aux).toString(),index);
				table.validate();
				table.repaint();
				
		 }
		 
		 
		JPanel commentPane = new JPanel();
		TitledBorder title2;
	      title2 = BorderFactory.createTitledBorder("About");
	      commentPane.setBorder(title2);
	      JLabel date = new JLabel();
	      date.setText(var.getDate().toString());
	      JLabel commentLabel = new JLabel();
	      commentLabel.setText(var.getAbout());
	      commentPane.add(commentLabel);
	      commentPane.add(date);
	      
	     JButton but = new JButton("Update");
	     but.addActionListener(new Listener());
	     mainPanel.add(but);
	    
	     
	    mainPanel.add(commentPane);
		mainPanel.add(scrollPane);
		
		
		
		
		
		add(mainPanel);
		setVisible(true);
		setSize(900, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	
			
			
		
	}
	/**
	 * The main listener of the WorkScheduleWindow
	 * @author Denis-Alexandru Turcu
	 * @version 1.0
	 */
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			mainPanel.remove(scrollPane);
			 table = new WorkScheduleTable();
			
			 ScheduleFileAdapter adapter = new ScheduleFileAdapter("data.txt");
			
			 
			 Schedule var = adapter.getAllSchedules().get(index);
			 
			 
			 for(int i = 0 ; i<var.getMonday().getNumberOfTasks();i++) {
				 mainPanel.setMaximumSize(new Dimension(table.getPreferredSize().width + 30, table.getPreferredSize().height));
					mainPanel.validate();
				ArrayList<Task> auxList =	var.getMonday().getTaskList();
				
				
				
				String aux = auxList.get(i).getAnalysis().toString();
			   	
					table.addNewRow(aux,var.getMonday().getTask(aux).toString(),var.getTuesday().getTask(aux).toString(),var.getWednesday().getTask(aux).toString(),var.getThursday().getTask(aux).toString(),var.getFriday().getTask(aux).toString(),var.getSaturday().getTask(aux).toString(),index);
					table.validate();
					table.repaint();
					
			 }
			 
			 scrollPane = new JScrollPane( table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setPreferredSize(new Dimension(table.getPreferredSize().width + 30, 250));
			
			
			mainPanel.add(scrollPane);
			mainPanel.validate();
			mainPanel.repaint();
		}
	}
	
	
	
	
}
