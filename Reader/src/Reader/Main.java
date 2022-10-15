package Reader;

import java.io.IOException;
public class Main {

    public static void main( String[] args ) {

        /*char c;
        System.out.print( "Podaj tekst: " );
        System.out.print("Wczytany tekst: " + ( c = Reader.getChar() ) );
        for (int i = 0; i < 5; i++)
            System.out.print( c = Reader.getChar() );
        Reader.ungetChar( c );
        for (int i = 0; i < 15; i++)
            System.out.print( Reader.getChar() );

        //Reader.setLoad( false );

        System.out.print( "\nPodaj tekst: " );
        System.out.print("Wczytany tekst: " + ( c = Reader.getChar() ) );
        for (int i = 0; i < 5; i++)
            System.out.print( c = Reader.getChar() );
        Reader.ungetChar( c );
        for (int i = 0; i < 15; i++)
            System.out.print( Reader.getChar() );*/

        try
        {
            System.out.print( "\nPodaj int: " );
            System.out.println( Reader.readInt() );
        }
        catch( Reader.ExceptionReader ex )
        {
            System.out.println( ex.getReason() );
        }

        try
        {
            System.out.print( "Podaj double: " );
            System.out.println( Reader.readDouble() );
        }
        catch( Reader.ExceptionReader ex )
        {
            System.out.println( ex.getReason() );
        }

        try
        {
            System.out.print( "Podaj Hex: ");
            System.out.println( Reader.readHex() );
        }
        catch( Reader.ExceptionReader ex )
        {
            System.out.println( ex.getReason() );
        }


    }
}
