import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean up, down, left, right, shift; // Добавили shift

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();

        if (k == KeyEvent.VK_W) up = true;
        if (k == KeyEvent.VK_S) down = true;
        if (k == KeyEvent.VK_A) left = true;
        if (k == KeyEvent.VK_D) right = true;
        if (k == KeyEvent.VK_SHIFT) shift = true; // Фиксируем нажатие Shift
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();

        if (k == KeyEvent.VK_W) up = false;
        if (k == KeyEvent.VK_S) down = false;
        if (k == KeyEvent.VK_A) left = false;
        if (k == KeyEvent.VK_D) right = false;
        if (k == KeyEvent.VK_SHIFT) shift = false; // Фиксируем отпускание Shift
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Обязательно должен быть, даже если пустой
    }
}