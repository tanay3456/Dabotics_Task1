package SnakeGame.src;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int UNIT_SIZE = 20;
    @SuppressWarnings("unused")
    private static final int GAME_UNITS = (WIDTH * HEIGHT) / UNIT_SIZE;
    private static final int DELAY = 75;
    public static char direction;

    private Thread thread;
    private boolean running;
    private Snake snake;
    private Food food;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new GameKeyListener());
        startGame();
    }

    public void startGame() {
        running = true;
        snake = new Snake();
        food = new Food(WIDTH, HEIGHT);
        thread = new Thread(this);
        thread.start();
    }

    public void stopGame() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkCollision() {
        if (snake.headIntersectsBody() || snake.headIntersectsWall(WIDTH, HEIGHT)) {
            stopGame();
        } else if (snake.headIntersectsFood(food)) {
            snake.grow();
            food.spawn(WIDTH, HEIGHT);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g);
        food.draw(g);
    }

    @Override
    public void run() {
        while (running) {
            snake.move();
            checkCollision();
            repaint();
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
