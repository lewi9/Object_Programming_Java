package School;

public class SchoolGirl extends Pupil
{
    private final static String defName = "Anna";
    private final static String defLastName = "Nowak";
    private final static int defAge = 18;
    private final static String defClassa = "1a";

    SchoolGirl()
    {
        super( defName, defLastName, defAge, defClassa );
        setID( "F_" + getID() );
    }
    SchoolGirl( String Name, String LastName, int  Age, String Classa)
    {
        super( Name, LastName, Age, Classa );
        setID( "F_" + getID() );

    }
    public void printOutfit()
    {
        System.out.println( "Ubranie dziewczynki: biala bluzka z krawatem (opcjonalnie dodatkowo granatowy lub czarny sweterek, granatowa( lub czarna ) spodniczka, plaskie obuwie");
    }
}
