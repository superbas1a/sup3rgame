import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class GamePanel extends JPanel implements Runnable {

    Thread gameThread;
    boolean running = false;

    Player player;
    KeyHandler keyHandler;

    public GamePanel() {
        setBackground(Color.BLACK);
        setFocusable(true);

        keyHandler = new KeyHandler();
        addKeyListener(keyHandler);

        player = new Player(100, 100, keyHandler);
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

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateGame() {
        player.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
    }
}