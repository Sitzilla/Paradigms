import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 * Created by evan on 9/29/15.
 */
public class SpriteMover extends Thread implements Runnable {
    private Controller controller;
    private View view;

    SpriteMover(Controller c, View v) throws Exception {
        controller = c;
        view = v;

    }

    @Override
    public void run() {
        while (true) {

            ArrayList<Sprite> sprites = this.controller.getModel().getSpriteList();

            synchronized (sprites) {

                try {
                    for (Sprite sprite : sprites) {
                        if (sprite.shouldRemove()) {
                            sprites.remove(sprite);
                        }

                        if (sprite.isHit()) {
                            continue;
                        }

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
                    System.out.println("Errored out around thread part");
                }


                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                }
                view.repaint();
            }
        }
    }

}
