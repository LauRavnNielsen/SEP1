import java.io.Serializable;

/**
 * A class representing an analysis with a name.
 * 
 * @author Tamás Fekete
 * @version 1.0
 */
public class Analysis implements Serializable{

	private String name;

	/**
	 * One-argument constructor.
	 * 
	 * @param name the analysis name
	 */

	public Analysis(String name) {
		this.name = name;
	}

	/**
	 * Sets the analysis name.
	 * 
	 * @param name what the analysis name will be set to
	 */
	public void setAnalysis(String name) {
		this.name = name;
	}

	/**
	 * Gets the analysis name.
	 * 
	 * @return the analysis name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Create a copy of the analysis.
	 * 
	 * @return new Analysis object with same parameters
	 */
	public Analysis copy() {
		return new Analysis(name);
	}

	/**
	 * Return a string representation of the analysis.
	 * 
	 * @return a string representation of the analysis
	 */
	public String toString() {
		return "" + name;
	}

	/**
	 * compares name of two analysis
	 * 
	 * @param obj the object to compare with
	 * @return true if the given object is equal to this analysis
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Analysis))
			return false;

		Analysis temp = (Analysis) obj;
		return name.equals(temp.name);
	}

}
