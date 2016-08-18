import com.googlecode.lanterna.terminal.Terminal;

import static sun.audio.AudioPlayer.player;

public class Game {
    public static boolean run = true;
    private Terminal terminal;
    private Snake snake;
    private Dot dot;

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
        if ((snake.x == dot.x) && (snake.y == dot.y)){
            dot.Move();
        }

    }

    private void UpdateBoard(Terminal terminal, Snake snake, Dot dot) {
        terminal.clearScreen();
        terminal.moveCursor(snake.x, snake.y);
        terminal.applyForegroundColor(0, 204, 0);
        terminal.putCharacter('O');
        terminal.moveCursor(dot.x, dot.y);
        terminal.applyForegroundColor(200, 0, 0);
        terminal.putCharacter('O');
        DrawFrame();
        terminal.moveCursor(0,0);
    }

    private void DrawFrame() {
    }

    private void GameOver() {
    }
}
