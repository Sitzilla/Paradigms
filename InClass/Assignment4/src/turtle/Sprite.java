package turtle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by evan on 9/18/15.
 */
public abstract class Sprite {

    protected int x;
    protected int y;
    protected static int dest_x;
    protected static int dest_y;
    private String fileName;
    protected Image image;


    Sprite(int positionX, int positionY) {
        this.x = positionX;
        this.y = positionY;

        try {
            // TODO NEED TO MODIFY THIS BEFORE SUBMITTING
            image = ImageIO.read(new File("/Users/evan/workspace/Paradigms/InClass/Assignment4/src/turtle/turtle.png"));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }

    }

    public void update(Graphics g) { }

    public static void setDest(int x, int y) {
        dest_x = x;
        dest_y = y;
    }

    public Image getImage() {
        return image;
    }

}
