package SnakeGame.src;

import java.awt.*;
import java.util.Random;

public class Food {
    private Point position;

    public Food(int width, int height) {
        spawn(width, height);
    }

    public void spawn(int width, int height) {
        Random rand = new Random();
        int x = rand.nextInt(width / 20) * 20;
        int y = rand.nextInt(height / 20) * 20;
        position = new Point(x, y);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(position.x, position.y, 20, 20);
    }

    public Point getPosition() {
        return position;
    }
}
