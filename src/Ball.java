//This class is used to control the ball movement params
public class Ball {
    public Rect rect;
    public Rect leftPaddle, rightPaddle;

    //velocity variable for x and y to determine speed and direction
    private double vy = 200.0;
    private double vx = -150.0;

    public Ball(Rect rect, Rect leftPaddle, Rect rightPaddle) {
        this.rect = rect;
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    //update method to control ball movement
    public void update(double dt) {

        //controls paddle hit box
        if (vx < 0) {
            if (this.rect.x <= this.leftPaddle.x + this.leftPaddle.width && this.rect.x >= this.leftPaddle.x &&
                this.rect.y >= this.leftPaddle.y && this.rect.y <= this.leftPaddle.y +
                this.leftPaddle.height) {
                this.vx *= -1;
                this.vy *= -1;
            } else if (this.rect.x + this.rect.width < this.leftPaddle.x + this.leftPaddle.width) {
                System.out.println("Player 1 lost a point!");
            }
        }else if (vx > 0) {
            if (this.rect.x + this.rect.width >= this.rightPaddle.x && this.rect.x <= this.rightPaddle.x +
                this.rightPaddle.width && this.rect.y >= this.rightPaddle.y && this.rect.y <= this.rightPaddle.y +
                this.rightPaddle.height) {
                this.vx *= -1;
                this.vy *= -1;
            } else if (this.rect.x + this.rect.width > this.rightPaddle.x + this.rightPaddle.width) {
                System.out.println("AI has lost a point!");
            }
        }

        //controls ball deflection off of top and bottom of screen
        if (vy > 0) {
            if (this.rect.y + this.rect.height > Constants.SCREEN_HEIGHT) {
                this.vy *= -1;
            }
        } else if (vy < 0) {
            if (this.rect.y < Constants.TOOLBAR_HEIGHT) {
                this.vy *= -1;
            }
        }

        //Sets velocity and acceleration

        // position = position + velocity
        this.rect.x += vx * dt;
        // velocity = velocity + acceleration
        this.rect.y += vy * dt;
    }
}
