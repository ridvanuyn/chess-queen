import calculator.GetDiagonalValue;
import calculator.GetVerticalAndHorizontalValue;
import error.ValueException;
import filter.FilterChessValues;

public class ChessMain {


  public static int calculateQueenPossibility(int chessSize, int obstacleCount, int queenPositionX,
      int queenPositionY, int[] obstaclesPositionX, int[] obstaclesPositionY)
      throws ValueException {

    int diagonalDistanceLeftDown, diagonalDistanceRightUp, diagonalDistanceRightDown, diagonalDistanceLeftUp,
        verticalDistanceDown, verticalDistanceUp, horizontalDistanceLeft, horizontalDistanceRight;

    diagonalDistanceLeftDown = Math.min(queenPositionX - 1, queenPositionY - 1);
    diagonalDistanceRightUp = Math.min(chessSize - queenPositionX, chessSize - queenPositionY);
    diagonalDistanceRightDown = Math.min(chessSize - queenPositionX, queenPositionY - 1);
    diagonalDistanceLeftUp = Math.min(queenPositionX - 1, chessSize - queenPositionY);

    verticalDistanceDown = queenPositionY - 1;
    verticalDistanceUp = chessSize - queenPositionY;
    horizontalDistanceLeft = queenPositionX - 1;
    horizontalDistanceRight = chessSize - queenPositionX;

    FilterChessValues.checkChessAndObstacleSizes(chessSize, obstacleCount);
    FilterChessValues.queenPositionIsNegative(queenPositionX, queenPositionY);
    FilterChessValues.obstacleCountIsNegative(obstacleCount);
    FilterChessValues.obstacleCountAndObstacleArraySize(obstacleCount,obstaclesPositionX,obstaclesPositionY);
    FilterChessValues
        .checkPositionQueenAndObstacle(queenPositionX, queenPositionY, obstaclesPositionX,
            obstaclesPositionY);

    for (int i = 0; i < obstacleCount; i++) {
      GetDiagonalValue getDiagonalValue = new GetDiagonalValue(queenPositionX, queenPositionY,
          obstaclesPositionX, obstaclesPositionY,
          diagonalDistanceLeftDown, diagonalDistanceRightUp, diagonalDistanceRightDown,
          diagonalDistanceLeftUp, i).invoke();
      diagonalDistanceLeftDown = getDiagonalValue.getDiagonalDistanceLeftDown();
      diagonalDistanceRightUp = getDiagonalValue.getDiagonalDistanceRightUp();
      diagonalDistanceRightDown = getDiagonalValue.getDiagonalDistanceRightDown();
      diagonalDistanceLeftUp = getDiagonalValue.getDiagonalDistanceLeftUp();

      GetVerticalAndHorizontalValue getVerticalAndHorizontalValue = new GetVerticalAndHorizontalValue(
          queenPositionX, queenPositionY, obstaclesPositionX,
          obstaclesPositionY, verticalDistanceDown, verticalDistanceUp, horizontalDistanceLeft,
          horizontalDistanceRight, i).invoke();
      verticalDistanceDown = getVerticalAndHorizontalValue.getVerticalDistanceDown();
      verticalDistanceUp = getVerticalAndHorizontalValue.getVerticalDistanceUp();
      horizontalDistanceLeft = getVerticalAndHorizontalValue.getHorizontalDistanceLeft();
      horizontalDistanceRight = getVerticalAndHorizontalValue.getHorizontalDistanceRight();
    }

    return diagonalDistanceLeftDown + diagonalDistanceRightUp + diagonalDistanceRightDown
        + diagonalDistanceLeftUp
        + verticalDistanceDown + verticalDistanceUp + horizontalDistanceLeft
        + horizontalDistanceRight;
  }

}


