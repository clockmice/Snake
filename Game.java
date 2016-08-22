import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import static sun.audio.AudioPlayer.player;

public class Game {
    public static boolean run = true;
    private Terminal terminal;
    private Snake snake;
    private Dot dot;

    public static final int WIDTH = 100;
    public static final int HEIGHT = 30;

    public Game(Terminal terminal, Snake snake, Dot dot) {
        this.terminal = terminal;
        this.snake = snake;
        this.dot = dot;
    }

    public void Run() throws InterruptedException {
        terminal.enterPrivateMode();

        do{
            UpdateBoard(terminal, snake, dot);
            snakeMove(snake);
            GameLogic();
        }
        while (run);

    }

    public void snakeMove(Snake snake) throws InterruptedException {
        Key key;
        key = terminal.readInput();
        Thread.sleep(200);
        snake.head.y++;

        switch (key.getCharacter()){
            case 'U':
                Thread.sleep(200);
                snake.head.y--;
                break;
            case 'D':
                Thread.sleep(200);
                snake.head.y++;
                break;
        }
//blabal
//blabal
//blabal
//blabal
//blabal
//blabal



//        Key key;
//        key = terminal.readInput();
////        do {
////            Thread.sleep(5);
////            key = terminal.readInput();
////        } while (key == null);
//
//        if (snake.snakeBody.size()>0) {
//            snake.MoveBody();
//        }
//
//        while (key== null) {
//            switch (key.getCharacter()){
//                case 'U':
//                    snake
//                    break;
//                case 'D':
//                    if (head.y < Game.HEIGHT - 1) {
//                        head.y++;
//                    }
//                    break;
//                case 'L':
//                    if (head.x > 1) {
//                        head.x--;
//                    }
//                    break;
//                case 'R':
//                    if (head.x < Game.WIDTH - 1) {
//                        head.x++;
//                    }
//                    break;
//            }
//        }
//
//        System.out.println(key.getCharacter() + " " + key.getKind());

    }

    private void GameLogic() {
        //snake.addCell(snake.head);
        if ((snake.head.x == dot.x) && (snake.head.y == dot.y)){
            dot.Move();
            snake.addCell(new Cell(snake.head.x, snake.head.y +1));
        }

    }

    private void UpdateBoard(Terminal terminal, Snake snake, Dot dot) {
        terminal.clearScreen();
        terminal.moveCursor(snake.head.x, snake.head.y);
        terminal.applyForegroundColor(0, 204, 0);
        terminal.putCharacter('O');
        for (Cell cell : snake.snakeBody) {
            terminal.moveCursor(cell.x, cell.y);
            terminal.applyForegroundColor(0, 204, 0);
            terminal.putCharacter('O');
        }
        terminal.moveCursor(dot.x, dot.y);
        terminal.applyForegroundColor(200, 0, 0);
        terminal.putCharacter('O');
        DrawFrame();
        terminal.moveCursor(0,0);
    }

    private void DrawFrame() {
        for (int i = 0; i<WIDTH; i++){
            terminal.moveCursor(i, 0);
            terminal.applyForegroundColor(255, 255, 255);
            terminal.putCharacter('-');
        }
        for (int i = 0; i<WIDTH; i++){
            terminal.moveCursor(i, HEIGHT-1);
            terminal.applyForegroundColor(255, 255, 255);
            terminal.putCharacter('-');
        }
        for (int i = 0; i<HEIGHT; i++){
            terminal.moveCursor(0, i);
            terminal.applyForegroundColor(255, 255, 255);
            terminal.putCharacter('|');
        }
        for (int i = 0; i<HEIGHT; i++){
            terminal.moveCursor(WIDTH-1, i);
            terminal.applyForegroundColor(255, 255, 255);
            terminal.putCharacter('|');
        }
    }

    private void GameOver() {
    }
}
