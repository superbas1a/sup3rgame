import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean up, down, left, right;

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();

        if (k == KeyEvent.VK_W) up = true;
        if (k == KeyEvent.VK_S) down = true;
        if (k == KeyEvent.VK_A) left = true;
        if (k == KeyEvent.VK_D) right = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();

        if (k == KeyEvent.VK_W) up = false;
        if (k == KeyEvent.VK_S) down = false;
        if (k == KeyEvent.VK_A) left = false;
        if (k == KeyEvent.VK_D) right = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // обязательно должен быть, даже если пустой
    }
}