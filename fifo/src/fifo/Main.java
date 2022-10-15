package fifo;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FIFO<Integer> intQF = new FIFO<>();
        Character []t = { null, null, null, null, null, null };
        TFifo<Character> doubleQF = new TFifo<>( t );

        try {
            intQF.QFEnqueue( 4 );
            intQF.QFEnqueue( 5 );
            intQF.QFEnqueue( 6 );
            intQF.QFPrint();
            System.out.println( "Element przed czyszczniem: " + intQF.QFDequeue() );
            intQF.QFClear();
            intQF.QFEnqueue( 11 );
            intQF.QFEnqueue( 124 );
            intQF.QFEnqueue( 532 );
            intQF.QFPrint();
            intQF.QFClear();
            intQF.QFPrint();
            intQF.QFDequeue();
        }
        catch( ExceptionFIFO e ){
            System.out.println( e.getReason() );
        }

        try {
            doubleQF.QFEnqueue( 'A' );
            doubleQF.QFEnqueue('B' );
            doubleQF.QFEnqueue( 'C' );
            doubleQF.QFPrint();
            System.out.println( "Element przed czyszczniem: " + doubleQF.QFDequeue() );
            doubleQF.QFClear();
            doubleQF.QFEnqueue( 'd' );
            doubleQF.QFEnqueue('e' );
            doubleQF.QFEnqueue( 'f' );
            doubleQF.QFPrint();
            doubleQF.QFClear();
            doubleQF.QFPrint();
            doubleQF.QFDequeue();
        }
        catch( ExceptionTFIFO e ){
            System.out.println( e.getReason() );
        }
    }
}
