import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * This is the main window for selecting an employee and then assigning it to the Schedule
 * @author Denis-Alexandru Turcu
 * @version 1.0
 */
public class SelectEmployeeWindow extends JFrame{

	 JPanel mainPanel;
	 JScrollPane scrollPane;
	 JList list;
	 JButton assign;
	 JButton unassign;
	 int index;
	 int day;
	 Employee selected;
	 ArrayList<Employee> employees;
	 String analysis;
	 
	 
	/**
	 * The main constructor of the SelectedEmployeeWindow, it takes 2 ints and a String in order to generate the window
	 * @param day The day of the week that we are working on
	 * @param analysis The analysis in which we need to assign people
	 * @param index the index of the Schedule in the ScheduleList
	 */
	public SelectEmployeeWindow(int day,String analysis,int index) {
		
		
		super("Select an employee to assign");
		
		this.analysis = analysis;
		this.day = day;
		this.index = index;
		
		
		mainPanel = new JPanel();
		scrollPane = new JScrollPane();
		MasterFileAdapter god = new MasterFileAdapter("employees.bin");
		employees = god.getAllEmployees().getEmployeesWithAnalysis(analysis);
		list = new JList(god.getAllEmployees().getEmployeesWithAnalysis(analysis).toArray());
		scrollPane.setPreferredSize(new Dimension(300,300));
		scrollPane.setViewportView(list);
		assign = new JButton("Assign");
		unassign = new JButton("Unassign all");
		unassign.addActionListener(new Listener());
		assign.addActionListener(new Listener());
		mainPanel.add(assign);
		mainPanel.add(unassign);
		mainPanel.add(scrollPane);
		
		
		
		add(mainPanel);
		
		
		
		
        
		
		
		
		
		
		
		setVisible(true);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	/**
	 * The main Listener for the SelectEmployeeWindow
	 * @author Denis-Alexandru Turcu
	 * @version 1.0
	 */
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ScheduleFileAdapter god = new ScheduleFileAdapter("data.txt");
			ScheduleList temp = god.getAllSchedules();
			
			
			if(e.getSource() == assign) {
			selected = employees.get(list.getSelectedIndex());
			
			if(day == 1) {
				temp.get(index).getMonday().getTask(analysis).AssignEmployee(selected);
				System.out.println("hey");
			}
			else if(day == 2) {
				temp.get(index).getTuesday().getTask(analysis).AssignEmployee(selected);
				System.out.println("hey");
			}
			else if(day == 3) {
				temp.get(index).getWednesday().getTask(analysis).AssignEmployee(selected);
				System.out.println("hey");
			}
			else if(day == 4) {
				temp.get(index).getThursday().getTask(analysis).AssignEmployee(selected);
				System.out.println("hey");
			}
			else if(day == 5) {
				temp.get(index).getFriday().getTask(analysis).AssignEmployee(selected);
				System.out.println("hey");
			}
			else if(day == 6) {
				temp.get(index).getSaturday().getTask(analysis).AssignEmployee(selected);
				System.out.println("hey");
			}
			
			god.saveSchedules(temp);
			}
			else if(e.getSource() == unassign) {
				
				if(day == 1) {
					temp.get(index).getMonday().getTask(analysis).unAssignAll();;
					System.out.println("hey");
				}
				else if(day == 2) {
					temp.get(index).getTuesday().getTask(analysis).unAssignAll();;
					System.out.println("hey");
				}
				else if(day == 3) {
					temp.get(index).getWednesday().getTask(analysis).unAssignAll();;
					System.out.println("hey");
				}
				else if(day == 4) {
					temp.get(index).getThursday().getTask(analysis).unAssignAll();;
					System.out.println("hey");
				}
				else if(day == 5) {
					temp.get(index).getFriday().getTask(analysis).unAssignAll();;
					System.out.println("hey");
				}
				else if(day == 6) {
					temp.get(index).getSaturday().getTask(analysis).unAssignAll();;
					System.out.println("hey");
				}
				
				god.saveSchedules(temp);
			}
			
			
			
			god.saveSchedules(temp);
		
		}
		
		
	
	}
	
	
	
	
	
	
}
