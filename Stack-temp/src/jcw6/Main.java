package jcw6;

public class Main {

    public static void main( String[] args )
    {
        Stack<Integer> s = new Stack<Integer>();
        Stack<Character> cStack = new Stack<Character>();
        try
        {
            s.push( 1 );
            s.push( 2 );
            s.push (3 );
            cStack.push( 'A' );
            cStack.push( 'B' );
            cStack.push( 'C' );

            System.out.println( s.pop() );
            System.out.println( s.pop() );
            System.out.println( s.pop() );
            System.out.println( cStack.pop() );
            System.out.println( cStack.pop() );
            System.out.println( cStack.pop() );
            System.out.println( cStack.pop() );

        } catch( ExceptionStack e)
        { System.out.println( "Exception: " + e.getReason() ); }

    }
}
