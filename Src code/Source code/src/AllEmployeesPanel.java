
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;




/**
 * A GUI panel containing components for viewing an Employee and changing its information. 
 * @author Sébastien Malmberg
 * @version 1.0
 */
public class AllEmployeesPanel extends JPanel
{
   private MasterFileAdapter adapter;
   private MyButtonListener buttonListener;
   private MyListSelectionListener listListener;
   
   private JPanel inputPanel;
   
   
   private JLabel firstNameLabel2; 
   private JLabel lastNameLabel2;
   private JLabel analysisLabel;
   private JLabel addressLabel2;
   private JLabel phoneNumberLabel2;
   private JLabel schedulesLabel;
   private JLabel commentsLabel;
   private JLabel dateHiredLabel;

   
   private JTextField  firstNameField2;
   private JTextField  lastNameField2;
   private JTextField  analysisField;
   private JTextField  addressField2;
   private JTextField  phoneNumberField2;
   private JTextField  schedulesField;
   private JTextField  commentsField;
   private JTextField  dateHiredField;
   
   
   private JButton updateButton;
   private JButton saveChangesButton;
   private JButton editButton;
   
   private JPanel comboPanel;
   private JList<Employee> employeeList;
   private DefaultListModel<Employee> listModel;
   private JScrollPane allEmployeesScrollPane;


