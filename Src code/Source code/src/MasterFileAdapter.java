
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;


/**
 * An adapter to the employee file, making it easy to retrieve and store information.
 * @author Sebastien Malmberg
 * @version 1.0
 */
public class MasterFileAdapter implements Serializable
{
   private MyFileIO mfio;
   private String fileName;
   
   /**
    * 1-argument constructor setting the file name.
    * @param fileName the name and path of the file where employees will be saved and retrieved
    */
   public  MasterFileAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }
   /**
    * Uses the MyFileIO class to add an Employee to the list.
    * @param employee the employee to be added to the list
    */
   public void addEmployee(Employee employee)
   {
      
      EmployeeList employees = getAllEmployees();
      employees.addEmployee(employee);
      try
      {
         mfio.writeToFile(fileName, employees);
      }
      catch(FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch(IOException e)
      {
         
         System.out.println("IO ERROR reading file");
         
      }
   }
   
   /**
    * Uses the MyFileIO class to retrieve an EmployeeList object with all Employees.
    * @return an EmployeeList object with all stored employees.
    */
   public EmployeeList getAllEmployees()
   {
      
      EmployeeList employees = new EmployeeList();
      
      try
      {
         employees = (EmployeeList)mfio.readObjectFromFile(fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
         e.printStackTrace();
         
      }
      catch(ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return employees;
   }
   
   /**
    * Use the MyFileIO class to retrieve all students from a given analysis.
    * @param analysis the analysis to retrieve employees from
    * @return a EmployeeList object with employees from the given analysis
    */
   public EmployeeList getEmployeesWithAnalysis(Analysis analysis)
   {
      EmployeeList employees = new EmployeeList();
      
      try
      {
         EmployeeList result = (EmployeeList)mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.sizeEmployeeList(); i++)
         {
            if(result.getEmployeeAtIndex(i).getAnalysisForEmployee().toString().equals(analysis.toString()))
            {
               employees.addEmployee(result.getEmployeeAtIndex(i));
            }
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      
      return employees;
   }
   /**
    * Use the MyFileIO class to same some employees.
    * @param employees the list of employees that will be saved
    */
   public void saveEmployees(EmployeeList employees)
   {
      try
      {
         mfio.writeToFile(fileName, employees);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         e.printStackTrace();
         System.out.println("IO Error writing to file");
      }
      
   }
   /**
    * Uses the MyFileIO class to change the country of a student with
    * the given first name and last name.
    * @param firstName the first name of the employee
    * @param lastName the last name of the employee
    * @param analysis the employees new analysis
    */
   /*public void changeEmployeeAnalysis(String firstName, String lastName, Analysis analysis)
   {
      EmployeeList employees = getAllEmployees();
      
      for (int i = 0; i < employees.sizeEmployeeList(); i++)
      {
         Employee employee = employees.getEmployeeAtIndex(i);
         
         if(employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName))
         {
            employee.setAnalysis(analysis);
         }
         
      }
      
      saveEmployees(employees);
   }*/
   
   
   /**
    * Uses the MyFileIO to remove and employee from the Employee list.
    * @param employee the employee that will be removed
    */
   public void removeEmployee(Employee employee)
   {
      EmployeeList employees = getAllEmployees();
      EmployeeList temp = new EmployeeList();
      
      for (int i = 0; i < employees.sizeEmployeeList(); i++)
      {
         if(!(employees.getEmployeeAtIndex(i).equals(employee)))
         {
            temp.addEmployee(employees.getEmployeeAtIndex(i));
         }
      }
      try
      {
         mfio.writeToFile(fileName, temp);
      }
      catch(FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch(IOException e)
      {
         System.out.println("IO ERROR reading file");
      }
   }
   /**
    * Adding Employees to the list.
    * @param employeelist the list of employees to add
    */
   public void addEmployees(EmployeeList employeelist)
   {
      EmployeeList employees = getAllEmployees();
      for (int i = 0; i < employees.sizeEmployeeList(); i++)
      {
         employeelist.addEmployee(employees.getEmployeeAtIndex(i));
      }
   }
   
   
   

}
