import static org.junit.jupiter.api.Assertions.*;

import error.ExceptionCode;
import error.ValueException;
import org.junit.Before;
import org.junit.Test;

public class ChessMainTest {

  ChessMain chessMain;

  int[] obstaclePosX = {3};
  int[] obstaclePosY = {2};
  int[] obstaclesPosX = {3, 4};
  int[] obstaclesPosY = {2, 1};
  int[] emptyObstacleArray = {};


  @Before
  public void setUp() throws Exception {
    chessMain = new ChessMain();
  }

  @Test
  public void shouldPass_When1ObstacleAndNoHorizontalPossibilities() throws ValueException {
    int result = ChessMain.calculateQueenPossibility(
        5, 1, 2, 1, obstaclePosX, obstaclePosY);
    assertEquals(9, result);

  }

  @Test
  public void shouldPass_WhenNoObstacle() throws ValueException {
    int result = ChessMain.calculateQueenPossibility(
        5, 0, 3, 3, emptyObstacleArray, emptyObstacleArray);
    assertEquals(16, result);

  }

  @Test
  public void shouldPass_WhenMultipleObstacle() throws ValueException {
    int result = ChessMain.calculateQueenPossibility(
        5, 2, 5, 1, obstaclesPosX, obstaclesPosY);
    assertEquals(8, result);
  }

  @Test
  public void shouldThrowError_WhenQueenAndObstaclesSamePosition() throws ValueException {
    assertThrows(ValueException.class, () -> ChessMain.calculateQueenPossibility(
        5, 2, 3, 2, obstaclesPosX, obstaclesPosY),
        ExceptionCode.TOO_MUCH_OBSTACLES.getMessage());
  }

  @Test
  public void shouldThrowError_WhenTooMuchObstacle() throws ValueException {
    assertThrows(ValueException.class, () -> ChessMain.calculateQueenPossibility(
        5, 200, 3, 2, obstaclesPosX, obstaclesPosY),
        ExceptionCode.TOO_MUCH_OBSTACLES.getMessage());
  }

  @Test
  public void shouldThrowError_WhenNegativeObstacle() throws ValueException {
    assertThrows(ValueException.class, () -> ChessMain.calculateQueenPossibility(
        5, -4, 3, 3, obstaclesPosX, obstaclesPosY),
        ExceptionCode.VALUES_CAN_NOT_BE_NEGATIVE_OR_ZERO.getMessage());
  }

  @Test
  public void shouldThrowError_WhenZeroPosition() throws ValueException {
    assertThrows(ValueException.class, () -> ChessMain.calculateQueenPossibility(
        5, 200, 0, 3, obstaclesPosX, obstaclesPosY),
        ExceptionCode.VALUES_CAN_NOT_BE_NEGATIVE_OR_ZERO.getMessage());
  }

  @Test
  public void shouldThrowError_WhenNegativePosition() throws ValueException {
    assertThrows(ValueException.class, () -> ChessMain.calculateQueenPossibility(
        5, 200, -3, 3, obstaclesPosX, obstaclesPosY),
        ExceptionCode.VALUES_CAN_NOT_BE_NEGATIVE_OR_ZERO.getMessage());
  }
}