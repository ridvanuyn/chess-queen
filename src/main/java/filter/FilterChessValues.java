package filter;

import error.ExceptionCode;
import error.ValueException;

public class FilterChessValues {


  public static void checkChessAndObstacleSizes(int chessSize, int obstacleCount)
      throws ValueException {
    if (obstacleCount > (chessSize * chessSize)) {
      throw new ValueException(ExceptionCode.TOO_MUCH_OBSTACLES);
    }
  }


  public static void obstacleCountIsNegative(int obstacleCount) throws ValueException {
    if (obstacleCount < 0) {
      throw new ValueException(ExceptionCode.VALUES_CAN_NOT_BE_NEGATIVE_OR_ZERO);
    }
  }

  public static void queenPositionIsNegative(int queenPositionX, int queenPositionY)
      throws ValueException {
    if (queenPositionX * queenPositionY <= 0) {
      throw new ValueException(ExceptionCode.VALUES_CAN_NOT_BE_NEGATIVE_OR_ZERO);
    }
  }


  public static void checkPositionQueenAndObstacle(int queenPositionX, int queenPositionY,
      int[] obstaclesPositionX, int[] obstaclesPositionY)
      throws ValueException {
    int multiply = 1;
    for (int positionX : obstaclesPositionX) {
      if (queenPositionX == positionX) {
        for (int positionY : obstaclesPositionY) {
          if (queenPositionY == positionY) {
            throw new ValueException(ExceptionCode.QUEEN_AND_OBSTACLE_SAME_SPOT);
          }
          multiply = positionX * positionY * multiply;
          if (multiply < 0) {
            throw new ValueException(ExceptionCode.VALUES_CAN_NOT_BE_NEGATIVE_OR_ZERO);
          }
        }
      }

    }
  }


}
