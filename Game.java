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
            snake.Move();
            GameLogic();
        }
        while (run);

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
            terminal.putCharacter('*');
        }
        for (int i = 0; i<WIDTH; i++){
            terminal.moveCursor(i, HEIGHT-1);
            terminal.applyForegroundColor(255, 255, 255);
            terminal.putCharacter('*');
        }
        for (int i = 0; i<HEIGHT; i++){
            terminal.moveCursor(0, i);
            terminal.applyForegroundColor(255, 255, 255);
            terminal.putCharacter('*');
        }
        for (int i = 0; i<HEIGHT; i++){
            terminal.moveCursor(WIDTH-1, i);
            terminal.applyForegroundColor(255, 255, 255);
            terminal.putCharacter('*');
        }
    }

    private void GameOver() {
    }
}
