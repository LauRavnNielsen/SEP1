import java.io.Serializable;

/**
 * The schedule class which hold major information about the company and the
 * employees.Here is where the employees get assigned to their task.
 * 
 * @author Denis-Alexandru Turcu
 * @version 1.0
 */
public class Schedule implements Serializable {

	private String name;
	private String dateInterval;
	private WorkDay Monday;
	private WorkDay Tuesday;
	private WorkDay Wednesday;
	private WorkDay Thursday;
	private WorkDay Friday;
	private WorkDay Saturday;
	private String type;
	private String comment;

	/**
	 * A no argument constructor
	 */
	public Schedule() {
		name = null;
		dateInterval = null;
		Monday = null;
		Tuesday = null;
		Wednesday = null;
		Thursday = null;
		Friday = null;
		Saturday = null;
		type = null;
		comment = null;
	}

	/**
	 * The main constructor of the schedule object
	 * 
	 * @param name         The name of the schedule
	 * @param dateInterval The date which will help generate the 6 day interval
	 * @param type         The type of schedule (L or S)
	 * @param comment      A comment for the schedule
	 */
	public Schedule(String name, String dateInterval, String type, String comment) {

		this.dateInterval = dateInterval;
		this.type = type;
		this.name = name;

		this.comment = comment;
		Monday = new WorkDay(dateInterval);

		Tuesday = new WorkDay(dateInterval);

		Wednesday = new WorkDay(dateInterval);

		Thursday = new WorkDay(dateInterval);

		Friday = new WorkDay(dateInterval);

		Saturday = new WorkDay(dateInterval);

		if (type.equals("L")) {
			Task m1 = new Task(ana.get("Fat"), 2);
			Task m2 = new Task(ana.get("Protein"), 2);
			Task m3 = new Task(ana.get("Fiber"), 1);
			Task m4 = new Task(ana.get("Sugar"), 1);

			Monday.add(m1);
			Monday.add(m2);
			Monday.add(m3);
			Monday.add(m4);

			Task tu1 = new Task(ana.get("Fat"), 2);
			Task tu2 = new Task(ana.get("Protein"), 2);
			Task tu3 = new Task(ana.get("Fiber"), 1);
			Task tu4 = new Task(ana.get("Sugar"), 1);

			Tuesday.add(tu1);
			Tuesday.add(tu2);
			Tuesday.add(tu3);
			Tuesday.add(tu4);

			Task w1 = new Task(ana.get("Fat"), 2);
			Task w2 = new Task(ana.get("Protein"), 2);
			Task w3 = new Task(ana.get("Fiber"), 1);
			Task w4 = new Task(ana.get("Sugar"), 1);

			Wednesday.add(w1);
			Wednesday.add(w2);
			Wednesday.add(w3);
			Wednesday.add(w4);

			Task th1 = new Task(ana.get("Fat"), 2);
			Task th2 = new Task(ana.get("Protein"), 2);
			Task th3 = new Task(ana.get("Fiber"), 1);
			Task th4 = new Task(ana.get("Sugar"), 1);

			Thursday.add(th1);
			Thursday.add(th2);
			Thursday.add(th3);
			Thursday.add(th4);

			Task f1 = new Task(ana.get("Fat"), 2);
			Task f2 = new Task(ana.get("Protein"), 2);
			Task f3 = new Task(ana.get("Fiber"), 1);
			Task f4 = new Task(ana.get("Sugar"), 1);

			Friday.add(f1);
			Friday.add(f2);
			Friday.add(f3);
			Friday.add(f4);

			Task s1 = new Task(ana.get("Fat"), 1);
			Task s2 = new Task(ana.get("Protein"), 1);
			Task s3 = new Task(ana.get("Fiber"), 1);
			Task s4 = new Task(ana.get("Sugar"), 1);

			Saturday.add(s1);
			Saturday.add(s2);
			Saturday.add(s3);
			Saturday.add(s4);

		} else if (type.equals("S")) {
			Task m1 = new Task(ana.get("Fat"), 3);
			Task m2 = new Task(ana.get("Protein"), 2);
			Task m3 = new Task(ana.get("Fiber"), 1);
			Task m4 = new Task(ana.get("Sugar"), 1);

			Monday.add(m1);
			Monday.add(m2);
			Monday.add(m3);
			Monday.add(m4);

			Task tu1 = new Task(ana.get("Fat"), 3);
			Task tu2 = new Task(ana.get("Protein"), 2);
			Task tu3 = new Task(ana.get("Fiber"), 1);
			Task tu4 = new Task(ana.get("Sugar"), 1);

			Tuesday.add(tu1);
			Tuesday.add(tu2);
			Tuesday.add(tu3);
			Tuesday.add(tu4);

			Task w1 = new Task(ana.get("Fat"), 3);
			Task w2 = new Task(ana.get("Protein"), 2);
			Task w3 = new Task(ana.get("Fiber"), 1);
			Task w4 = new Task(ana.get("Sugar"), 1);

			Wednesday.add(w1);
			Wednesday.add(w2);
			Wednesday.add(w3);
			Wednesday.add(w4);

			Task th1 = new Task(ana.get("Fat"), 2);
			Task th2 = new Task(ana.get("Protein"), 2);
			Task th3 = new Task(ana.get("Fiber"), 1);
			Task th4 = new Task(ana.get("Sugar"), 1);

			Thursday.add(th1);
			Thursday.add(th2);
			Thursday.add(th3);
			Thursday.add(th4);

			Task f1 = new Task(ana.get("Fat"), 2);
			Task f2 = new Task(ana.get("Protein"), 2);
			Task f3 = new Task(ana.get("Fiber"), 1);
			Task f4 = new Task(ana.get("Sugar"), 1);

			Friday.add(f1);
			Friday.add(f2);
			Friday.add(f3);
			Friday.add(f4);

			Task s1 = new Task(ana.get("Fat"), 1);
			Task s2 = new Task(ana.get("Protein"), 1);
			Task s3 = new Task(ana.get("Fiber"), 1);
			Task s4 = new Task(ana.get("Sugar"), 1);

			Saturday.add(s1);
			Saturday.add(s2);
			Saturday.add(s3);
			Saturday.add(s4);

		}

	}

