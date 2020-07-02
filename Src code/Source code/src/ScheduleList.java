import java.io.Serializable;
import java.util.ArrayList;
/**
 * The schedule list class where we store all our schedules
 * @author Denis-Alexandru Turcu
 * @version 1.0
 */
public class ScheduleList implements Serializable{

	private ArrayList<Schedule> schedules;
	
	/**
	 * The main constructor of the schedule list
	 */
	public ScheduleList () {
		schedules = new ArrayList<Schedule>();
	}
	
	/**
	 * This method adds a schedule inside a schedule list
	 * @param var The schedule you wish to add to your list
	 */
	public void add(Schedule var) {
		schedules.add(var);
	}
	/**
	 * A method for returning all the schedules in an ArrayList
	 * @return returns all the schedules in an ArrayList
	 */
	public ArrayList<Schedule> getAllSchedules(){
		return schedules;
	}
	
	/**
	 * A method for returning all the schedules 
	 * @param index the index in the ArrayList we wish to return
	 * @return returns the schedule referenced in the ArrayList
	 */
	public Schedule get(int index) {
		return schedules.get(index);
	}
	
	/**
	 * A method for getting a schedule from the schedule list by it's name
	 * @param name The name of the schedule
	 * @return The schedule that matches with that name;
	 */
	public Schedule getScheduleByName(String name) {
		
		for(Schedule i : schedules) {
			if(i.toString().equals(name))
				return i;
		}
		return null;
		
	}
}
