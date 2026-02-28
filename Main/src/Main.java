import javax.swing.JFrame;

public class Main extends JFrame {

    GamePanel gamePanel;

    public Main() {
        super("igra");

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        gamePanel = new GamePanel();
        add(gamePanel);
        pack();
        setSize(800, 600);
        setVisible(true);

        gamePanel.requestFocusInWindow(); // ВАЖНО
        gamePanel.startGame();
    }

    public static void main(String[] args) {
        new Main();
    }
}