package calculator;

public class GetVerticalAndHorizontalValue {

  private int queenPositionX;
  private int queenPositionY;
  private int[] obstaclesPositionX;
  private int[] obstaclesPositionY;
  private int verticalDistanceDown;
  private int verticalDistanceUp;
  private int horizontalDistanceLeft;
  private int horizontalDistanceRight;
  private int i;

  public GetVerticalAndHorizontalValue(int queenPositionX, int queenPositionY,
      int[] obstaclesPositionX,
      int[] obstaclesPositionY, int verticalDistanceDown, int verticalDistanceUp,
      int horizontalDistanceLeft, int horizontalDistanceRight, int i) {
    this.queenPositionX = queenPositionX;
    this.queenPositionY = queenPositionY;
    this.obstaclesPositionX = obstaclesPositionX;
    this.obstaclesPositionY = obstaclesPositionY;
    this.verticalDistanceDown = verticalDistanceDown;
    this.verticalDistanceUp = verticalDistanceUp;
    this.horizontalDistanceLeft = horizontalDistanceLeft;
    this.horizontalDistanceRight = horizontalDistanceRight;
    this.i = i;
  }

  public int getVerticalDistanceDown() {
    return verticalDistanceDown;
  }

  public int getVerticalDistanceUp() {
    return verticalDistanceUp;
  }

  public int getHorizontalDistanceLeft() {
    return horizontalDistanceLeft;
  }

  public int getHorizontalDistanceRight() {
    return horizontalDistanceRight;
  }

  public GetVerticalAndHorizontalValue invoke() {
    if (queenPositionX == obstaclesPositionX[i] && obstaclesPositionY[i] < queenPositionY) {
      verticalDistanceDown = Math
          .min(verticalDistanceDown, queenPositionY - obstaclesPositionY[i] - 1);
    }

    if (queenPositionX == obstaclesPositionX[i] && obstaclesPositionY[i] > queenPositionY) {
      verticalDistanceUp = Math
          .min(verticalDistanceUp, obstaclesPositionY[i] - queenPositionY - 1);
    }

    if (queenPositionY == obstaclesPositionY[i] && obstaclesPositionX[i] < queenPositionX) {
      horizontalDistanceLeft = Math
          .min(horizontalDistanceLeft, queenPositionX - obstaclesPositionX[i] - 1);
    }

    if (queenPositionY == obstaclesPositionY[i] && obstaclesPositionX[i] > queenPositionX) {
      horizontalDistanceRight = Math
          .min(horizontalDistanceRight, obstaclesPositionX[i] - queenPositionX - 1);
    }
    return this;
  }
}