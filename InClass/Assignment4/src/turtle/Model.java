package turtle;


import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Model
{
    private ArrayList<Sprite> turtles;
    private static int numberOfTurtles = 0;



    Model() throws IOException {
        turtles = new ArrayList<>();
    }

    public void createTurtle(int width, int height) {
        int randomWidth = ThreadLocalRandom.current().nextInt(1, width + 1);
        int randomHeight = ThreadLocalRandom.current().nextInt(1, height + 1);

        Turtle turtle = new Turtle(randomWidth, randomHeight);
        turtles.add(turtle);
    }

    public void update(Graphics g) {
        for (Sprite turtle : turtles) {
            turtle.update(g);
        }
    }

    public void setDestination(int x, int y, int width, int height) {
        createTurtle(width, height);
        for (Sprite turtle : turtles) {
            turtle.setDest(x, y);
        }
    }
}
