import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The class which generates the table responsible for viewing and changing the Schedule
 * @author Denis-Alexandru Turcu
 * @version 1.0
 */
public class WorkScheduleTable extends JPanel{
JPanel[][] grid;
	
	int rows;
	int rowHeight = 35;
	
	JLabel mon, tue, wed, thu, fri, sat;
	JLabel  analysis;
	JLabel[] pers;
	
	

	ArrayList[] persons;
	
	/**
	 * The main constructor of the class
	 */
	public WorkScheduleTable()
	{
		super();
		
		rows = 0;
		
		// initialize
		mon = new JLabel("Monday");
		tue = new JLabel("Tuesday");
		wed = new JLabel("Wednesday");
		thu = new JLabel("Thursday");
		fri = new JLabel("Friday");
		sat = new JLabel("Satuday");
		
	
		analysis = new JLabel("Analysis");
		
		pers = new JLabel[6];
		for (int i = 0; i < pers.length; i++)
		{
			pers[i] = new JLabel("No. Persons");
		}
		
		
		
		persons = new ArrayList[6];
		
		for (int i = 0; i < persons.length; i++)
		{
			persons[i] = new ArrayList<JTextField>();
		}
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		createGrid();
	}
	
	/**
	 * This method allows for the grid to be created
	 */
	public void createGrid()
	{
		int rows = this.rows + 2;
		removeAll();
		//template.setLayout(null);
		setLayout(new GridLayout(rows, 7));
		setBackground(Color.black);
		grid = new JPanel[rows][7];
		
		for (int r = 0; r < grid.length; r++)
		{
			for (int c = 0; c < grid[r].length; c++)
			{
				grid[r][c] = new JPanel();
				grid[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				grid[r][c].setPreferredSize(new Dimension(60, 30));
				add(grid[r][c]);
			}
		}
		
		grid[0][1].add(mon);
		grid[0][2].add(tue);
		grid[0][3].add(wed);
		grid[0][4].add(thu);
		grid[0][5].add(fri);
		grid[0][6].add(sat);
		
	
		grid[1][0].add(analysis);
		
		for (int i = 1; i < 7; i++)
		{
			grid[1][i].add(pers[i - 1]);
		}
		
		setPreferredSize(new Dimension(800, 2 * rowHeight));
		setMaximumSize(getPreferredSize());
	}
	
	/**
	 * This method allows for new Rows to be added to the table
	 * @param analysis the Analysis column of the table
	 * @param monday the WorkDay "Monday" column
	 * @param tuesday the WorkDay "Tuesday" column
	 * @param wednesday the WorkDay "Wednesday" column
	 * @param thursday the WorkDay "Thursday" column
	 * @param friday the WorkDay "Friday" column
	 * @param saturday the WorkDay "Saturday" column
 	 * @param index The index of that specific schedule inside the ScheduleList
	 */
	public void addNewRow(String analysis,String monday,String tuesday,String wednesday,String thursday,String friday,String saturday,int index)
	{
		JPanel[][] temp = new JPanel[grid.length + 1][7];
		
		for (int r = 0; r < temp.length - 1; r++)
		{
			for (int c = 0; c < temp[r].length; c++)
			{
				temp[r][c] = grid[r][c];
			}
		}
		
		for (int c = 0; c < temp[temp.length - 1].length; c++)
		{
			temp[temp.length - 1][c] = new JPanel(); 
			temp[temp.length - 1][c].setBorder(BorderFactory.createDashedBorder(Color.black));
		}
		
		// analysis
		
		JButton b1 = new JButton(analysis);
		JButton b2 = new JButton(monday);
		JButton b3 = new JButton(tuesday);
		JButton b4 = new JButton(wednesday);
		JButton b5 = new JButton(thursday);
		JButton b6 = new JButton(friday);
		JButton b7 = new JButton(saturday);
		
		b2.addActionListener(new Listener(analysis,index,1));
		b3.addActionListener(new Listener(analysis,index,2));
		b4.addActionListener(new Listener(analysis,index,3));
		b5.addActionListener(new Listener(analysis,index,4));
		b6.addActionListener(new Listener(analysis,index,5));
		b7.addActionListener(new Listener(analysis,index,6));
		
		
			temp[temp.length - 1][0].add(b1);
			temp[temp.length - 1][1].add(b2);
			temp[temp.length - 1][2].add(b3);
			temp[temp.length - 1][3].add(b4);
			temp[temp.length - 1][4].add(b5);
			temp[temp.length - 1][5].add(b6);
			temp[temp.length - 1][6].add(b7);
		
		
		// persons
			
		grid = temp;
		removeAll();
		setLayout(new GridLayout(grid.length, grid[0].length));
		for (int r = 0; r < grid.length; r++)
		{
			for (int c = 0; c < grid[r].length; c++)
			{
				grid[r][c].setPreferredSize(new Dimension(40, 30));
				add(grid[r][c]);
			}
		}
		
		setPreferredSize(new Dimension(800, getPreferredSize().height + rowHeight));
		setMaximumSize(getPreferredSize());
		
		validate();
		
	}
	
	/**
	 * The main Listener for the WorkScheduleTable
	 * @author Denis-Alexandru Turcu
	 * @version 1.0
	 */
	private class Listener implements ActionListener {
		
		String analysis;
		int index;
		int day;
		
		/**
		 * The main constructor of the listener
		 * @param analysis The analysis of the employees
		 * @param day The day to which the employees need to be assigned
		 * @param index The Schedule index inside the ScheduleList
		 */
		public Listener(String analysis, int day, int index) {
			this.analysis = analysis;
			this.index = index;
			this.day = day;
		}
		
		public void actionPerformed(ActionEvent e) {
		
                  
                new SelectEmployeeWindow(index,analysis,day);
                  
			
		}
	}
	
}
