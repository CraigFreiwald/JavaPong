import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

//This class is the game window
public class Window extends JFrame implements Runnable{

    Graphics2D g2;
    KL keyListener = new KL();

    public Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        g2 = (Graphics2D)this.getGraphics();
    }

    public void update(double dt) {
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
            System.out.println("User is pressing Up arrow");
        } else if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
            System.out.println("User is pressing Down arrow");
        }
    }

    @Override
    public void run() {
        double lastFrameTime = 0.0;
        while (true) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;

            update(deltaTime);

            //sleep thread to limit FPS to ~30
            try {
                Thread.sleep(30);
            } catch (Exception e) {
                
            }
        }

    }
}
