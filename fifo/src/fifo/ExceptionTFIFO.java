package fifo;

enum ErrCodeT { TFIFO_IS_OVERLOAD, TFIFO_IS_EMPTY, OTHER_TERROR}

public class ExceptionTFIFO extends RuntimeException // Exception
{
    private ErrCodeT mErrCode;
    ExceptionTFIFO ( ErrCodeT errCode )
    {
        mErrCode = errCode;
    }

    public String getReason()
    {
        switch(mErrCode){
            case TFIFO_IS_OVERLOAD: return "\nTFifo is overload";
            case TFIFO_IS_EMPTY: return "\nTFifo is empty!\n";
            default: return"\nOther Terror!\n";
        }
    }
}