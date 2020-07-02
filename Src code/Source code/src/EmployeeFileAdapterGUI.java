
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;







/**
 * A user interface that allows for displaying and modifying information about Employees.
 * @author Sebastien Malmberg
 * @version 1.0 
 */
public class EmployeeFileAdapterGUI extends JFrame
{
   private MasterFileAdapter adapter;
   
   private JTabbedPane tabPane;
   
   private AllEmployeesPanel allEmployeesPanel;
   private JPanel removeEmployeePanel;
   private JPanel addEmployeePanel;
   private JPanel employeeInfoPanel;
   private JPanel analysisPanel;
  
   private JPanel checkBoxStackPanel1;
   private JPanel checkBoxStackPanel2;
   private JPanel checkBoxStackPanel3;
   private JPanel checkBoxStackPanel4;
   
   private JList<Employee> allEmployeesList;

   
   private JLabel firstNameLabel;
   
   private JLabel lastNameLabel;
  
   private JLabel initialsLabel;
   private JLabel dateOfBirthLabel;
  
   private JLabel addressLabel;
   
   private JLabel phoneNumberLabel;
 
   private JLabel commentsLabel;
   private JLabel dateHiredLabel;
   
   
   private JTextField  firstNameField;
   private JTextField  firstNameField2;
   private JTextField  lastNameField;
   private JTextField  lastNameField2;
   private JTextField  analysisField;
   private JTextField  initialsField;
   private JTextField  dateOfBirthField;
   private JTextField  addressField;
   private JTextField  addressField2;
   private JTextField  phoneNumberField;
   private JTextField  phoneNumberField2;
   private JTextField  schedulesField;
   private JTextField  commentsField;
   private JTextField  dateHiredField;
   
   private JCheckBox fatBox;
   private JCheckBox proteinBox;
   private JCheckBox starchBox;
   private JCheckBox sugarBox;
   private JCheckBox fiberBox;
   private JCheckBox milkBox;
   private JCheckBox pigBox;
   private JCheckBox cattleBox;
   private JCheckBox enzymesBox;
   private JCheckBox fullTimeBox;
   private JCheckBox flexBox;
   
   private JButton saveButton;
 
   private JButton removeButton;
  
   
   private JPanel comboPanel;
  
   private JComboBox<Employee> employeeBox;
   private JComboBox<Employee> removeBox;
   
   private MyButtonListener buttonListener;
   private MyTabListener tabListener;
   private MyListSelectionListener listListener;
   
   private JMenuBar menuBar;
   
   private JMenu fileMenu;
   private JMenu editMenu;
   private JMenu aboutMenu;

   private JMenuItem exitMenuItem;
   private JMenuItem aboutMenuItem;

