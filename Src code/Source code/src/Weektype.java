/**
 * A class for storing data about a week type (L,S or all)
 * @author Denis-Alexandru Turcu
 * @version 1.0
 */
public class Weektype {

    private String type;

    public static Weektype l = new Weektype("L");
    public static Weektype s = new Weektype("S");
    public static Weektype all = new Weektype("All");

    /**
     * The main constructor of the WeekType class
     * @param type The type of the week(either L,S or all)
     */
    public Weektype(String type)
    {
        this.type=type;
    }
    
    /**
     * The main toString method of the WeekType class
     */
    public String toString()
    {
        return type;
    }

}
