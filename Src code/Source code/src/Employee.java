
import java.io.Serializable;
import java.util.ArrayList;
/**
 * A class which holds all information required regarding an Employee
 * @author Sebastien Malmberg
 * @version 1.0
 */
public class Employee implements Serializable
{
   private String firstName;
   private String lastName;
   private String initials;
   private String dateOfBirth;
   private String IDnumber;
   private String address;
   private String phoneNumber;

   private String schedules;
   private ArrayList<Analysis> analysis;

   private String preferences;
   private String comments;

   private String dateHired;

   
  /**
   * A 12 argument constructor, taking all information about an Employee object.
   * @param firstName the employee's fist name
   * @param lastName the employee's last name
   * @param initials taking the employee's initials from firstName and lastName
   * @param dateOfBirth the employee's date of birth
   * @param IDnumber the employee's IDnumber
   * @param adress the employee's address
   * @param phoneNumber the employee's phone number
   * @param schedules the employee's schedules
   * @param analysis the employee's analysis
   * @param preferences the employee´s preferences
   * @param comments comments about the employee
   * @param dateHired the date the employee was hired
   * @param payRate the employee's hourly pay rate
   */

   public Employee(String firstName, String lastName, String initials,
         String dateOfBirth,String IDnumber, String address, String phoneNumber, String schedules,
         Analysis analysis, String preferences, String comments, String dateHired)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.initials = initials;
      this.dateOfBirth = dateOfBirth;
      this.IDnumber = IDnumber;
      this.address = address;
      this.phoneNumber = phoneNumber;
      this.schedules = schedules;
      
      this.preferences = preferences;
      this.comments = comments;
      this.dateHired = dateHired;
     

