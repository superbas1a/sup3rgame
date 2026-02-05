import java.awt.Graphics;
import java.awt.Color;

public class Player {

    int x;
    int y;
    int speed = 4;

    KeyHandler keyHandler;

    public Player(int x, int y, KeyHandler keyHandler) {
        this.x = x;
        this.y = y;
        this.keyHandler = keyHandler;
    }

    public void update() {
        if (keyHandler.up) y -= speed;
        if (keyHandler.down) y += speed;
        if (keyHandler.left) x -= speed;
        if (keyHandler.right) x += speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 40, 40);
    }
}