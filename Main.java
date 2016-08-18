import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        Snake snake = new Snake(terminal);
        Dot dot = new Dot();
        Game game = new Game(terminal, snake, dot);

        game.Run();
    }
}