   /**
    * Constructor initializing the GUI components.
    * @param adapter MasterFileAdapter object used for retrieving and storing Employee Information
    */
public AllEmployeesPanel(MasterFileAdapter adapter)
{
   this.adapter = adapter;
   buttonListener = new MyButtonListener();
   listListener = new MyListSelectionListener();
  
   
   inputPanel = new JPanel();
   
   firstNameLabel2 = new JLabel("First name: ");
   firstNameLabel2.setPreferredSize(new Dimension(75, 20));
   firstNameField2 = new JTextField();
   firstNameField2.setEditable(false);
   
   lastNameLabel2 = new JLabel("Last name: ");
   lastNameLabel2.setPreferredSize(new Dimension(75, 20));
   lastNameField2 = new JTextField();
   lastNameField2.setEditable(false);
   
   phoneNumberLabel2 = new JLabel("Phone: ");
   phoneNumberLabel2.setPreferredSize(new Dimension(75, 20));
   phoneNumberField2 = new JTextField();
   phoneNumberField2.setEditable(false);
   
   addressLabel2 = new JLabel("Address: ");
   addressLabel2.setPreferredSize(new Dimension(75, 20));
   addressField2 = new JTextField();
   addressField2.setEditable(false);
   
   schedulesLabel = new JLabel("Schedules: ");
   schedulesLabel.setPreferredSize(new Dimension(70, 20));
   schedulesField = new JTextField();
   schedulesField.setEditable(false);
   
   analysisLabel = new JLabel("Analysis: ");
   analysisLabel.setPreferredSize(new Dimension(70, 20));
   analysisField = new JTextField();
   analysisField.setEditable(false);
   
   commentsLabel = new JLabel("Comments: ");
   commentsLabel.setPreferredSize(new Dimension(70, 20));
   commentsField = new JTextField();
   commentsField.setEditable(false);
   
   dateHiredLabel = new JLabel("Date hired: ");
   dateHiredLabel.setPreferredSize(new Dimension(70, 20));
   dateHiredField = new JTextField();
   dateHiredField.setEditable(false);
   
   editButton = new JButton("Edit");
   editButton.addActionListener(buttonListener);
   
   saveChangesButton = new JButton("Save");
   saveChangesButton.addActionListener(buttonListener);
   
   
   inputPanel.add(firstNameLabel2);
   inputPanel.add(firstNameField2);
   
   inputPanel.add(lastNameLabel2);
   inputPanel.add(lastNameField2);
   
   inputPanel.add(phoneNumberLabel2);
   inputPanel.add(phoneNumberField2);
   
   inputPanel.add(addressLabel2);
   inputPanel.add(addressField2);
   
   inputPanel.add(schedulesLabel);
   inputPanel.add(schedulesField);
   
   inputPanel.add(analysisLabel);
   inputPanel.add(analysisField);
   
   inputPanel.add(commentsLabel);
   inputPanel.add(commentsField);
   
   inputPanel.add(dateHiredLabel);
   inputPanel.add(dateHiredField);
   
   inputPanel.add(editButton);
   inputPanel.add(saveChangesButton);
   
   
   
   add(inputPanel);
   inputPanel.setPreferredSize(new Dimension(280, 340));
   inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
   
   comboPanel = new JPanel();
   
   listModel = new DefaultListModel<Employee>();
   employeeList = new JList<Employee>(listModel);
   employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   employeeList.addListSelectionListener(listListener);
   employeeList.setVisibleRowCount(12);
   
   updateButton = new JButton("Update");
   updateButton.addActionListener(buttonListener);
   
   
   allEmployeesScrollPane = new JScrollPane(employeeList);
   allEmployeesScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
   
   comboPanel.add(allEmployeesScrollPane);
   comboPanel.add(updateButton);
   
   add(comboPanel);
   comboPanel.setPreferredSize(new Dimension(260, 300));
   
}
/**
 * Updates the EmployeeList JList with information from the employee file
 */
public void updateEmployeeList()
{
   int currentIndex = employeeList.getSelectedIndex();
   
   listModel.clear();
   
   EmployeeList employees = adapter.getAllEmployees();
   for(int i = 0; i<employees.sizeEmployeeList(); i++)
   {
      listModel.addElement(employees.getEmployeeAtIndex(i));
   }

   if(currentIndex ==-1 && listModel.size()>0)
   {
      employeeList.setSelectedIndex(0);
   }
   else
   {
      employeeList.setSelectedIndex(currentIndex);
   }
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
      if (e.getSource() == updateButton)
      {
         updateEmployeeList(); 
      }
      if(e.getSource() == editButton)
      {
         firstNameField2.setEditable(true);
         lastNameField2.setEditable(true);
         addressField2.setEditable(true);
         commentsField.setEditable(true);
         phoneNumberField2.setEditable(true);
         analysisField.setEditable(false);
         dateHiredField.setEditable(true);
         schedulesField.setEditable(true);

      }
      if(e.getSource() == saveChangesButton)
      {
         if(employeeList.getSelectedValue() instanceof Employee)
         {
  
         
         String firstName = firstNameField2.getText();
         String lastName = lastNameField2.getText();
         String phoneNumber = phoneNumberField2.getText();
         String address = addressField2.getText();
         String dateHired = dateHiredField.getText();
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
         if(dateHired.equals(""))
         {
            dateHired = "?";
         }
         
         if(comments.equals(""))
         {
            comments = "?";
         }
        
         
         Employee temp1 = (Employee) employeeList.getSelectedValue();
         temp1.getAnalysisForEmployee();

         Employee temp2 = new Employee(firstName, lastName, address, phoneNumber, dateHired, comments);
        
         temp2.setAnalysis(temp1.getAnalysisForEmployee());
      
         adapter.removeEmployee(temp1);
        
         adapter.addEmployee(temp2);
       
         updateEmployeeList();
         
         firstNameField2.setEditable(false);
         lastNameField2.setEditable(false);
         addressField2.setEditable(false);
         commentsField.setEditable(false);
         phoneNumberField2.setEditable(false);
         analysisField.setEditable(false);
         dateHiredField.setEditable(false);
         schedulesField.setEditable(false);
         }
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
      if(e.getSource() == employeeList)
      {
         if(employeeList.getSelectedValue() instanceof Employee)
         {
            Employee temp = (Employee)employeeList.getSelectedValue();
            firstNameField2.setText(temp.getFirstName());
            lastNameField2.setText(temp.getLastName());
            phoneNumberField2.setText(temp.getPhoneNumber());
            addressField2.setText(temp.getAdress());
            analysisField.setText(temp.getAnalysisForEmployee().toString());
            dateHiredField.setText(temp.getDateHired());
            commentsField.setText(temp.getComments());
           
  
         }
      }
         
      }
   }
}   

