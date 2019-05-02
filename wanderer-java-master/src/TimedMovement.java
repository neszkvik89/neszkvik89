import java.awt.*;
import java.util.TimerTask;

public class TimedMovement extends TimerTask {
  @Override
  public void run() {

    for (int i = 0; i < Board.myMonsters.size(); i++) {
      Board.moveMonster(Board.myMonsterImages.get(i), Board.myMonsters.get(i));
      for (int j = 0; j < Board.myMonsters.size(); j++) {
        if (!Board.myMonsters.get(i).isDead()) {
          //Board.myMonsterImages.get(i).draw(graphics);
        }
      }
    }
  }
}
