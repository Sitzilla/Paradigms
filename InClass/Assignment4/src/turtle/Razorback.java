package turtle;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by evan on 9/18/15.
 */

public class Razorback extends Sprite {
    private final int xSlope;
    private final int ySlope;
    private int width;
    private int height;

    Razorback(int x, int y, int width, int height) {
        super(x, y, "razorback.png");
        xSlope = generateRandomSlope();
        ySlope = generateRandomSlope();
        this.width = width;
        this.height = height;
        image = getImage();
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setX(int xIn) { x = xIn; }
    public void setY(int yIn) { y = yIn; }

    // Checks to make sure that slope cannot be zero, range -5 to 5
    public int generateRandomSlope() {
        int slope = 0;
        while (slope == 0) {
            slope = ThreadLocalRandom.current().nextInt(-5, 5 + 1);
        }
        return slope;
    }

    @Override
    public void update(Graphics g, int width, int height) {
        x += xSlope;
        y += ySlope;

        // If x or y get to the end of the screen then regenerate razorback at the other end
        if (xSlope > 0) {
            if (x > width) {
                x = 0;
            }
        } else {
            if (x < 0) {
                x = width;
            }
        }

        if (ySlope > 0) {
            if (y > height) {
                y = 0;
            }
        } else {
            if (y < 0) {
                y = height;
            }
        }

        // Draw the razorback
        g.drawImage(image, x, y, 100, 100, null);
    }
}
