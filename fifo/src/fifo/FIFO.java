package fifo;

public class FIFO<T>
{
    private static class FifoItem<T>
    {
        private T        mKey;
        private FifoItem<T> mNext;

        public FifoItem( T key  )
        {
            setKey( key );
            setNext( null );
        }
        public T getKey()
        {
            return mKey;
        }
        public FifoItem<T> getNext()
        {
            return mNext;
        }
        public void setKey ( T key ) { mKey = key; }
        public void setNext( FifoItem<T> item )
        {
            mNext = item;
        }
    }
//-------------------------------------------------------------------------------------------------
    public FIFO()
    {
        try
        {
            mHead = mTail = new FifoItem<>(null);
        }
        catch( OutOfMemoryError e )
        {
            throw new ExceptionFIFO( ErrCode.FIFO_IS_OVERLOAD );
        }
    }
    public boolean  QFEmpty()
    {
        return mHead.getNext() == null;
    }
    public void QFEnqueue( T x  ) throws ExceptionFIFO
    {
        try
        {
            mTail.setNext( new FifoItem<>( x ) );
        }
        catch( OutOfMemoryError e )
        {
            throw new ExceptionFIFO( ErrCode.FIFO_IS_OVERLOAD );
        }
        mTail = mTail.getNext();
    }
    public T QFDequeue() throws ExceptionFIFO
    {
        if( !QFEmpty() ) {
            T item = mHead.getNext().getKey();
            mHead.setNext( mHead.getNext().getNext() );
            if( QFEmpty() )
                mTail=mHead;
            return item;
        }
        throw new ExceptionFIFO( ErrCode.FIFO_IS_EMPTY );
    }

    public void  QFClear()
    {
        while( !QFEmpty() )
            QFDequeue();
    }
    public void QFPrint()
    {
        if( QFEmpty() )
            return;

        FifoItem<T> item = mHead.getNext();

        do System.out.println( item.getKey() );
        while( ( item = item.getNext() ) != null );

    }

    private final FifoItem<T> mHead;
    private FifoItem<T> mTail;
}