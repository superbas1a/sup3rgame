import javax.swing.JFrame;

public class Main extends JFrame {
    GamePanel gamePanel;

    public Main() {
        super("My 2D Game - World & Camera");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        gamePanel = new GamePanel();
        add(gamePanel);

        pack();
        setSize(800, 600);
        setVisible(true);

        gamePanel.requestFocusInWindow();
        gamePanel.startGame();
    }

    public static void main(String[] args) {
        new Main();
    }
}