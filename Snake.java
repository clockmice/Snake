import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private Terminal terminal;
    private Dot dot;
    public static List<Cell> snakeBody;

    Cell head = new Cell(10,10);

    public Snake(Terminal terminal) {
        this.terminal = terminal;
        snakeBody = new ArrayList<>();
    }

    public void addCell(Cell cell){
        snakeBody.add(cell);
    }


    public void Move() throws InterruptedException {
        Key key;
        do {
            Thread.sleep(5);
            key = terminal.readInput();
        } while (key == null);

        if (snakeBody.size()>0) {
            MoveBody();
        }

        switch (key.getCharacter()){
            case 'U':
                if (head.y > 1) {
                    head.y--;
                }
                break;
            case 'D':
                if (head.y < Game.HEIGHT - 1) {
                    head.y++;
                }
                break;
            case 'L':
                if (head.x > 1) {
                    head.x--;
                }
                break;
            case 'R':
                if (head.x < Game.WIDTH - 1) {
                    head.x++;
                }
                break;
        }

        System.out.println(key.getCharacter() + " " + key.getKind());
    }

    public void MoveBody() {
        for (int i = snakeBody.size()-1; i>0; i--){
            snakeBody.get(i).x = snakeBody.get(i-1).x;
            snakeBody.get(i).y = snakeBody.get(i-1).y;
        }
        snakeBody.get(0).x = head.x;
        snakeBody.get(0).y = head.y;
    }
}
