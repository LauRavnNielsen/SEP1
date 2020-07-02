import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A class that generates a table like grid which contains a lot of information about the new Schedule that's going to be  created
 * @author Tamas Fekete
 * @version 1.0
 */
public class Template extends JPanel
{
	
	JPanel[][] grid;
	
	int rows;
	int rowHeight = 40;
	
	JLabel mon, tue, wed, thu, fri, sat;
	JLabel matrix, week, analysis;
	JLabel[] pers;
	JLabel l1,l2,l3,s1,s2,s3,all1,all2,all3;
	JLabel one,one2,one3,one4,one5,one6,one7,one8,one9,one10,one11,one12,one13,one14,one15,one16, two1,two2,two3,two4,two5,two6,two7,two8,two9,two10,two11,two12,two13,two14,two15,two16,two17, three1,three2,three3;
	JLabel fat1,fat2,protein1,protein2,fiber,sugar;
	
	
	
	
	ArrayList<JComboBox<Weektype>> weeks;
	ArrayList<JComboBox<Analysisl>> analyses;
    JComboBox<Analysisl> lastCombo;
	JComboBox<Weektype> lastType;
	ArrayList<JComboBox<Weektype>> newRowAddedW = new ArrayList<JComboBox<Weektype>>();
	ArrayList<JComboBox<Analysisl>> newRowAddedA = new ArrayList<JComboBox<Analysisl>>();
	int numOfNewRows = 0;
	
	ArrayList[] persons;
	
	/**
	 * This is the main constructor of the function
	 */
	public Template()
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
		
		matrix = new JLabel("Matrix");
		week = new JLabel("Week Type");
		analysis = new JLabel("Analysis");
		
		s1 = new JLabel("S");
		s2 = new JLabel("S");
		s3 = new JLabel("S");
		l1 = new JLabel("L");
		l2 = new JLabel("L");
		l3 = new JLabel("L");
		all1 = new JLabel("All");
		all2 = new JLabel("All");
		all3 = new JLabel("All");
		
		fat1 = new JLabel("Fat");
		fat2 = new JLabel("Fat");
		protein1 = new JLabel("Protein");
		protein2 = new JLabel("Protein");
		fiber = new JLabel("Fiber");
		sugar = new JLabel("sugar");
		
		
		one = new JLabel("1");
		one2 = new JLabel("1");
		one3 = new JLabel("1");
		one4 = new JLabel("1");
		one5 = new JLabel("1");
		one6 = new JLabel("1");
		one7 = new JLabel("1");
		one8 = new JLabel("1");
		one9 = new JLabel("1");
		one10 = new JLabel("1");
		one11 = new JLabel("1");
		one12 = new JLabel("1");
		one13 = new JLabel("1");
		one14 = new JLabel("1");
		one15 = new JLabel("1");
		one16 = new JLabel("1");
		two1 = new JLabel("2");
		two2 = new JLabel("2");
		two3 = new JLabel("2");
		two4 = new JLabel("2");
		two5 = new JLabel("2");
		two6 = new JLabel("2");
		two7 = new JLabel("2");
		two8 = new JLabel("2");
		two9 = new JLabel("2");
		two10 = new JLabel("2");
		two11= new JLabel("2");
		two12= new JLabel("2");
		two13= new JLabel("2");
		two14= new JLabel("2");
		two15= new JLabel("2");
		two16= new JLabel("2");
		two17= new JLabel("2");
		three1 = new JLabel("3");
		three2 = new JLabel("3");
		three3 = new JLabel("3");
		
				
		
		
		
		pers = new JLabel[6];
		for (int i = 0; i < pers.length; i++)
		{
			pers[i] = new JLabel("No. Persons");
		}
		
		weeks = new ArrayList<>();
		analyses = new ArrayList<>();
		
		persons = new ArrayList[6];
		
