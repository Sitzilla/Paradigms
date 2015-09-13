import javax.swing.*;
import java.awt.*;

/**
 * Created by evan on 9/13/15.
 */
public class GradePanel extends JPanel {
    String grade;

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int height = getHeight();
        int width = getWidth();

        // If grade is an 'A' then draw it on the panel with lines
        if (grade.equals("A")) {
            g.drawLine(width / 2, 0, 0, height);
            g.drawLine(width / 2, 0, width, height);
            g.drawLine(width / 4, height / 2, width * 3 / 4, height / 2);
        } else {
            g.drawString(grade, 100, 100);
        }


    }


}
