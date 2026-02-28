import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList; // Добавили импорт списка

public class GamePanel extends JPanel implements Runnable {

    Thread gameThread;
    boolean running = false;

    Player player;
    KeyHandler keyHandler;
    ArrayList<Wall> walls; // Теперь здесь много стен

    public GamePanel() {
        setBackground(Color.BLACK);
        setFocusable(true);

        keyHandler = new KeyHandler();
        addKeyListener(keyHandler);

        // Создаем список и добавляем стены (X, Y, Ширина, Высота)
        walls = new ArrayList<>();
        walls.add(new Wall(300, 200, 50, 150)); // Вертикальная стена
        walls.add(new Wall(100, 400, 200, 40)); // Горизонтальная стена
        walls.add(new Wall(500, 100, 40, 300)); // Еще одна стена

        // Передаем весь список стен игроку
        player = new Player(100, 100, keyHandler, walls);
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

        // Рисуем каждую стену из списка
        for (Wall w : walls) {
            w.draw(g);
        }

        player.draw(g);
    }
}