package turtle;

import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class Turtle extends Sprite
{
//    private int x;
//    private int y;


    Turtle(int x, int y) {
        super(x, y);
        image = getImage();
//        try {
//            // TODO NEED TO MODIFY THIS BEFORE SUBMITTING
//            image = ImageIO.read(new File("/Users/evan/workspace/Paradigms/InClass/Assignment4/src/turtle/turtle.png"));
//        } catch (IOException ioe) {
//            System.out.println("Unable to load image file.");
//        }
    }
    
    public int getX() { return x; }
    public int getY() { return y; }

    public void setX(int xIn) { x = xIn; }
    public void setY(int yIn) { y = yIn; }

    @Override
    public void update(Graphics g) {
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
        g.drawImage(image, x, y, 100, 100, null);
    }
}