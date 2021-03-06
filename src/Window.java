import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

//This class creates the game window and graphics
public class Window extends JFrame implements Runnable {

    public Graphics2D g2;
    public KL keyListener = new KL();
    public Rect playerOne, ai, ballRect;
    public PlayerController playerController;
    public AIController aiController;
    public Ball ball;


    public Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        Constants.TOOLBAR_HEIGHT = this.getInsets().top;
        Constants.INSETS_BOTTOM = this.getInsets().bottom;
        g2 = (Graphics2D) this.getGraphics();

        playerOne = new Rect(Constants.HZ_PADDING, 40, Constants.PADDLE_WIDTH,Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        playerController = new PlayerController(playerOne, keyListener);

        ballRect = new Rect(Constants.SCREEN_WIDTH / 2.0, Constants.SCREEN_HEIGHT / 2.0, Constants.BALL_WIDTH, 20, Constants.PADDLE_COLOR);
        ai = new Rect(Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH - Constants.HZ_PADDING, 40, Constants.PADDLE_WIDTH,Constants.PADDLE_HEIGHT,Constants.PADDLE_COLOR);
        ball = new Ball(ballRect, playerOne, ai);
        aiController = new AIController(new PlayerController(ai), ballRect);

    }

    //the purpose of this is to update the game window with the proper background
    public void update(double dt) {
        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        g2.drawImage(dbImage, 0,0,this);

        playerController.update(dt);
        aiController.update(dt);
        ball.update(dt);
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        playerOne.draw(g2);
        ai.draw(g2);
        ballRect.draw(g2);
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
       }
    }
} //end of class

