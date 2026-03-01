import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class Player {

    int x, y;
    int width = 32;
    int height = 50;

    int normalSpeed = 3;
    int sprintSpeed = 6;

    KeyHandler keyHandler;
    ArrayList<Wall> walls;

    double animationCounter = 0;
    int legOffset = 0;
    String direction = "down";

    public Player(int x, int y, KeyHandler keyHandler, ArrayList<Wall> walls) {
        this.x = x;
        this.y = y;
        this.keyHandler = keyHandler;
        this.walls = walls;
    }

    public void update() {
        int currentSpeed = keyHandler.shift ? sprintSpeed : normalSpeed;
        int nextX = x;
        int nextY = y;
        boolean isMoving = false;

        if (keyHandler.up) {
            nextY -= currentSpeed;
            direction = "up";
            isMoving = true;
        }
        else if (keyHandler.down) {
            nextY += currentSpeed;
            direction = "down";
            isMoving = true;
        }

        if (keyHandler.left) {
            nextX -= currentSpeed;
            direction = "left";
            isMoving = true;
        }
        else if (keyHandler.right) {
            nextX += currentSpeed;
            direction = "right";
            isMoving = true;
        }

        if (isMoving) {
            double animSpeed = keyHandler.shift ? 0.3 : 0.15;
            animationCounter += animSpeed;
            legOffset = (int) (Math.sin(animationCounter) * 7);
        } else {
            animationCounter = 0;
            legOffset = 0;
        }


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
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.GRAY);
        if (direction.equals("up") || direction.equals("down")) {
            g2.fillRect(x + 4, y + height - 12 + legOffset, 8, 12); // левая
            g2.fillRect(x + width - 12, y + height - 12 - legOffset, 8, 12); // правая
        } else {
            g2.fillRect(x + 4 + legOffset, y + height - 10, 10, 10);
            g2.fillRect(x + width - 14 - legOffset, y + height - 10, 10, 10);
        }

        g2.setColor(new Color(50, 100, 200));
        g2.fillOval(x, y + 10, width, height - 20);

        g2.setColor(new Color(255, 220, 180));
        g2.fillOval(x + width/2 - 10, y, 20, 20);

        g2.setColor(Color.BLACK);
        switch (direction) {
            case "down":
                g2.fillRect(x + width/2 - 6, y + 8, 3, 3);
                g2.fillRect(x + width/2 + 3, y + 8, 3, 3);
                break;
            case "up":
                break;
            case "left":
                g2.fillRect(x + width/2 - 8, y + 8, 3, 3);
                break;
            case "right":
                g2.fillRect(x + width/2 + 5, y + 8, 3, 3);
                break;
        }
    }
}