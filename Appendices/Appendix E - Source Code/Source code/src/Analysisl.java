/**
 * A basic class for storing the default analysis 
 * @author Denis-Alexandru Turcu
 *
 */
public class Analysisl {
private String type;

public static Analysisl fiber = new Analysisl("Fiber");
public static Analysisl sugar = new Analysisl("Sugar");
public static Analysisl protein = new Analysisl("Protein");
public static Analysisl fat = new Analysisl("Fat");
public static Analysisl stratch = new Analysisl("Starch");
public static Analysisl enzymes = new Analysisl("Enzymes");
public static Analysisl milk = new Analysisl("Milk");
public static Analysisl pig = new Analysisl("Pig");
public static Analysisl cattle = new Analysisl("Cattle");
/**
 * The main constructor of the Analysisl class
 * @param type the predefined type of the analysis (Eg:"Protein")
 */
public Analysisl(String type)
{
	this.type=type;
}

/**
 * The toString method of the class
 */
public String toString()
{
	return type;
}
}
