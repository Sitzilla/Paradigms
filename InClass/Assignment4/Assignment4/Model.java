import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

class Model {
    private ArrayList<Sprite> sprites;
    private int numberOfSprites = 0;



    Model() throws IOException {
        sprites = new ArrayList<>();
    }

    public void createTurtle(int width, int height) {
        int randomWidth = ThreadLocalRandom.current().nextInt(1, width + 1);
        int randomHeight = ThreadLocalRandom.current().nextInt(1, height + 1);

        Turtle turtle = new Turtle(randomWidth, randomHeight);
        sprites.add(turtle);
    }


    private void createRazorback(int x, int y, int width, int height) {
        Razorback razorback = new Razorback(x, y, width, height);
        sprites.add(razorback);
    }

    public void update(Graphics g, int width, int height) {
        for (Sprite sprite : sprites) {
            sprite.update(g, width, height);
        }
    }

    public void setDestination(int x, int y, int width, int height) {
        if (numberOfSprites % 2 == 0) {
            createTurtle(width, height);
        } else {
            createRazorback(x, y, width, height);
        }

        numberOfSprites++;

        for (Sprite sprite : sprites) {
            sprite.setDest(x, y);
        }
    }
}
