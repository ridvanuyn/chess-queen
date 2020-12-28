package error;

import error.BaseException;

public class ValueException extends BaseException {


  public ValueException(ExceptionCode exceptionCode) {
    super(exceptionCode);
  }

}
