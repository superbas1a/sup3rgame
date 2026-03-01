import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {

    Thread gameThread;
    boolean running = false;


    public final int worldWidth = 5000;
    public final int worldHeight = 5000;

    public final int screenWidth = 800;
    public final int screenHeight = 600;

    Player player;
    KeyHandler keyHandler;
    ArrayList<Wall> walls;

    public GamePanel() {
        setBackground(new Color(35, 35, 35));
        setFocusable(true);

        keyHandler = new KeyHandler();
        addKeyListener(keyHandler);

        walls = new ArrayList<>();
        Random rand = new Random();

        walls.add(new Wall(0, 0, worldWidth, 20));
        walls.add(new Wall(0, worldHeight - 20, worldWidth, 20));
        walls.add(new Wall(0, 0, 20, worldHeight));
        walls.add(new Wall(worldWidth - 20, 0, 20, worldHeight));

        for (int i = 0; i < 100; i++) {
            int w = 50 + rand.nextInt(100);
            int h = 50 + rand.nextInt(100);
            int x = rand.nextInt(worldWidth - w);
            int y = rand.nextInt(worldHeight - h);
            walls.add(new Wall(x, y, w, h));
        }

        player = new Player(worldWidth / 2, worldHeight / 2, keyHandler, walls);
    }

    public void startGame() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (running) {
            updateGame();
            repaint();
            try { Thread.sleep(16); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    public void updateGame() {
        player.update();


        if (player.x < 0) player.x = 0;
        if (player.y < 0) player.y = 0;
        if (player.x > worldWidth - player.width) player.x = worldWidth - player.width;
        if (player.y > worldHeight - player.height) player.y = worldHeight - player.height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int cameraX = player.x - screenWidth / 2 + player.width / 2;
        int cameraY = player.y - screenHeight / 2 + player.height / 2;

        g2.translate(-cameraX, -cameraY);

        for (Wall w : walls) {
            w.draw(g2);
        }
        player.draw(g2);

        g2.translate(cameraX, cameraY);

        g2.setColor(Color.WHITE);
        g2.drawString("X: " + player.x + " Y: " + player.y, 20, 30);
    }
}