/**
 * A class which contains a static method for easy call of analysis.
 * 
 * @author Denis-Alexandru Turcu
 * @version 1.0
 */
public class ana {

	/**
	 * This method returns the Analysis object corresponding to the name (
	 * Predefined list).
	 * 
	 * @param analysis The name of the analysis
	 * @return Returns the referenced analysis object.
	 */
	public static Analysis get(String analysis) {

		Analysis A = new Analysis("Fiber");
		Analysis B = new Analysis("Sugar");
		Analysis C = new Analysis("Protein");
		Analysis D = new Analysis("Fat");
		Analysis E = new Analysis("Starch");
		Analysis F = new Analysis("Enzymes");
		Analysis G = new Analysis("Milk");
		Analysis H = new Analysis("Pig");
		Analysis I = new Analysis("Cattle");

		AnalysisList list = new AnalysisList();

		list.add(A);
		list.add(B);
		list.add(C);
		list.add(D);
		list.add(E);
		list.add(F);
		list.add(G);
		list.add(H);
		list.add(I);

		return list.get(list.getIndex(analysis));

	}

}
