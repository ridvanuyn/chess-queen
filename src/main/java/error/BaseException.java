package error;

public abstract class BaseException extends Exception {

  BaseException(ExceptionCode exceptionCode) {
    super(exceptionCode.getMessage());
  }
}  