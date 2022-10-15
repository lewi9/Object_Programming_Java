package Reader;

import java.io.IOException;
import java.util.Scanner;

enum ErrCode { IS_NOT_DEC, IS_NOT_HEX, OTHER_ERROR}

/**
 * @author Adam Lewinski
 */

/**** NAJPIERW NAPISALEM KOD PRZY UZYCIU SCANNER    ,
 * ODOPOWIEDNIE CZESCI ZAKOMENTOWAŁEM
 * I PRZEPISALEM PROGRAM NA SYSTEM.IN.READ()
 * ZAKOMENTOWALEM TO ZA POMOCA ZNACZNIKOW DOKUMENTACJI
 * ABY LEPIEJ WYROZNIC TEN KOD
 */

public class Reader
{
    public static class ExceptionReader extends RuntimeException // Exception
    {
        private ErrCode mErrCode;
        ExceptionReader (ErrCode errCode )
        {
            mErrCode=errCode;
        }

        public String getReason()
        {
            switch(mErrCode){
                case IS_NOT_DEC: return "\nIt's not dec";
                case IS_NOT_HEX: return "\nIt's not HEX!\n";
                default: return"\nOther error!\n";
            }
        }
    }
    /**
    //private static final Scanner reader = new Scanner(System.in);
    //private static String text;
    //private static boolean Loaded = false;
    //private static int index = 0;*/
    private static boolean Flag = false;
    private static char C = 'c';

    /**
     * Reads one character from the input stream System.in
     * @return  returns read character
     */

    public static char getChar() // only one char could be ungetted
    {  // read()
        /**
        /*if( !Loaded )
        {
            index = 0;
            Flag = false;
            Loaded = true;
            text = reader.nextLine();
            if ( text.length() == 0 )
                return 0;
            return text.charAt( index++ );

        }
        if( index >= text.length() )
            return 0;

        if ( Flag )
        {
            Flag = false;
            return C;
        }
        return text.charAt( index++ );*/
        try
        {
            if( !Flag )
            {
                return  (char)System.in.read();
            }
            Flag = false;
            return C;
        }
        catch ( IOException e )
        {
            return 0;
        }

    }

    /**
     * Returns one character to the input for reloading. Only one char could be returned!
     * @param c - zwracany znak do ponownego odczytu
     */
    public static void ungetChar( char c )
    {
        Flag = true;
        C = c;
    }
    /**
    /*public static void setLoad( boolean logic )
    {
        Loaded = logic;
    }*/

    /**
     * Reads the integer value written in char case
     * @return return the value of integer  number
     */
    public static int readInt () throws ExceptionReader
    {
      /**  //Loaded = false; */
        //czy znak - fun
        boolean sign = getSign();
        // czytanie liczby bez znaku - fun

        int result = readNum();
        if( sign )
            result = -result;
        // zwrocic wart (return)
        return result;
    }

    /**
     * Reads the double value written in char case
     * @return the value of double  num
     */
    public static double readDouble() throws ExceptionReader
    {
        /**  //Loaded = false; */
        //czy znak - fun
        // czytanie cechy fun
        boolean sign = getSign();
        int result = readNum();

        char c = getChar();
        if( c != '.' && c!= ',' )
        {
            ungetChar( c );
            return result;
        }
        double mant_res = 0;
        double divider = 1;
        // czytanie mantysy
        while( isDecDigit( c = getChar() ) )
            mant_res = mant_res + ( divider*=0.1 ) * charDecDigit2Int( c );
        //na koncu zwraca znak
        ungetChar( c );
        // zwrocenie wyniku (return)

        return (sign) ? -result - mant_res : result + mant_res;
    }

    /**
     * Reads the hexadecimal value written in char case
     * @return returns value of proper hexadecimal value
     */
    public static int readHex() throws ExceptionReader
    {
        /**  //Loaded = false; */
        // poprzedajaca biale znaki
        skipSpaces();
        //sprawdzic czy format 0x 0X
        char c = getChar();
        if( c != '0' )
        {
            ungetChar( c );
            throw new ExceptionReader( ErrCode.IS_NOT_HEX );
        }
        c = getChar();
        if( c != 'x' && c!= 'X' )
        {
            ungetChar( c );
            throw new ExceptionReader( ErrCode.IS_NOT_HEX );
        }
        int result = 0;
        // Horner petla z jedna instr
        while ( isHexDigit( c = getChar() ) )
            result = result * 16 + ( isDecDigit( c ) ? charDecDigit2Int( c ) : charHexDigit2Int( c ) );
        //na koncu zwraca znak
        ungetChar(c);
        //return wynik

        return result;
    }

    //================ P R I V A T E INTERFACE ==========================================
    private static int readNum() throws ExceptionReader
    {


        //czytanie liczby calk bez znaku poprzedz bialymi znakami
        skipSpaces();

        char c = getChar();
        if( !isDecDigit( c ) )
        {
            ungetChar( c );
            throw new ExceptionReader( ErrCode.IS_NOT_DEC );
        }
        ungetChar( c );

        int result = 0;
        while( isDecDigit( c = getChar() ) )
            result = 10 * result + charDecDigit2Int( c );
        //na koncu zwraca znak
        ungetChar( c );
        return result;

    }

    private static boolean getSign()
    {
        //czytanie znaku poprzedz bialymi znakami
        skipSpaces();
        char c = getChar();
        //jak byl minus to zwraca true
        if ( c == '-' )
            return true;
        //na koncu zwraca znak jesli nie nylo '-'
        if( c!= '+')
            ungetChar( c );
        return false;

    }
    private static void skipSpaces()
    {
        char c = getChar();
        // pomija spacje tabulatroy CR-y, LF-dy
        while( c == 32 || c == 9 || c == 10 || c == 13 )
            c = getChar();
        //na koncu zwraca znak
        ungetChar( c );
    }

    //  W PONIZSZYCH FUNKCJACH JELSI MOZLIWE TO WYWOLYWAC FUNCKJE TU ZDEFINIOWANE
    //   NP isHexDigit POWINNA KORZYSTAC Z isDecDigit
    private static boolean isDecDigit( char c )
    {
        // jedna instr(linia) return . . .
        return ( c>='0' && c<='9' );
    }

    private static boolean isHexDigit( char c )
    {
        //jedna linia return . . . .
        return ( isDecDigit( c ) || isHexLetter( c ) ) ;
    }

    private static char upperCase( char c )
    {
        //jedna instr   return . . .
        return ( c>='a' && c <='f' ) ? (char)( c-32 ) : c ;
    }

    private static boolean isHexLetter( char c )
    {
        // jedna instr  return . . .
        return ( c >='A' && c <='F' ) || ( c>= 'a' && c<= 'f' );
    }

    private static int charDecDigit2Int( char c )
    {
        // jedna instr return . . .
        return c-'0' ;
    }

    private static int charHexDigit2Int( char c )
    {
        //jenda instr return . . . .   (w tej jednej instr ma c zamianac na upperCase) // ma wywolac charDecDigit2Int
        return charDecDigit2Int( upperCase( c ) ) - 7;
    }

}//end of class
