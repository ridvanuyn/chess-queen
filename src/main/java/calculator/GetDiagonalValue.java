package calculator;

public class GetDiagonalValue {

  private int queenPositionX;
  private int queenPositionY;
  private int[] obstaclesPositionX;
  private int[] obstaclesPositionY;
  private int diagonalDistanceLeftDown;
  private int diagonalDistanceRightUp;
  private int diagonalDistanceRightDown;
  private int diagonalDistanceLeftUp;
  private int i;

  public GetDiagonalValue(int queenPositionX, int queenPositionY, int[] obstaclesPositionX,
      int[] obstaclesPositionY, int diagonalDistanceLeftDown, int diagonalDistanceRightUp,
      int diagonalDistanceRightDown, int diagonalDistanceLeftUp, int i) {
    this.queenPositionX = queenPositionX;
    this.queenPositionY = queenPositionY;
    this.obstaclesPositionX = obstaclesPositionX;
    this.obstaclesPositionY = obstaclesPositionY;
    this.diagonalDistanceLeftDown = diagonalDistanceLeftDown;
    this.diagonalDistanceRightUp = diagonalDistanceRightUp;
    this.diagonalDistanceRightDown = diagonalDistanceRightDown;
    this.diagonalDistanceLeftUp = diagonalDistanceLeftUp;
    this.i = i;
  }

  public int getDiagonalDistanceLeftDown() {
    return diagonalDistanceLeftDown;
  }

  public int getDiagonalDistanceRightUp() {
    return diagonalDistanceRightUp;
  }

  public int getDiagonalDistanceRightDown() {
    return diagonalDistanceRightDown;
  }

  public int getDiagonalDistanceLeftUp() {
    return diagonalDistanceLeftUp;
  }

  public GetDiagonalValue invoke() {
    if (queenPositionX > obstaclesPositionX[i] && queenPositionY > obstaclesPositionY[i] &&
        queenPositionX - obstaclesPositionX[i] == queenPositionY - obstaclesPositionY[i]) {
      diagonalDistanceLeftDown = Math
          .min(diagonalDistanceLeftDown, queenPositionX - obstaclesPositionX[i] - 1);

    }

    if (obstaclesPositionX[i] > queenPositionX && obstaclesPositionY[i] > queenPositionY &&
        obstaclesPositionX[i] - queenPositionX == obstaclesPositionY[i] - queenPositionY) {
      diagonalDistanceRightUp = Math
          .min(diagonalDistanceRightUp, obstaclesPositionX[i] - queenPositionX - 1);
    }

    if (obstaclesPositionX[i] > queenPositionX && queenPositionY > obstaclesPositionY[i] &&
        obstaclesPositionX[i] - queenPositionX == queenPositionY - obstaclesPositionY[i]) {
      diagonalDistanceRightDown = Math
          .min(diagonalDistanceRightDown, obstaclesPositionX[i] - queenPositionX - 1);
    }
    if (queenPositionX > obstaclesPositionX[i] && obstaclesPositionY[i] > queenPositionY &&
        queenPositionX - obstaclesPositionX[i] == obstaclesPositionY[i] - queenPositionY) {
      diagonalDistanceLeftUp = Math
          .min(diagonalDistanceLeftUp, queenPositionX - obstaclesPositionX[i] - 1);
    }
    return this;
  }
}
