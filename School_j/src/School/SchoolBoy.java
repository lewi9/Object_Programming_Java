package School;

public class SchoolBoy extends Pupil
{
    private final static String defName = "Jan";
    private final static String defLastName = "Nowak";
    private final static int defAge = 18;
    private final static String defClassa = "1a";

    SchoolBoy()
    {
        super( defName, defLastName, defAge, defClassa );
        setID( "M_" + getID() );
    }
    SchoolBoy( String Name, String LastName, int  Age, String Classa)
    {
        super( Name, LastName, Age, Classa );
        setID( "M_" + getID() );
    }
    public void printOutfit()
    {
        System.out.println( "Ubranie chlopca: biala lub niebieska koszula z krawatem, marynarka, polbuty, spodnie dowolne czarne lub granatowe. ");

    }
}
