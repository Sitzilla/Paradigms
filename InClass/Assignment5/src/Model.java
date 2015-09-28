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

            // TODO dont think this is hitting properly
            for (Sprite otherSprite : sprites) {
                if (sprite.overlaps(otherSprite)) {
                    if (sprite instanceof Razorback && otherSprite instanceof Opponent) {
                        otherSprite.hit();
                    }
                }

            }

        }
        } catch (ConcurrentModificationException e) {

        }
    }
}
