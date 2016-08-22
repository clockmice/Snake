import com.googlecode.lanterna.terminal.Terminal;

import java.util.Random;

public class Dot {
    private Terminal terminal;
    private Snake snake;
    private Dot dot;
    Random random = new Random();
    public int x = random.nextInt(Game.WIDTH - 10) + 5;
    public int y = random.nextInt(Game.HEIGHT - 10) + 5;

    public void Move(){
        x = random.nextInt(Game.WIDTH - 10)+ 5;
        y = random.nextInt(Game.HEIGHT - 10) + 5;
    }
}