   private JCheckBoxMenuItem editAreaMenuItem;
   private JCheckBoxMenuItem editFieldsMenuItem;
   /**
    * No-argument constructor initializing the GUI components
    */
   public EmployeeFileAdapterGUI()
   {
      super("Employee File Adapter GUI");
      
      adapter = new MasterFileAdapter("employees.bin");
      
     
      
      buttonListener = new MyButtonListener();
      tabListener = new MyTabListener();
      listListener = new MyListSelectionListener();
      
      TitledBorder title;
      title = BorderFactory.createTitledBorder("Employee Information");
      
      
      //Menu
      
      exitMenuItem = new JMenuItem("Exit");
      exitMenuItem.addActionListener(buttonListener);

      aboutMenuItem = new JMenuItem("About");
      aboutMenuItem.addActionListener(buttonListener);

      editAreaMenuItem = new JCheckBoxMenuItem("Edit Employee area", false);
      editAreaMenuItem.addActionListener(buttonListener);

      editFieldsMenuItem = new JCheckBoxMenuItem("Edit name fields", false);
      editFieldsMenuItem.addActionListener(buttonListener);

      fileMenu = new JMenu("File");
      editMenu = new JMenu("Edit");
      aboutMenu = new JMenu("About");

      fileMenu.add(exitMenuItem);

      editMenu.add(editAreaMenuItem);
      editMenu.add(editFieldsMenuItem);

      aboutMenu.add(aboutMenuItem);

      menuBar = new JMenuBar();

      menuBar.add(fileMenu);
      menuBar.add(editMenu);
      menuBar.add(aboutMenu);
      
      setJMenuBar(menuBar);
      

      // Add Employee 
      
      addEmployeePanel = new JPanel();
      checkBoxStackPanel1 = new JPanel();
      checkBoxStackPanel1.setLayout(new BoxLayout(checkBoxStackPanel1, BoxLayout.X_AXIS));
      addEmployeePanel.setLayout(new BoxLayout(addEmployeePanel, BoxLayout.Y_AXIS));
      employeeInfoPanel = new JPanel();
      employeeInfoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      
   
      employeeInfoPanel.setBorder(title);
      
      
      firstNameLabel = new JLabel("First Name: ");
      firstNameLabel.setPreferredSize(new Dimension(75, 20));
      firstNameField = new JTextField(15);
      
      lastNameLabel = new JLabel("Last Name: ");
      lastNameLabel.setPreferredSize(new Dimension(75, 20));
      lastNameField = new JTextField(15);
   
      initialsLabel = new JLabel("Initials: ");
      initialsLabel.setPreferredSize(new Dimension(75, 20));
      initialsField = new JTextField(15);
      
      addressLabel = new JLabel("Address: ");
      addressLabel.setPreferredSize(new Dimension(75, 20));
      addressField = new JTextField(15);
      
      phoneNumberLabel = new JLabel("Phone: ");     
      phoneNumberLabel.setPreferredSize(new Dimension(75, 20));
      phoneNumberField = new JTextField(15);
      
      dateOfBirthLabel = new JLabel("Date of birth: ");
      dateOfBirthLabel.setPreferredSize(new Dimension(75, 20));
      dateOfBirthField = new JTextField(15);
      
      dateHiredLabel = new JLabel("Date hired: ");
      dateHiredLabel.setPreferredSize(new Dimension(75, 20));
      dateHiredField = new JTextField(15);
      
      commentsLabel = new JLabel("Comments: ");
      commentsLabel.setPreferredSize(new Dimension(75, 20));
      commentsField = new JTextField(15);
      
      employeeInfoPanel.add(firstNameLabel);
      employeeInfoPanel.add(firstNameField);
      
      
      flexBox = new JCheckBox("Flex", false);
      flexBox.addActionListener(buttonListener);
      
      fullTimeBox = new JCheckBox("Full time", false);
      fullTimeBox.addActionListener(buttonListener);
      
      employeeInfoPanel.add(lastNameLabel);
      employeeInfoPanel.add(lastNameField);
      
      employeeInfoPanel.add(initialsLabel);
      employeeInfoPanel.add(initialsField);
      
      employeeInfoPanel.add(addressLabel);
      employeeInfoPanel.add(addressField);
      
      employeeInfoPanel.add(phoneNumberLabel);
      employeeInfoPanel.add(phoneNumberField);
      
      employeeInfoPanel.add(dateOfBirthLabel);
      employeeInfoPanel.add(dateOfBirthField);
      
      employeeInfoPanel.add(dateHiredLabel);
      employeeInfoPanel.add(dateHiredField);
      
      employeeInfoPanel.add(commentsLabel);
      employeeInfoPanel.add(commentsField);
      
      checkBoxStackPanel1.add(flexBox);
      checkBoxStackPanel1.add(fullTimeBox);
      
      employeeInfoPanel.add(checkBoxStackPanel1);
      
      addEmployeePanel.add(employeeInfoPanel);
      
      
      // adding all the checkBoxes
      
      analysisPanel = new JPanel();
      checkBoxStackPanel2 = new JPanel();
      checkBoxStackPanel3 = new JPanel();
      checkBoxStackPanel4 = new JPanel();
      checkBoxStackPanel2.setLayout(new BoxLayout(checkBoxStackPanel2, BoxLayout.Y_AXIS));
      checkBoxStackPanel3.setLayout(new BoxLayout(checkBoxStackPanel3, BoxLayout.Y_AXIS));
      checkBoxStackPanel4.setLayout(new BoxLayout(checkBoxStackPanel4, BoxLayout.Y_AXIS));
      TitledBorder title2;
      title2 = BorderFactory.createTitledBorder("Analysis");
      analysisPanel.setBorder(title2);
      
      fatBox = new JCheckBox("FAT", false);
      fatBox.addActionListener(buttonListener);
      
      proteinBox = new JCheckBox("PROTEIN", false);
      proteinBox.addActionListener(buttonListener);
      
      milkBox = new JCheckBox("MILK", false);
      milkBox.addActionListener(buttonListener);
      
      fiberBox = new JCheckBox("FIBER", false);
      fiberBox.addActionListener(buttonListener);
      
      sugarBox = new JCheckBox("SUGAR", false);
      sugarBox.addActionListener(buttonListener);
      
      enzymesBox = new JCheckBox("ENZYMES", false);
      enzymesBox.addActionListener(buttonListener);
      
      starchBox = new JCheckBox("STARCH", false);
      starchBox.addActionListener(buttonListener);
      
      cattleBox = new JCheckBox("CATTLE", false);
      cattleBox.addActionListener(buttonListener);
      
      pigBox = new JCheckBox("PIG", false);
      pigBox.addActionListener(buttonListener);
      
      
      checkBoxStackPanel2.add(fatBox);
      checkBoxStackPanel2.add(proteinBox);
      checkBoxStackPanel2.add(milkBox);
      analysisPanel.add(checkBoxStackPanel2);
      
      checkBoxStackPanel3.add(fiberBox);
      checkBoxStackPanel3.add(sugarBox);
      checkBoxStackPanel3.add(enzymesBox);
      analysisPanel.add(checkBoxStackPanel3);
      
      checkBoxStackPanel4.add(starchBox);
      checkBoxStackPanel4.add(cattleBox);
      checkBoxStackPanel4.add(pigBox);
      analysisPanel.add(checkBoxStackPanel4);
      
      
      analysisPanel.setPreferredSize(new Dimension(200, 50));
      addEmployeePanel.add(analysisPanel);
      
      saveButton = new JButton("Save");
      saveButton.addActionListener(buttonListener);
      addEmployeePanel.add(saveButton);
      
      //remove employee
      
      comboPanel = new JPanel();
      removeEmployeePanel = new JPanel();
      
      employeeBox = new JComboBox<Employee>();
      employeeBox.addActionListener(buttonListener);
      comboPanel.add(employeeBox);
     

      removeBox = new JComboBox<Employee>();
      removeBox.addActionListener(buttonListener);
      comboPanel.add(removeBox);

      removeButton = new JButton("Remove");
      removeButton.addActionListener(buttonListener);

      removeEmployeePanel.add(removeButton);

      removeEmployeePanel.add(removeBox);
      
      
      //Tabs
      
      allEmployeesPanel = new AllEmployeesPanel(adapter);
      
      tabPane = new JTabbedPane();
      tabPane.addTab("All Employees", allEmployeesPanel);
      tabPane.addTab("Add Employee", addEmployeePanel);
      tabPane.addTab("Remove Employee", removeEmployeePanel);
      tabPane.addChangeListener(tabListener);
          
      add(tabPane);
      setSize(580, 480);
      setVisible(true);
      setResizable(false);

      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      setLocationRelativeTo(null);
      
   }
   /**
    * Updates the removeBox JComboBox with information from the Employee file
    */
   private void updateRemoveBox()
   {
      int currentIndex = employeeBox.getSelectedIndex();
      
      removeBox.removeAllItems();
      
      EmployeeList employees = adapter.getAllEmployees();
      for (int i = 0; i < employees.sizeEmployeeList(); i++)
      {
         removeBox.addItem(employees.getEmployeeAtIndex(i));
      }
      if(currentIndex == -1 && employeeBox.getItemCount() > 0)
      {
         removeBox.setSelectedItem(0);
      }
      else
      {
         removeBox.setSelectedItem(currentIndex);
      }
   }
   /**
    * Updates the employeeBoc JComboBox with information from the Employee file
    */
   private void updateEmployeeBox()
   {
      int currentIndex = employeeBox.getSelectedIndex();
      
      employeeBox.removeAllItems();
      
      EmployeeList employees = adapter.getAllEmployees();
      for (int i = 0; i < employees.sizeEmployeeList(); i++)
      {
         employeeBox.addItem(employees.getEmployeeAtIndex(i));
      }
      if(currentIndex == -1 && employeeBox.getItemCount() > 0)
      {
         employeeBox.setSelectedIndex(0);
      }
      else
      {
         employeeBox.setSelectedIndex(currentIndex);
      }
   }
   /**
    * clears all the JCheckBoxes in the addEmployeePanel.
    */
   private void clearOptions()
   {
      fatBox.setSelected(false);
      proteinBox.setSelected(false);
      cattleBox.setSelected(false);
      sugarBox.setSelected(false);
      pigBox.setSelected(false);
      enzymesBox.setSelected(false);
      milkBox.setSelected(false);
      fiberBox.setSelected(false);
      starchBox.setSelected(false);
   }
   
/**
 * Inner action listener class
 * @author Sébastien Malmberg
 * @version 1.0
 */
   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
        
