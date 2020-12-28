import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import error.ValueException;
import java.lang.reflect.Array;
import java.util.Map;

public class Handler implements RequestHandler<Map<String, String>, String> {

  Gson gson = new GsonBuilder().setPrettyPrinting().create();

  @Override
  public String handleRequest(Map<String, String> event, Context context) {
    LambdaLogger logger = context.getLogger();
    String response = new String("200 OK");
    // log execution details
    logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
    logger.log("CONTEXT: " + gson.toJson(context));
    // process event
    logger.log("EVENT: " + gson.toJson(event));
    logger.log("EVENT TYPE: " + event.getClass().toString());

    try {

      int result = ChessMain.calculateQueenPossibility(
          Integer.parseInt(event.get("chessSize")),
          Integer.parseInt(event.get("obstacleCount")),
          Integer.parseInt(event.get("queenPositionX")),
          Integer.parseInt(event.get("queenPositionY")),
          gson.fromJson(event.get("obstaclePositionX"), int[].class),
          gson.fromJson(event.get("obstaclePositionY"), int[].class));
      response = String.valueOf(result);
    } catch (ValueException e) {
      response = e.getMessage();
      e.printStackTrace();
    }
    return response;
  }
}