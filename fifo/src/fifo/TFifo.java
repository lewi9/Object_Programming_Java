package fifo;


public class TFifo<T>
{
    private final  T [] q;
    private final int mMaxSize;  // ZBEDNE - mozna uzyc q.length
    private int mHead;     // indeks pierwszego elem do popbrania z kolejki
    private int mTail;     // indeks pierwzego wolnego miejsca w kolejce
    private int mElemNo;   // ilosc elementow w kolejce

    // metody analogicznie!
    //-------------
    public TFifo( T[] tab )
    {
        q = tab;
        mMaxSize = q.length;
        mHead = mTail = mElemNo = 0;
    }
    public boolean QFEmpty()
    {
        return mElemNo==0;
    }
    public void QFEnqueue( T x  ) throws ExceptionFIFO
    {
        if( mElemNo>= mMaxSize )
            throw new ExceptionTFIFO( ErrCodeT.TFIFO_IS_OVERLOAD );
        q[ mTail ] = x;
        mTail = ( mTail+1 )%mMaxSize;
        mElemNo++;
    }
    public T QFDequeue() throws ExceptionFIFO
    {
        if( !QFEmpty() )
        {
            T item = q[ mHead ];
            q[ mHead ] = null;
            mHead = ( mHead+1 )%mMaxSize;
            mElemNo--;
            return item;
        }
        throw new ExceptionTFIFO( ErrCodeT.TFIFO_IS_EMPTY );

    }
    public void  QFClear()
    {
        while( !QFEmpty() )
            QFDequeue();
        mHead = mTail = 0;
    }
    public void QFPrint()
    {
        for( int i = mHead;; )
        {
            if( i == mTail )
                return;
            System.out.println( q[i] );
            i = ( i+1 )%mMaxSize;
        }
    }
}