         if(e.getSource() == saveButton)
         {
            
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String phoneNumber = phoneNumberField.getText();
            String address = addressField.getText();
            String initials = initialsField.getText();
            String dateHired = dateHiredField.getText();
            String dateOfBirth = dateOfBirthField.getText();
            String comments = commentsField.getText();
            
            
            if(address.equals(""))
            {
               address = "?";
            }
            if(phoneNumber.equals(""))
            {
               phoneNumber = "?";
            } 
            if (firstName.equals(""))
            {
               firstName = "?";
            }
            if (lastName.equals(""))
            {
               lastName = "?";
            }
            if (initials.equals(""))
            {
               initials = "(" + firstName.charAt(0) + "" + lastName.charAt(0) + ")";
            }
            if(dateHired.equals(""))
            {
               dateHired = "?";
            }
            if(dateOfBirth.equals(""))
            {
               dateOfBirth = "?";
            }
            if(comments.equals(""))
            {
               comments = "?";
            }
           
           
            Employee temp = new Employee(firstName, lastName, initials, address, phoneNumber, dateOfBirth, dateHired, comments);
            if(fatBox.isSelected())
            {
               temp.getAnalysisForEmployee().add(ana.get("Fat"));
               
            }
            if(proteinBox.isSelected())
            {
               temp.getAnalysisForEmployee().add(ana.get("Protein"));
            }
            if(cattleBox.isSelected())
            {
               temp.getAnalysisForEmployee().add(ana.get("Cattle"));
            }
            if(pigBox.isSelected())
            {
               temp.getAnalysisForEmployee().add(ana.get("Pig"));
            }
            if(enzymesBox.isSelected())
            {
               temp.getAnalysisForEmployee().add(ana.get("Enzymes"));
            }
            if(starchBox.isSelected())
            {
               temp.getAnalysisForEmployee().add(ana.get("Starch"));
            }
            if(sugarBox.isSelected())
            {
               temp.getAnalysisForEmployee().add(ana.get("Sugar"));
            }
            if(fiberBox.isSelected())
            {
               temp.getAnalysisForEmployee().add(ana.get("Fiber"));
            }
            if(milkBox.isSelected())
            {
               temp.getAnalysisForEmployee().add(ana.get("Milk"));
               
            }
            adapter.addEmployee(temp);
            firstNameField.setText("");
            lastNameField.setText("");
            initialsField.setText("");
            phoneNumberField.setText("");
            addressField.setText("");
            dateHiredField.setText("");
            dateOfBirthField.setText("");
            commentsField.setText("");
            clearOptions();
            
            allEmployeesPanel.updateEmployeeList();
            
            
          
          
         
         }
         if(e.getSource() == removeButton)
         {
            if (removeBox.getSelectedItem() instanceof Employee)
            {
               Employee temp = (Employee) removeBox.getSelectedItem();
               adapter.removeEmployee(temp);
               updateRemoveBox();
               
            }
         }
         if (e.getSource() == exitMenuItem)
         {
            int choice = JOptionPane.showConfirmDialog(null,
                  "Do you really want to exit the program?", "Exit",
                  JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION)
            {
               System.exit(0);
            }
         }
        