		for (int i = 0; i < persons.length; i++)
		{
			persons[i] = new ArrayList<JTextField>();
		}
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		createGrid();
	}
	
	/**
	 * This method generates the Grid
	 */
	public void createGrid()
	{
		int rows = this.rows + 8;
		removeAll();
		//template.setLayout(null);
		setLayout(new GridLayout(rows, 8));
		setBackground(Color.black);
		grid = new JPanel[rows][8];
		
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
		
		grid[0][2].add(mon);
		grid[0][3].add(tue);
		grid[0][4].add(wed);
		grid[0][5].add(thu);
		grid[0][6].add(fri);
		grid[0][7].add(sat);
		
		
		grid[1][0].add(week);
		grid[1][1].add(analysis);
		
		grid[2][0].add(l1);
		grid[3][0].add(l2);
		grid[4][0].add(s1);
		grid[5][0].add(s2);
		grid[6][0].add(all1);
		grid[7][0].add(all2);
		
		
		grid[2][1].add(fat1);
		grid[3][1].add(protein1);
		grid[4][1].add(fat2);
		grid[5][1].add(protein2);
		grid[6][1].add(fiber);
		grid[7][1].add(sugar);
		
		grid[2][2].add(two1);
		grid[2][3].add(two2);
		grid[2][4].add(two3);
		grid[2][5].add(two4);
		grid[2][6].add(two5);
		grid[2][7].add(one);
		
		grid[3][2].add(two6);
		grid[3][3].add(two7);
		grid[3][4].add(two8);
		grid[3][5].add(two9);
		grid[3][6].add(two10);
		grid[3][7].add(one2);
		
		grid[4][2].add(three1);
		grid[4][3].add(three2);
		grid[4][4].add(three3);
		grid[4][5].add(two11);
		grid[4][6].add(two12);
		grid[4][7].add(one3);
		
		grid[5][2].add(two13);
		grid[5][3].add(two14);
		grid[5][4].add(two15);
		grid[5][5].add(two16);
		grid[5][6].add(two17);
		grid[5][7].add(one4);
		
		grid[6][2].add(one5);
		grid[6][3].add(one6);
		grid[6][4].add(one7);
		grid[6][5].add(one8);
		grid[6][6].add(one9);
		grid[6][7].add(one10);
		
		grid[7][2].add(one11);
		grid[7][3].add(one12);
		grid[7][4].add(one13);
		grid[7][5].add(one14);
		grid[7][6].add(one15);
		grid[7][7].add(one16);
		
		
		

		for (int i = 2; i < 8; i++)
		{
			grid[1][i].add(pers[i - 2]);
		}
		
		setPreferredSize(new Dimension(800, grid.length * rowHeight));
		setMaximumSize(getPreferredSize());
		validate();
	}
	
	
	/**
	 * This method allows for new rows to be added inside the template( This was not fully coded yet inside the GUI )
	 */
	public void addNewRow()
	{
		JPanel[][] temp = new JPanel[grid.length + 1][8];
		
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
		
		
		
		
		// week
		weeks.add(new JComboBox<Weektype>());
		weeks.get(weeks.size() -1).addItem(Weektype.l);
		weeks.get(weeks.size() -1).addItem(Weektype.s);
		weeks.get(weeks.size()-1).addItem(Weektype.all);
		
		lastType = weeks.get(weeks.size()-1);
		newRowAddedW.add(lastType);
		
		
		temp[temp.length - 1][0].add(weeks.get(weeks.size() -1));
		
		// analysis
		analyses.add(new JComboBox<Analysisl>());
		analyses.get(analyses.size()-1).addItem(Analysisl.cattle);
		analyses.get(analyses.size()-1).addItem(Analysisl.enzymes);
		analyses.get(analyses.size()-1).addItem(Analysisl.fat);
		analyses.get(analyses.size()-1).addItem(Analysisl.fiber);
		analyses.get(analyses.size()-1).addItem(Analysisl.milk);
		analyses.get(analyses.size()-1).addItem(Analysisl.pig);
		analyses.get(analyses.size()-1).addItem(Analysisl.protein);
		analyses.get(analyses.size()-1).addItem(Analysisl.stratch);
		analyses.get(analyses.size()-1).addItem(Analysisl.sugar);
		
		lastCombo = analyses.get(analyses.size()-1);
		newRowAddedA.add(lastCombo);
		
		
		
		temp[temp.length - 1][1].add(analyses.get(analyses.size() -1));
		// persons
			
		grid = temp;
		
		
		
		removeAll();
		setLayout(new GridLayout(grid.length, grid[0].length));
		for (int r = 0; r < grid.length; r++)
		{
			for (int c = 0; c < grid[r].length; c++)
			{
				grid[r][c].setPreferredSize(new Dimension(60, 30));
				add(grid[r][c]);
			}
		}
		
		setPreferredSize(new Dimension(800, grid.length * rowHeight));
		System.out.println(grid.length);
		
		setMaximumSize(getPreferredSize());
		
		validate();
	}
	
	/**
	 * A method for returning the last selected item inside the JComboBox that are not part of the default grid
	 * @return the String containing the selected analysis
	 */
	public String getLastAnalysis() {
		
		return lastCombo.getSelectedItem().toString();
	}
	
	/**
	 * A method for returning the last selected item inside the JComboBox that are not part of the default grid
	 * @return the String containing the selected type
	 */
	public String getLastType() {
		
		return lastType.getSelectedItem().toString();
	}
	
	/**
	 * A method for returning all the newly created JComboBox elements that are not part of the default grid
	 * @return The newly created JComboBox elements
	 */
	public ArrayList<JComboBox<Weektype>> getAllNewWeekTypes() {
		
	return newRowAddedW;
	}
	
	/**
	 * A method for returning all the newly created JComboBox elements that are not part of the default grid
	 * @return The newly created JComboBox elements
	 */
	public ArrayList<JComboBox<Analysisl>> getAllNewAnalysis() {
		
		return newRowAddedA;	 
		}
		
	
	
	
}
