import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 700;
    private static final int WINDOW_POSY = 150;

    JButton start = new JButton("New game");
    JButton exit = new JButton("Exit");


    GameWindow() {
        setTitle("TicTacToe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        Map map = new Map();

        add(map,BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.add(start);
        bottomPanel.add(exit);
        add(bottomPanel, BorderLayout.SOUTH);

        setResizable(false);
        setVisible(true);

    }
}
