import java.awt.*;
//this class creates rectangle objects for use in the game (paddles and balls)
public class Rect {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color color;

    public Rect(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    //this method draws the rectangle on the screen
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(x, y, width, height);
    }
}
