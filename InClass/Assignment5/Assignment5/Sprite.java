import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.util.Random;

abstract class Sprite
{
    private int x;
    private int y;
    private int size;
    private int w;
    private int h;
    private int xSlope;
    private int ySlope;
    private Image image;
    private static Random rand;
    private boolean hit;
    private int counter;

    public Sprite(int xIn, int yIn, int width, int height, String imagePath, int imageSize) {
        if (rand == null) {
            rand = new Random();
        }
        size = imageSize;
        setImage(imagePath);
        x = xIn;
        y = yIn;
        w = width;
        h = height;
        hit = false;
        xSlope = rand.nextInt(11) - 5;
        ySlope = rand.nextInt(11) - 5;
        counter = 0;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getSize() { return size; }
    public void setSize(int s) { size = s; }
    public void setX(int xIn) { x = xIn; }
    public void setY(int yIn) { y = yIn; }
    
    public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File("/Users/evan/workspace/Paradigms/InClass/Assignment5/src/" + imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
    }
    public Image getImage() { return image; }
    
    public boolean overlaps(Sprite s) {
        if (this == s) { return false; }

        if (isInRange(s)) {
            return true;
        }
        return false;
    }

    // TODO need to account for size here
    public boolean isInRange(Sprite s) {
        int x1Max = x + (size / 2);
        int x1Min = x - (size / 2);
        int x2Max = s.getX() + (s.getSize() / 2);
        int x2Min = s.getX() - (s.getSize() / 2);

        int y1Max = y + (size / 2);
        int y1Min = y - (size / 2);
        int y2Max = s.getY() + (s.getSize() / 2);
        int y2Min = s.getY() - (s.getSize() / 2);

        if (((x1Max >= x2Min) && (x1Min <= x2Max)) && ((y1Max >= y2Min) && (y1Min <= y2Max))) {
            return true;
        }

        return false;
    }
    
    public void update(Graphics g) {
        if (hit == true) {
            counter++;
        }

        g.drawImage(getImage(), x, y, getSize(), getSize(), null);
    }
    
    public void move() {
        // Move the Sprite
        int x = getX() + xSlope;
        int y = getY() + ySlope;
        if (x < 0) x = w;
        if (x > w) x = 0;
        if (y < 0) y = h;
        if (y > h) y = 0;
        setX(x);
        setY(y);
    }

    public void hit() {
        setImage("gravestone.jpg");
        hit = true;
    }

    public boolean isHit(){
        return hit;
    }

    public boolean shouldRemove() {
        if (counter >= 20) {
            return true;
        }
        return false;
    }

}