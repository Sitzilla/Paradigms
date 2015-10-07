import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

class Controller implements MouseListener, KeyListener
{
    private Model model;
    private View view;

    Controller() throws IOException, Exception {
        view = new View(this);
        model = new Model(view.getWidth(), view.getHeight());
    }

    public void update(Graphics g) {
        if (model != null) {
            model.update(g);
        }
    }

    public void start() throws Exception {
        SpriteMover spriteMover = new SpriteMover(this, view);
        Thread thread = new Thread(spriteMover);
        thread.start();
    }
    
    public Model getModel() { return model; }

    public void forwardSprites() {
        model.forward();
    }

    public void mousePressed(MouseEvent e) {
        model.forward();
        view.repaint();
    }
    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }


    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char letter = e.getKeyChar();

        if (letter == 'r') {
            model.initialize();
            view.repaint();
        } else if (letter == 's'){
            try {
                start();
            } catch (Exception e1) {
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


