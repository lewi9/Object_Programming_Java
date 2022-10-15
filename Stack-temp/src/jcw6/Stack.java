package jcw6;

public class Stack<T>
{
    private class StackItem<T>
    {
        private T mKey;
        private StackItem mNext;
        StackItem( T key, StackItem next)
        {
            setKey( key ); setNext( next );
        }

        public T getKey()
        { return mKey; }
        public StackItem getNext()
        { return mNext; }
        public void setKey( T mKey )
        { this.mKey = mKey; }
        public void setNext( StackItem mNext )
        { this.mNext = mNext; }
    } //end of StackItem

    public Stack()
    {
        mHead = null;
    }
    public void push( T key ) throws ExceptionStack
    {
        try
        { mHead = new StackItem( key, mHead); }
        catch ( OutOfMemoryError e)
        { throw new ExceptionStack( ErrCode.STACK_OVERFLOW ); }
    }
    public T pop() throws ExceptionStack
    {
        if( !isEmpty() )
        {
            T key = top();
            del();
            return key;
        }
        throw new ExceptionStack( ErrCode.STACK_IS_EMPTY );
    }
    public T top() throws ExceptionStack
    {
        if( !isEmpty() )
            return (T)mHead.getKey();
        throw new ExceptionStack( ErrCode.STACK_IS_EMPTY );
    }
    public void del() throws ExceptionStack
    {
        if( isEmpty() )
            throw new ExceptionStack( ErrCode.STACK_IS_EMPTY );
        mHead = mHead.getNext();
    }
    public boolean isEmpty()
    {
        return mHead == null;
    }

    private StackItem mHead; // head of stack - LIFO list
}
