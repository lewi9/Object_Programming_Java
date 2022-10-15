package fifo;

enum ErrCode { FIFO_IS_OVERLOAD, FIFO_IS_EMPTY, OTHER_ERROR}

public class ExceptionFIFO extends RuntimeException // Exception
{
    private ErrCode mErrCode;
    ExceptionFIFO (ErrCode errCode )
    {
        mErrCode=errCode;
    }

    public String getReason()
    {
        switch(mErrCode){
            case FIFO_IS_OVERLOAD: return "\nFifo is overload";
            case FIFO_IS_EMPTY: return "\nFifo is empty!\n";
            default: return"\nOther error!\n";
        }
    }
}