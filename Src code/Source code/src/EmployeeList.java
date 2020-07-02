

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Employee objects.
 * 
 * @author Sebastien Malmberg
 * @version 1.0
 */
public class EmployeeList implements Serializable
{
   private ArrayList<Employee> employees;

   /**
    * No-argument constructor initializing the EmployeeList.
    */

   public EmployeeList()
   {
      employees = new ArrayList<Employee>();
   }

   /**
    * Adds an employee to the list.
    * @param employee the employee to add to the list
    */
   public void addEmployee(Employee employee)
   {
      employees.add(employee);
   }
   
   /**
    * Removes an employee from the list.
    * @param employee the employe to be removed from the list
    */
   public void removeEmployee(Employee employee)
   {
      employees.remove(employee);
   }
   
   /**
    * Replaces the Employee object at index with employee.
    * @param employee the employee which will replace
    * @param index the position in the list that will be replaced
    */
   public void setEmployeeAtIndex(Employee employee, int index)
   {
      employees.set(index, employee);
   }
   
   /**
    * Gets an Employee object from position index from the list. 
    * @param index the position in the list of the Employee object
    * @return the Employee at index if one exists, else null
    */
   public Employee getEmployeeAtIndex(int index)
   {
      if (index < employees.size())
      {
         return employees.get(index);
      }
      else
      {
         return null;
      }

   }
   /**
    * Gets an Employee object from the EmployeeList which has the name, firstName LastName.
    * @param firstName the first name of the Employee object
    * @param lastName the last name of the Employee object
    * @return the Employee with first name: firstName and last name: lastName, else null
    */
   public Employee getEmployeeByName(String firstName, String lastName)
   {
      for (int i = 0; i < employees.size(); i++)
      {
         Employee temp = employees.get(i);
         
         if(temp.getFirstName().equals(firstName) && temp.getLastName().equals(lastName))
         {
            return temp;
         }
      }
      return null;
   }
   /**
    * Gets the total amount of Employee objects inside the list.
    * @return the size of the Employee list
    */
   public int sizeEmployeeList()
   {
     return employees.size();
   }
   
   
   /**
    * A method for getting an ArrayList with all the employees that have a specific analysis
    * @param analysis The analysis that you are searching for
    * @return 
    */
   public ArrayList<Employee> getEmployeesWithAnalysis(String analysis) {
	   
	   ArrayList<Employee> temp = new ArrayList<Employee>();
	   
	    
	   for(Employee i : employees) {
		   if(i.hasAnalysis(ana.get(analysis))) {
			   temp.add(i);
		   }
	   }
	   
	   return temp;
	   
   }


   
   /**
    * Gets the list of Employees.
    * @return employees the list of employees
    */
   public ArrayList<Employee> getEmployeeList()
   {
      return employees;
   }
   
   /**
    * Gets a string representation of the EmployeeList.
    * @return a String containing information about every Employee object in the list
    */
   
   
/**
 * The toString class of the EmployeeList object
 */
   public String toString()
   {
      String returnStr = "";
      
      for (int i = 0; i < employees.size(); i++)
      {
         Employee temp = employees.get(i);
         
         returnStr += temp.getInitials() + "\n";
      }
      return returnStr;
   }

   
   
  
  

}
