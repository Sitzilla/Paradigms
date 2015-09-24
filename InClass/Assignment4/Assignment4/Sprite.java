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
    protected Image image;


    Sprite(int x, int y, String fileName) {
        this.x = x;
        this.y = y;

        try {
            // TODO NEED TO MODIFY THIS BEFORE SUBMITTING
            image = ImageIO.read(new File(fileName));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }

    }

    public void update(Graphics g, int width, int height) { }

    public static void setDest(int x, int y) {
        dest_x = x;
        dest_y = y;
    }

    public Image getImage() {
        return image;
    }

}
