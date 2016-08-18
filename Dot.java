import com.googlecode.lanterna.terminal.Terminal;

import java.util.Random;

public class Dot {
    private Terminal terminal;
    private Snake snake;
    private Dot dot;
    Random random = new Random();
    public int x = random.nextInt(25) + 1;
    public int y = random.nextInt(25) + 1;

    public void Move(){
        x = random.nextInt(25)+1;
        y = random.nextInt(25)+1;
    }
}
