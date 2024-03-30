package SnakeGame.src;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Point> body;
    private int length;
    private char direction;

    public Snake() {
        body = new ArrayList<>();
        body.add(new Point(100, 100));
        body.add(new Point(80, 100));
        body.add(new Point(60, 100));
        length = 3;
        direction = 'R';
    }

    public void draw(Graphics g) {
        for (Point point : body) {
            g.setColor(Color.GREEN);
            g.fillRect(point.x, point.y, 20, 20);
            g.setColor(Color.BLACK);
            g.drawRect(point.x, point.y, 20, 20);
        }
    }

    public void move() {
        Point newHead = new Point(body.get(0).x, body.get(0).y);

        switch (direction) {
            case 'U':
                newHead.y -= 20;
                break;
            case 'D':
                newHead.y += 20;
                break;
            case 'L':
                newHead.x -= 20;
                break;
            case 'R':
                newHead.x += 20;
                break;
        }

        body.add(0, newHead);
        body.remove(body.size() - 1);
    }

    public boolean headIntersectsBody() {
        Point head = body.get(0);
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean headIntersectsWall(int width, int height) {
        Point head = body.get(0);
        return head.x < 0 || head.y < 0 || head.x >= width || head.y >= height;
    }

    public boolean headIntersectsFood(Food food) {
        Point head = body.get(0);
        return head.equals(food.getPosition());
    }

    public void grow() {
        length++;
        body.add(new Point(body.get(length - 2)));
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }
}
