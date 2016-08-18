import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class Snake {
    private Terminal terminal;
    private Dot dot;
    public int x = 10;
    public int y = 10;

    public Snake(Terminal terminal) {
        this.terminal = terminal;
    }

    public void Move() throws InterruptedException {
        Key key;
        do {
            Thread.sleep(5);
            key = terminal.readInput();
        } while (key == null);

        switch (key.getCharacter()){
            case 'U':
                if (y > 1) {
                    y--;
                }
                break;
            case 'D':
                if (y < 24) {
                    y++;
                }
                break;
            case 'L':
                if (x > 2) {
                    x--;
                }
                break;
            case 'R':
                if (x < 24) {
                    x++;
                }
                break;
        }

        System.out.println(key.getCharacter() + " " + key.getKind());
    }
}
