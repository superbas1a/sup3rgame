import javax.swing.JFrame;

public class Main extends JFrame {

    GamePanel gamePanel;

    public Main() {
        super("My 2D Game");

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        gamePanel = new GamePanel();
        gamePanel.setBounds(0, 0, 800, 600);
        add(gamePanel);

        setVisible(true);

        gamePanel.requestFocusInWindow(); // ВАЖНО
        gamePanel.startGame();
    }

    public static void main(String[] args) {
        new Main();
    }
}