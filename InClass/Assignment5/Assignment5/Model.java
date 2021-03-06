import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Random;

class Model
{
    private ArrayList<Sprite> sprites;
    private int width;
    private int height;
    Random r;

    Model(int w, int h) throws IOException {
        sprites = new ArrayList<Sprite>();
        width = w;
        height = h;
        r = new Random();
        initialize();
    }
    
    public ArrayList<Sprite> getSpriteList() { return sprites; }
    
    public void initialize() {

        // clears out any sprites if any exist
        sprites.clear();

        for (int i=0; i<50; i++) {
            int newX = r.nextInt(width-50);
            int newY = r.nextInt(height-50);
            if (i%2==0) {
                sprites.add(new Razorback(newX, newY, width, height));
            } else {
                sprites.add(new Opponent(newX, newY, width, height));
            }
        }
        System.out.println("Done");
    }

    public void update(Graphics g) {
        for (Sprite sprite : sprites) {
                sprite.update(g);
        }
    }

    public void forward() {
        try {
            for (Sprite sprite : sprites) {
                if (sprite.shouldRemove()) {
                    sprites.remove(sprite);
                }

                if (sprite.isHit()) {
                    continue; }

                sprite.move();

                // check if there are overlap between two sprites of different types. if so set otherSprite to hit
                for (Sprite otherSprite : sprites) {
                    if (sprite instanceof Razorback && otherSprite instanceof Opponent) {
                        if (sprite.overlaps(otherSprite)) {
                            otherSprite.hit();
                        }
                    }
                }

            }
        } catch (ConcurrentModificationException e) {

        }
    }
}
