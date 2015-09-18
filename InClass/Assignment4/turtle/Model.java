import java.awt.Graphics;
import java.io.IOException;

class Model
{
    private Turtle turtle;

    Model() throws IOException {
        turtle = new Turtle();
    }

    public void update(Graphics g) {
        turtle.update(g);
    }

    public void setDestination(int x, int y, int width, int height) {
        turtle.setDest(x, y);
    }
}
