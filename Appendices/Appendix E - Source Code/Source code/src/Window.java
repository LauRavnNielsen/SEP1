import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * A class for generating the main Window of the Manage schedule branch
 * @author Denis-Alexandru Turcu
 * @version 1.0
 */
public class Window extends JFrame implements ActionListener
{
	
	
	JTabbedPane tabbedpane;
	JPanel createschedule;
	JPanel viewSchedule;
	JComboBox comboBox;
	
	JPanel topPanel;
	JLabel topLabel;
	JTextField topField;
	JButton topButton;
	
	JRadioButton L;
	JRadioButton S;
	ButtonGroup group;
	
	JPanel datepanel;
	JLabel text1;
	JLabel text2;
	JTextField field1;
	JTextField field2;
	
	
	JScrollPane scrollPane;
	Template template;
	
	JPanel newRowPanel;
	JButton addRow;
	
	
 	/**
 	 * The main constructor of the Window class
 	 */
	public Window()
	{
		super("Manage Schedule");
		// ====================
		topLabel = new JLabel("Name of schedule: ");
		topField = new JTextField(20);
		topButton = new JButton("Create");
		topButton.addActionListener(this);
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		topPanel.add(topLabel);
		topPanel.add(topField);
		topPanel.add(topButton);
		topPanel.setMaximumSize(new Dimension(10000, 40));
		
		datepanel = new JPanel();
		datepanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		datepanel.setMaximumSize(new Dimension(1000000, 40));
		text1 = new JLabel("Choose date of schedule: ");
	    text2 = new JLabel("Add a comment");
		field1 = new JTextField(10);
		field2 = new JTextField(30);
		JLabel text3 = new JLabel("Select the schedule type : ");
		
		L = new JRadioButton("L",true);
		S = new JRadioButton("S");
		group = new ButtonGroup();
		group.add(L);
		group.add(S);
		
			
		datepanel.add(text1);
		datepanel.add(field1);
		datepanel.add(text2);
		datepanel.add(field2);
		datepanel.add(text3);
		datepanel.add(L);
        datepanel.add(S);
		
		
		
		
		template = new Template();
		scrollPane = new JScrollPane( template, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(template.getPreferredSize().width + 30, 450));
		
		newRowPanel = new JPanel();
		addRow = new JButton("Add row");
		addRow.addActionListener(this);
		newRowPanel.setMaximumSize(new Dimension(100000,40));
		
		createschedule = new JPanel();
		createschedule.add(topPanel);
		createschedule.add(scrollPane);
		createschedule.add(newRowPanel);
		createschedule.add(datepanel);
		viewSchedule = new JPanel();
		tabbedpane = new JTabbedPane();
		tabbedpane.add("View Schedule", viewSchedule);
		ViewSchedulePanel viewSchedulePanel = new ViewSchedulePanel();
		viewSchedule.add(viewSchedulePanel);
		tabbedpane.add("Create Schedule", createschedule);
		tabbedpane.addChangeListener(new MyTabListener());
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		newRowPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		newRowPanel.add(addRow);
		
		add(tabbedpane);
		
		
		setVisible(true);
		setSize(1200, 640);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	/**
	 * The main method of the Window class
	 * @param args
	 */
	public static void main(String[] args)
	{
		new Window();
	}
/**
 * The main action listener for the Window
 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == addRow) {
		template.addNewRow();
		scrollPane.setMaximumSize(new Dimension(template.getPreferredSize().width + 30, template.getPreferredSize().height));
		scrollPane.validate();
		validate();
		repaint();}
		else if(e.getSource() == topButton) {
			ScheduleFileAdapter god = new ScheduleFileAdapter("data.txt");
			ScheduleList list = god.getAllSchedules();
			
			
			if(template.getAllNewAnalysis().size()>0) {
				String name = topField.getText();
				topField.setText("");
		       String comment = field2.getText();
		       field2.setText("");
				String date = field1.getText();
				field1.setText("");
				String type = "";
				
				if(L.isSelected())
					type = "L";
				else
					type = "S";
				
				
				
				Schedule aux = new Schedule(name,date,type,comment);
				for(int i = 0; i < template.getAllNewAnalysis().size();i++) {
					int req = 0;
					
					if(template.getAllNewWeekTypes().get(i).getSelectedItem().toString().equals("L")) {
						req = 2;
					}
					else if(template.getAllNewWeekTypes().get(i).getSelectedItem().toString().equals("S")) {
						req = 3;
					}
					else
					{
						req = 1;
					}
					aux.addTaskMonday(template.getAllNewAnalysis().get(i).getSelectedItem().toString(),req);
					aux.addTaskTuesday(template.getAllNewAnalysis().get(i).getSelectedItem().toString(),req);
					aux.addTaskWednesday(template.getAllNewAnalysis().get(i).getSelectedItem().toString(),req);
					aux.addTaskThursday(template.getAllNewAnalysis().get(i).getSelectedItem().toString(),req);
					aux.addTaskFriday(template.getAllNewAnalysis().get(i).getSelectedItem().toString(),req);
					aux.addTaskSaturday(template.getAllNewAnalysis().get(i).getSelectedItem().toString(),req);
					
				}
				
				list.add(aux);	
			}
			else {
			String name = topField.getText();
			topField.setText("");
	       String comment = field2.getText();
	       field2.setText("");
			String date = field1.getText();
			field1.setText("");
			String type = "";
			
			if(L.isSelected())
				type = "L";
			else
				type = "S";
			
			Schedule aux = new Schedule(name,date,type,comment);
			
			list.add(aux);
			}
			
			god.saveSchedules(list);
			
			
			
			
		}
	}
	
	/**
	 * The listener for changing tabs. This makes it so when you change tabs the GUI is updated
	 * @author Denis-Alexandru Turcu
	 * @version 1.0
	 */
	private class MyTabListener implements ChangeListener
	   {
	      public void stateChanged(ChangeEvent e)
	      {
	    	  if (((JTabbedPane) e.getSource()).getSelectedIndex() == 0)
	          {
	             viewSchedule.removeAll();
	             viewSchedule.add(new ViewSchedulePanel());
	             viewSchedule.repaint();

	          }
	          if (((JTabbedPane) e.getSource()).getSelectedIndex() == 1)
	          {
	        	  viewSchedule.removeAll();
		             viewSchedule.add(new ViewSchedulePanel());
		             viewSchedule.repaint();
	          }
	      }
	   }
	
}
