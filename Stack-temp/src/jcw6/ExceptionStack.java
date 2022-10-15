package jcw6;

enum ErrCode { STACK_IS_EMPTY, STACK_OVERFLOW, OTHER_ERROR }

/*enum ErrCode { STACK_IS_EMPTY(1), STACK_OVERFLOW(2), OTHER_ERROR(4); // <-- średnik
    private int mCode;
    ErrCode( int code )
    { mCode = code; }
}*/

public class ExceptionStack extends RuntimeException //exception
{
    private ErrCode mErrCode;
    ExceptionStack( ErrCode errCode )
    {
        mErrCode = errCode;
    }
    public String getReason()
    {
        switch ( mErrCode )
        {
            case STACK_IS_EMPTY : return "\nStack is empty!!\n";
            case STACK_OVERFLOW : return "\nStack overflow!!\n";
            default             : return "\nOther error!!\n";
        }
    }
}
