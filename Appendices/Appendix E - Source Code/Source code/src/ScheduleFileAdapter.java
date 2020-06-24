import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * This is the main adapter for storing the data of our new Schedules
 * @author Denis-Alexandru Turcu
 * @version 1.0
 */
public class ScheduleFileAdapter {

	   private MyFileIO mfio;
	   private String fileName;
	   
	   /**
	    * This is the main constructor of the ScheduleFileAdapter
	    * @param filename the name of the file that needs to be created or to which we need to append to.
	    */
	   public ScheduleFileAdapter(String filename) {
		   this.fileName = filename;
		   mfio = new MyFileIO();
	   }
	   
	   
	   /**
	    * This method returns the schedule list from the binary file.
	    * @return The schedule list object
	    */
	   public ScheduleList getAllSchedules()
	   {
	      ScheduleList schedules = new ScheduleList();

	      try
	      {
	         schedules = (ScheduleList)mfio.readObjectFromFile(fileName);
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
	      catch (ClassNotFoundException e)
	      {
	         System.out.println("Class Not Found");
	      }
	      return schedules;
	   }
	   
	   /**
	    * This method saves the schedule list to our binary file
	    * @param schedules the ScheduleList object we wish to save to the binary file
	    */
	   public void saveSchedules(ScheduleList schedules)
	   {
	      try
	      {
	         mfio.writeToFile(fileName, schedules);
	      }
	      catch (FileNotFoundException e)
	      {
	         System.out.println("File not found");
	      }
	      catch (IOException e)
	      {
	         System.out.println("IO Error writing to file");
	         e.printStackTrace();
	      }
	   }
}
