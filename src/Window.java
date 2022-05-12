import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

//This class creates the game window and graphics
public class Window extends JFrame implements Runnable {

    Graphics2D g2;
    KL keyListener = new KL();
    Rect playerOne, ai, ball;

    public Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        g2 = (Graphics2D) this.getGraphics();

        playerOne = new Rect(Constants.HZ_PADDING, 40, Constants.PADDLE_WIDTH,Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        ai = new Rect(Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH - Constants.HZ_PADDING, 40, Constants.PADDLE_WIDTH,Constants.PADDLE_HEIGHT,Constants.PADDLE_COLOR);
        ball = new Rect(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2, Constants.BALL_WIDTH, 20, Constants.PADDLE_COLOR);
    }

    //the purpose of this is to update the game window with the proper background
    public void update(double dt) {
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        playerOne.draw(g2);
        ai.draw(g2);
        ball.draw(g2);
    }

    //the purpose of this is to record and limit the frame rate of the game
    @Override
    public void run () {
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