      initials = "(" + firstName.charAt(0) + "" + lastName.charAt(0) + ")";

   }
   
   
   /**
    * no-argument constructor.
    */
   public Employee()
   {
      analysis = new ArrayList<Analysis>();
   }
   
   /**
    * 3-argument constructor.
    * @param firstName the first name of the employee
    * @param lastName the last name of the employee
    * @param initials the employee's initials
    */
   public Employee(String firstName, String lastName, String initials)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      
      this.initials = "(" + firstName.charAt(0) + "" + lastName.charAt(0) + ")";
      
   }
   /**
    * 6-argument constructor.
    * @param firstName
    * @param lastName
    * @param address
    * @param phoneNumber
    * @param dateHired
    * @param comments
    */
   public Employee(String firstName, String lastName, String address, String phoneNumber, String dateHired, String comments)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.initials = "(" + firstName.charAt(0) + "" + lastName.charAt(0) + ")";
      
      this.address = address;
      this.phoneNumber = phoneNumber;
      this.dateHired = dateHired;
      this.comments = comments;
      
      analysis = new ArrayList<Analysis>();
   }
   
   /**
    * 8-argument constructor, initializing the array list inside it. 
    * @param firstName
    * @param lastName
    * @param initials
    * @param address
    * @param phoneNumber
    * @param dateOfBirth
    * @param dateHired
    * @param comments
    */
   public Employee(String firstName, String lastName, String initials, String address, String phoneNumber, String dateOfBirth, String dateHired, String comments)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.initials = "(" + firstName.charAt(0) + "" + lastName.charAt(0) + ")";
      this.dateOfBirth = dateOfBirth;
      this.address = address;
      this.phoneNumber = phoneNumber;
      this.dateHired = dateHired;
      this.comments = comments;
      
      analysis = new ArrayList<Analysis>();
      
   }
   
   /**
    * Sets the employee's first name.
    * @param firstName the emloyee's first name will be set to
    */
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }
   
   /**
    * Gets the employee's first name
    * @return the employee's first name.
    */
   public String getFirstName()
   {
      return firstName;
   }
   
   /**
    * Sets the employee's last name.
    * @param lastName what the last name of the employee will be set to
    */
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }
   
   /**
    * Gets the last name of the employee.
    * @return lastName the last name of the employee
    */
   public String getLastName()
   {
      return lastName;
   }
   
   /**
    * Gets the Initials of the the employee.
    * @return initials the Initials of the employee.
    */
   public String getInitials()
   {
      return initials;
   }
   
   
   /**
    * Sets the employee's date of birth.
    * @param dateOfBirth what the employee's date of birth will be set to
    */
   public void setDateOfBirth(String dateOfBirth)
   {
      this.dateOfBirth = dateOfBirth;
   }
   
   /**
    * Gets the date of birth of the employee.
    * @return dateOfBirth the date of birth of the employee 
    */
   public String getDateOfBirth()
   {
      return dateOfBirth;
   }
   
   /**
    * Sets the employee's Identification number.
    * @param IDnumber what the employee's  identification number will be set to
    */
   public void setIDnumber(String IDnumber)
   {
      this.IDnumber = IDnumber;
   }
   /**
    * Gets the employee's Identification number.
    * @return IDnumber the employee's identification number
    */
   public String getIDnumber()
   {
      return IDnumber;
   }

   /**
    * Sets the employee's address.
    * @param address what the employee's address will be set to
    */
   public void setAdress(String address)
   {
      this.address = address;
   }

   /**
    * Gets the employee's address.
    * @return address the employees address.
    */
   public String getAdress()
   {
      return address;
   }
   
   /**
    * Sets the phone number of the employee.
    * @param phoneNumber what the phone number of the employee will be set to
    */
   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }
   
   /**
    * Gets an int which represents the phone number of the employee.
    * @return phoneNumber the phone number of the employee
    */
   public String getPhoneNumber()
   {
      return phoneNumber;
   }
   
   /**
    * A method for setting an employee's analysis list ArrayList
    * @param var the new ArrayList to be setted in the employee object
    */
   public void setAnalysis(ArrayList<Analysis> var)
   {
      this.analysis = var;
   }
   
   /**
    * Sets the employee's schedule.
    * @param schedules what the employee's schedule will be set to
    */
   public void setSchedules(String schedules)
   {
      this.schedules = schedules;
   }
   
   /**
    * Gets the employee's schedule
    * @return schedules the employee's schedule
    */
   public String getSchedules()
   {
      return schedules;
   }
   
   /**
    * Adds an analysis to the list.
    * @param analysis the analysis to be added to the list
    */
   public void addAnalysisToEmployee(Analysis analysis)
   {
      this.analysis.add(analysis);
   }
   /**
    * Removes an analysis from the list.
    * @param analysis the analysis to be removed from the list
    */
   public void removeAnalysis(Analysis analysis)
   {
      for (int i = 0; i < this.analysis.size(); i++) {
         if(this.analysis.get(i).equals(analysis))
         {
            this.analysis.remove(i);
            break;
         }
      }
   }
   /**
    * Gets the analysis of the employee.
    * @return analysis the analysis of the employee
    */
   public ArrayList<Analysis> getAnalysisForEmployee()
   {
      return analysis;
   }

   /**
    * Sets the preference of the employee.
    * @param preferences what the employee's preferences will be set to
    */
   public void setPreferences(String preferences)
   {
      this.preferences = preferences;
   }
   /**
    * Gets the employee's preferences
    * @return preferences the employee's preferences
    */
   public String getPreferences()
   {
      return preferences;
   }
   
   /**
    * Sets the employee's comments
    * @param comment what the employee's comments will be set to
    */
   public void setComment(String comment)
   {
      this.comments = comment;
   }

   /**
    * Gets an employee's comments.
    * @return comments the employee's comments
    */
   public String getComments()
   {
      return comments;
   }

   /**
    * Sets what date the employee was hired.
    * @param dateHired what the date the employee was hired will be set to
    */
   public void setDateHired(String dateHired)
   {
      this.dateHired = dateHired;
   }

   /**
    * Gets the date the employee's was hired.
    * @return dateHired the date the employee was hired
    */
   public String getDateHired()
   {
      return dateHired;
   }
   
   /**
    * A method for checking if an employee has an analysis
    * @param ana The analysis that you're looking for inside the Employee object
    * @return True if the employee object has the referenced analysis, false otherwise.
    */
   public boolean hasAnalysis (Analysis ana) {
	   
	   for(Analysis i : analysis) {
		   if(i.equals(ana))
			   return true;
	   }
	   
	   return false;
   }

   /**
    * Compares the IDnumber of an Employee object with obj.
    * @param obj the object to compare with
    * @return true if the given object is equal to this employee's IDnumber
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Employee))
      {
         return false;
      }

      Employee other = (Employee) obj;

      return firstName.equals(other.firstName) && lastName.equals(other.lastName);

   }
   
   /**
    * Return a String containing all information of the Employee.
    * @return a String representation of the Employee
    */
   public String toString()
   {
      return firstName + " " + lastName + " " + initials + "\n";
             
   }
   

}
