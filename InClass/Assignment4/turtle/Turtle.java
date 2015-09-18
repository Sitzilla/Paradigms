import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class Turtle
{
    private int x;
    private int y;
    private int dest_x;
    private int dest_y;
    private Image image;
    
    Turtle() {
        try {
            image = ImageIO.read(new File("turtle.png"));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
    }
    
    public int getX() { return x; }
    public int getY() { return y; }

    public void setX(int xIn) { x = xIn; }
    public void setY(int yIn) { y = yIn; }

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

    public void setDest(int x, int y) {
        dest_x = x;
        dest_y = y;
    }
}