package error;

public enum ExceptionCode implements ErrorCode {

  VALUES_CAN_NOT_BE_NEGATIVE_OR_ZERO(ErrorCode.CODE_1000, "Values can't be negative !"),
  QUEEN_AND_OBSTACLE_SAME_SPOT(ErrorCode.CODE_1001, "Queen and obstacle same spot please check"),
  TOO_MUCH_OBSTACLES(ErrorCode.CODE_1002, "There is too much obstacles ! "),
  OBSTACLE_COUNT_OBSTACLE_ARRAY_MISMATCH(ErrorCode.CODE_1003, "Obstacle count and obstacle array mismatch please check ! ");

  private final int id;
  private final String message;

  ExceptionCode(int id, String message) {
    this.id = id;
    this.message = message;
  }

  public int getId() {
    return this.id;
  }

  public String getMessage() {
    return this.message;
  }
}
