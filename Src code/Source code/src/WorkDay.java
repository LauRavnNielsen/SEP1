import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing the workday for a schedule
 * 
 * @author Denis-Alexandru Turcu
 * @version 1.0
 */
public class WorkDay implements Serializable {

	private int numOfTasks;
	private ArrayList<Task> tasks;
	private String date;

	/**
	 * The main constructor of the function
	 * 
	 * @param numOfTasks The number of tasks in that workday;
	 */
	public WorkDay(String date) {

		this.numOfTasks = 99;
		tasks = new ArrayList<Task>();
		this.date = date;

	}

	/**
	 * Add a task to a work day
	 * 
	 * @param var the task to be added
	 */
	public void add(Task var) {
		if (tasks.size() < numOfTasks) {
			tasks.add(var);
		}
	}

	/**
	 * This method removes a task from the task list
	 * 
	 * @param var The task to be removed from the task list
	 */
	public void remove(Task var) {
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getAnalysis().equals(var.getAnalysis())) {
				tasks.remove(i);
			}
		}
	}

	/**
	 * A method for getting a task by its analysis
	 * 
	 * @param analysis the analysis by which we make the search
	 * @return Returns the task which has the referred analysis
	 */
	public Task getTask(String analysis) {
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getAnalysis().toString().equals(analysis))
				return tasks.get(i);
		}
		return null;
	}

	/**
	 * A method for setting the date of the WorkDay
	 * 
	 * @param date the new Date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * A method for getting the date from a WorkDay
	 * 
	 * @return the date of the WorkDay
	 */
	public String getDate() {
		return date;
	}

	/**
	 * A method for returning the total number of Tasks in a WorkDay
	 * 
	 * @return the number of tasks in a WorkDay
	 */
	public int getNumberOfTasks() {
		return tasks.size();
	}

	/**
	 * A method for getting the ArrayList object from inside the WorkDay
	 * 
	 * @return the ArrayList contained in the WorkDay
	 */
	public ArrayList<Task> getTaskList() {
		return tasks;
	}

	/**
	 * The toString method of the WorkDay class
	 */
	public String toString() {

		String output = "";

		for (Task i : tasks) {
			output += i.toString() + "\n \n";
		}

		return output;
	}

}
