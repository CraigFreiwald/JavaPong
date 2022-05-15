import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//this class is used to add key listeners in the game window
public class KL implements KeyListener{

    //128 possible keys can typically be pressed by user
    private final boolean[] keyPressed = new boolean[128];

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyPressed[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyPressed[e.getKeyCode()] = false;
    }

    public boolean isKeyPressed(int keyCode) {
        return keyPressed[keyCode];
    }
}//end of class
