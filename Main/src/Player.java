import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Player {

    int x, y;
    int width = 40;
    int height = 40;

    int normalSpeed = 2;
    int sprintSpeed = 5;

    KeyHandler keyHandler;
    ArrayList<Wall> walls;

    public Player(int x, int y, KeyHandler keyHandler, ArrayList<Wall> walls) {
        this.x = x;
        this.y = y;
        this.keyHandler = keyHandler;
        this.walls = walls;
    }

    public void update() {

        int currentSpeed;
        if (keyHandler.shift) {
            currentSpeed = sprintSpeed;
        } else {
            currentSpeed = normalSpeed;
        }

        int nextX = x;
        int nextY = y;

        if (keyHandler.up) nextY -= currentSpeed;
        if (keyHandler.down) nextY += currentSpeed;
        if (keyHandler.left) nextX -= currentSpeed;
        if (keyHandler.right) nextX += currentSpeed;

        // Проверка столкновений
        Rectangle nextBounds = new Rectangle(nextX, nextY, width, height);
        boolean canMove = true;

        for (Wall w : walls) {
            if (nextBounds.intersects(w.getBounds())) {
                canMove = false;
                break;
            }
        }

        if (canMove) {
            x = nextX;
            y = nextY;
        }

        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x > 800 - width) x = 800 - width;
        if (y > 600 - height) y = 600 - height;
    }

    public void draw(Graphics g) {

        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);


        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }
}