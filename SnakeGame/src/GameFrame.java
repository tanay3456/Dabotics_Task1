package SnakeGame.src;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        add(new GamePanel());
        pack();
        setLocationRelativeTo(null);
    }
}