         if (e.getSource() == editFieldsMenuItem)
         {
            if (editFieldsMenuItem.isSelected())
            {
               firstNameField2.setEditable(true);
               lastNameField2.setEditable(true);
               addressField2.setEditable(true);
               phoneNumberField2.setEditable(true);
               commentsField.setEditable(true);
               analysisField.setEditable(true);
               schedulesField.setEditable(true);
               dateHiredField.setEditable(true);
               
               
            }
            else
            {
               firstNameField2.setEditable(false);
               lastNameField2.setEditable(false);
               addressField2.setEditable(false);
               phoneNumberField2.setEditable(false);
               commentsField.setEditable(false);
               analysisField.setEditable(false);
               schedulesField.setEditable(false);
               dateHiredField.setEditable(false);
               
               
            }
         }
         if (e.getSource() == aboutMenuItem)
         {
            JOptionPane.showMessageDialog(null,
                  "This is a little program ment to help you manage employees!",
                  "About", JOptionPane.PLAIN_MESSAGE);
         }
      }
   }
   /**
    * Inner change listener class
    * @author Sébastien Malmberg 
    * @version 1.0
    */
   private class MyTabListener implements ChangeListener
   {
      public void stateChanged(ChangeEvent e)
      {
         if (((JTabbedPane) e.getSource()).getSelectedIndex() == 0)
         {
            allEmployeesPanel.updateEmployeeList();

         }
         if (((JTabbedPane) e.getSource()).getSelectedIndex() == 2)
         {
           updateRemoveBox();
           updateEmployeeBox();
         }
      }
   }
   /**
    * Inner list selection listener class
    * @author Sébastien Malmberg
    * @version 1.0
    */
  private class MyListSelectionListener implements ListSelectionListener
  {
     public void valueChanged(ListSelectionEvent e)
     {
        if(e.getSource() == allEmployeesList)
        {
           if(allEmployeesList.getSelectedValue() instanceof Employee)
           {
              Employee temp = (Employee)allEmployeesList.getSelectedValue();
              firstNameField2.setText(temp.getFirstName());
              lastNameField2.setText(temp.getLastName());
           }
        }
     }
  }   
  
  public static void main(String[] args)
{
     EmployeeFileAdapterGUI efaG = new EmployeeFileAdapterGUI();
}
        
  
}
