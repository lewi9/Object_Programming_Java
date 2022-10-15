package School;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SchoolBoy boy = new SchoolBoy();
        SchoolGirl girl = new SchoolGirl( "Anastazja", "Kowalska", 18, "2c" );
        SchoolBoy a = new SchoolBoy();
        SchoolBoy b= new SchoolBoy();
        SchoolBoy aa = new SchoolBoy();
        SchoolBoy c = new SchoolBoy();
        SchoolBoy d = new SchoolBoy();
        Pupil [] arr = { boy, girl, a, b, aa, c, d };
        boy.addMark( 3, Pupil.Subject.ANGIELSKI );
        boy.addMark( 4.5, Pupil.Subject.NIEMIECKI );
        boy.addMark( 3.75, Pupil.Subject.INFORMATYKA );
        boy.addMark( 5, Pupil.Subject.MATEMATYKA );
        girl.addMark( 5, Pupil.Subject.CHEMIA );
        System.out.println ( "Ocena z chemii: " +  girl.getMark( Pupil.Subject.CHEMIA ));
        girl.clearMarks();
        System.out.println ( "Ocena z chemii: " +  girl.getMark( Pupil.Subject.CHEMIA ));
        printPupils( arr );
    }

    static void printPupils( Pupil [] arr )
    {
        for( int i=0; i< arr.length; i++)
            System.out.println( arr[i].toString() );
    }

}
