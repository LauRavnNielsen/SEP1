import java.util.ArrayList;

/**
 * A class containing a list of analysis objects.
 * 
 * @author Tamás Fekete
 * @version 1.0
 */
public class AnalysisList {
	private ArrayList<Analysis> analysis;

	/**
	 * No-argument constructor initializing the analysis list
	 */
	public AnalysisList() {
		analysis = new ArrayList<Analysis>();
	}

	/**
	 * Adds an analysis to the list
	 * 
	 * @param analy the name of analysis to add to the list
	 */
	public void add(Analysis analy) {
		analysis.add(analy);
	}

	/**
	 * Removes an analysis from the list
	 * 
	 * @param analy the name of analysis to remove from the list
	 */
	public void removeAnalysis(Analysis analy) {
		for (int i = 0; i < analysis.size(); i++) {
			if (analysis.get(i).copy().equals(analy)) {
				analysis.remove(i);
				break;
			}
		}
	}

	/**
	 * gets an analysis from position index from the list
	 * 
	 * @param index the position in the list of the analysis object
	 * @return the analysis object at position index if one exists, else null
	 */
	public Analysis get(int index) {
		if (index < analysis.size()) {
			return analysis.get(index);
		} else {
			return null;
		}
	}

	/**
	 * Gets the index of a analysis object with the given name
	 * 
	 * @param name the name of the analysis object
	 * @return the index of the analysis object with the given name
	 */
	public int getIndex(String name) {
		for (int i = 0; i < analysis.size(); i++) {
			Analysis temp = analysis.get(i).copy();

			if (temp.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Gets a string representation of the AnalysisList.
	 * 
	 * @return a string containing information about all analysis object in the
	 *         list, every Analysis object followed by a new line
	 */
	public String toString() {
		String scr = "";

		for (int i = 0; i < analysis.size(); i++) {
			Analysis temp = analysis.get(i).copy();
			scr += temp + "\n";
		}
		return scr;
	}
}
