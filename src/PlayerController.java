import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController {

    public Rect rect;
    public KL keyListener;

    public PlayerController(Rect rect, KL keyListener) {
        this.rect = rect;
        this.keyListener = keyListener;
    }

    //overloaded constructor sets keyListener to null to tell if it is the AI
    public PlayerController(Rect rect) {
        this.rect = rect;
        this.keyListener = null;
    }

    //moves the players paddle up and down with boundaries check for game window
    public void update(double dt) {
        if (keyListener != null) {
            if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
                moveDown(dt);
            } else if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
                moveUp(dt);
                }
        }
    }

    public void moveUp(double dt) {
        if (rect.y - Constants.PADDLE_SPEED * dt > Constants.TOOLBAR_HEIGHT)
            this.rect.y -= Constants.PADDLE_SPEED * dt;
    }

    public void moveDown(double dt) {
        if ((rect.y + Constants.PADDLE_SPEED * dt) + rect.height < Constants.SCREEN_HEIGHT - Constants.INSETS_BOTTOM)
            this.rect.y += (Constants.PADDLE_SPEED * dt);
    }

} //end of class
