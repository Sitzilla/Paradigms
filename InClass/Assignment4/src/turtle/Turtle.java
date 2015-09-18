package turtle;

import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class Turtle extends Sprite {
    Turtle(int x, int y) {
        super(x, y, "turtle.png");
        image = getImage();
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setX(int xIn) { x = xIn; }
    public void setY(int yIn) { y = yIn; }

    @Override
    public void update(Graphics g, int width, int height) {
        // Move the turtle
        if (x < dest_x) {
            x += 1;
        } else if (x > dest_x) {
            x -= 1;
        }

        if (y < dest_y) {
            y += 1;
        } else if (y > dest_y) {
            y -= 1;
        }

        // Draw the turtle
        g.drawImage(image, x, y, 125, 125, null);
    }
}