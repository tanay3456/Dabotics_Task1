package SnakeGame.src;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKeyListener extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                if (GamePanel.direction != 'D') {
                    GamePanel.direction = 'U';
                }
                break;
            case KeyEvent.VK_DOWN:
                if (GamePanel.direction != 'U') {
                    GamePanel.direction = 'D';
                }
                break;
            case KeyEvent.VK_LEFT:
                if (GamePanel.direction != 'R') {
                    GamePanel.direction = 'L';
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (GamePanel.direction != 'L') {
                    GamePanel.direction = 'R';
                }
                break;
        }
    }
}
