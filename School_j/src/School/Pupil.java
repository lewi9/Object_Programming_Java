package School;



abstract public class Pupil extends Person
{
    public enum Subject {
        POLSKI,
        MATEMATYKA,
        FIZYKA,
        CHEMIA,
        INFORMATYKA,
        ANGIELSKI,
        NIEMIECKI
    }

    private final static String defName = "Name";
    private final static String defLastName = "Nowak";
    private final static int defAge = 18;
    private final static String defClassa = "1a";
    static int ID = 1000;

    Pupil()
    {
        this( defName, defLastName, defAge, defClassa );
    }
    Pupil( String Name, String LastName, int Age, String Classa )
    {
        super( Name, LastName, Age );
        setClassa( Classa );
        setID(String.valueOf(ID));
        ID++;
    }

    public String getID() {
        return mID;
    }

    public String getClassa() {
        return mClassa;
    }

    public double getMark( Subject index ) {
        switch ( index ) {
            case POLSKI: return this.mMarks[0];
            case MATEMATYKA: return this.mMarks[1];
            case FIZYKA:  return this.mMarks[2];
            case CHEMIA:  return this.mMarks[3];
            case INFORMATYKA:  return this.mMarks[4];
            case ANGIELSKI:  return this.mMarks[5];
            case NIEMIECKI:  return this.mMarks[6];
            default: System.out.println("Podano zly przedmiot"); return 0;
        }
    }

    public void setID( String ID ) {
        this.mID = (ID.length() <= 4) ? "0" + ID : ID;
    }

    public void setClassa( String Classa ) {
        this.mClassa = Classa;
    }

    public void addMark( double mark, Subject index ) {
        if (mark == 2.0 || mark == 3.0 || mark == 3.5 || mark == 4.0
                || mark == 4.5 || mark == 5.0|| mark == 0)
        {
            switch ( index )
            {
                case POLSKI: this.mMarks[0] = mark; break;
                case MATEMATYKA: this.mMarks[1] = mark; break;
                case FIZYKA: this.mMarks[2] = mark; break;
                case CHEMIA: this.mMarks[3] = mark; break;
                case INFORMATYKA: this.mMarks[4] = mark; break;
                case ANGIELSKI: this.mMarks[5] = mark; break;
                case NIEMIECKI: this.mMarks[6] = mark; break;
                default: System.out.println("Podano zly przedmiot");
            }
        }
    }

    public void clearMarks()
    {
        for( int i=0; i<7; i++ )
            this.mMarks[i] = 0;
    }

    public double avgMark()
    {
        int count = 0;
        double avg = 0;
        for( int i=0; i<7; i++ )
        {
            double t = this.mMarks[i];
            if( t != 0 )
            {
                count++;
                avg += t;
            }
        }
        return avg/count;
    }

    public String toString()
    {
        printOutfit();
        return "ID: " + getID() + ", Name: " + getName() + ", Lastname: " + getLastName() +
                ", Avg mark: " + avgMark() + ", Class: "+ getClassa() + ", Age: " + getAge();
    }
    abstract void printOutfit();

    protected String mID;
    private String mClassa;
    private final double[] mMarks = { 0,0,0,0,0,0,0 };

}