	/**
	 * A method for getting the date of the Schedule in the form of a String
	 * 
	 * @return The date of the schedule
	 */
	public String getDate() {
		return dateInterval;
	}

	/**
	 * A method for adding a task on the "Monday" WorkDay.
	 * 
	 * @param analysis    The analysis of the new task.
	 * @param reqEmployee The required number of employees for that task
	 */
	public void addTaskMonday(String analysis, int reqEmployee) {
		Task temp = new Task(ana.get(analysis), reqEmployee);
		Monday.add(temp);
	}

	/**
	 * A method for adding a task on the "Tuesday" WorkDay.
	 * 
	 * @param analysis    The analysis of the new task.
	 * @param reqEmployee The required number of employees for that task
	 */
	public void addTaskTuesday(String analysis, int reqEmployee) {
		Task temp = new Task(ana.get(analysis), reqEmployee);
		Tuesday.add(temp);
	}

	/**
	 * A method for adding a task on the "Wednesday" WorkDay.
	 * 
	 * @param analysis    The analysis of the new task.
	 * @param reqEmployee The required number of employees for that task
	 */
	public void addTaskWednesday(String analysis, int reqEmployee) {
		Task temp = new Task(ana.get(analysis), reqEmployee);
		Wednesday.add(temp);
	}

	/**
	 * A method for adding a task on the "Thursday" WorkDay.
	 * 
	 * @param analysis    The analysis of the new task.
	 * @param reqEmployee The required number of employees for that task
	 */
	public void addTaskThursday(String analysis, int reqEmployee) {
		Task temp = new Task(ana.get(analysis), reqEmployee);
		Thursday.add(temp);
	}

	/**
	 * A method for adding a task on the "Friday" WorkDay.
	 * 
	 * @param analysis    The analysis of the new task.
	 * @param reqEmployee The required number of employees for that task
	 */
	public void addTaskFriday(String analysis, int reqEmployee) {
		Task temp = new Task(ana.get(analysis), reqEmployee);
		Friday.add(temp);
	}

	/**
	 * A method for adding a task on the "Saturday" WorkDay.
	 * 
	 * @param analysis    The analysis of the new task.
	 * @param reqEmployee The required number of employees for that task
	 */
	public void addTaskSaturday(String analysis, int reqEmployee) {
		Task temp = new Task(ana.get(analysis), reqEmployee);
		Saturday.add(temp);
	}

	/**
	 * A method for returning the "Monday" WorkDay
	 * 
	 * @return the Monday WorkDay of that specific schedule
	 */
	public WorkDay getMonday() {
		return Monday;
	}

	/**
	 * A method for returning the "Tuesday" WorkDay
	 * 
	 * @return the Monday WorkDay of that specific schedule
	 */
	public WorkDay getTuesday() {
		return Tuesday;
	}

	/**
	 * A method for returning the "Wednesday" WorkDay
	 * 
	 * @return the Monday WorkDay of that specific schedule
	 */
	public WorkDay getWednesday() {
		return Wednesday;
	}

	/**
	 * A method for returning the "Thursday" WorkDay
	 * 
	 * @return the Monday WorkDay of that specific schedule
	 */
	public WorkDay getThursday() {
		return Thursday;
	}

	/**
	 * A method for returning the "Friday" WorkDay
	 * 
	 * @return the Monday WorkDay of that specific schedule
	 */
	public WorkDay getFriday() {
		return Friday;
	}

	/**
	 * A method for returning the "Saturday" WorkDay
	 * 
	 * @return the Monday WorkDay of that specific schedule
	 */
	public WorkDay getSaturday() {
		return Saturday;
	}

	/**
	 * A method for returning the comment of the Schedule in the form of a String
	 * 
	 * @return The comment added to that specific Schedule
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * A method for returning the Schedule type (L or S)
	 * 
	 * @return The type of the Schedule
	 */
	public String getType() {
		return type;
	}

	/**
	 * A method for returning a short string of text containing the schedule comment
	 * and schedule type
	 * 
	 * @return a text containing the schedule comment and type
	 */
	public String getAbout() {
		return String.format("Week type : %s \n Comment : %s \n", type, comment);
	}

	/**
	 * The toString method of the Schedule object
	 */
	public String toString() {
		return name;
	}

}
