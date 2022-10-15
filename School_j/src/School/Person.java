package School;

public class Person {
    private final static String defName = "Name";
    private final static String defLastName = "Nowak";
    private final static int defAge = 18;

    Person()
    {
        this( defName, defLastName, defAge );
    }
    Person( String name, String lastName, int age )
    {
        setPerson( name, lastName, age );
    }

    public String getName()
    {
        return mName;
    }

    public String getLastName()
    {
        return mLastName;
    }

    public int getAge()
    {
        return mAge;
    }

    public void setName( String Name )
    {
        this.mName = Name;
    }

    public void setLastName( String LastName )
    {
        this.mLastName = LastName;
    }

    public void setAge( int Age )
    {
        this.mAge = Age;
    }

    public void setPerson( String Name, String LastName, int Age )
    {
        setName( Name );
        setLastName( LastName );
        setAge( Age );
    }

    private String mName;
    private String mLastName;
    private int mAge;

}
