import java.io.Serializable;

/**
 * This Class represents the task for a specific day(usually in a task list)
 * @author Denis-Alexandru Turcu
 * @version 1.0
 */
public class Task implements Serializable{

	private Analysis analysis;
	private int reqEmployee;
	private int aux;
	private EmployeeList list;
	
	/**
	 * The main constructor of the class
	 * @param ana the analysis of the task
	 * @param reqEmployee the required number of employees
	 */
	public Task(Analysis ana, int reqEmployee) {
		analysis = ana;
		this.reqEmployee = reqEmployee;
		aux = reqEmployee;
		list = new EmployeeList();
		
	}
	
	/**
	 * This method assigns an employee to this task
	 * @param var The employee that needs to be assigned to the task
	 */
	public void AssignEmployee(Employee var) {
		if(reqEmployee != 0 ) {
		list.addEmployee(var);
		reqEmployee--;}
	}
	
	/**
	 * A method for removing an employee from a task
	 * @param var The employee to be removed
	 */
	public void removeEmployee(Employee var) {
		list.removeEmployee(var);
	}
	
	/**
	 * A method for getting the required employee number
	 * @return the required employee number
	 */
	public int getReqEmployee() {
		return reqEmployee;
	}
	
	/**
	 * A method for getting the Analysis
	 * @return The task analysis
	 */
	public Analysis getAnalysis() {
		return analysis;
	}
	
	/**
	 * A method for setting the required employee number
	 * @param reqEmployee the number of required employees
	 */
	public void setreqEmployee(int reqEmployee) {
		this.reqEmployee = reqEmployee;
	}
	
	/**
	 * A method for setting the analysis of the task
	 * @param var the new analysis
	 */
	public void setAnalysis(Analysis var) {
		analysis = var;
	}
	
	/**
	 * A method for setting the employee list
	 * @param var The new employee list
	 */
	public void setList(EmployeeList var) {
		list = var;
	}
	
	/**
	 * A method for getting a copy of the task at hand
	 * @return An exact copy of the current task
	 */
	public Task copy() {
		Task temp = new Task(analysis,reqEmployee);
		temp.setList(list);
		
		return temp;
	     
	}
	
	
	/**
	 * A function for unassigning all employees from a schedule
	 */
	public void unAssignAll() {
		list = new EmployeeList();
		reqEmployee=aux;
	}
	
	
	/**
	 * A standard equals method to check if two tasks are the same
	 */
	public boolean equals (Object obj) {
		
		if(!(obj instanceof Task))
		  return false;
		
		Task other = (Task) obj;
		
		return other.analysis.equals(analysis) &&
				other.reqEmployee == reqEmployee &&
				other.list.equals(list);
	}
	
	/**
	 * The toString method of the Task class
	 */
	public String toString() {
		if(reqEmployee == 0) {
			return list.toString();
		}
		else
			return list.toString() + " -" + reqEmployee;
			
	} 
		
		
	
	
	
	
}
