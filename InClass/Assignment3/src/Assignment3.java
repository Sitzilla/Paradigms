import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * Created by evan on 9/12/15.
 */
public class Assignment3 {

    public static void main(String[] args) {
        createNewStudent();

    }

    public static void createNewStudent() {
        String firstName = JOptionPane.showInputDialog("What is the student's first name?");
        String lastName = JOptionPane.showInputDialog("What is the student's last name?");
        try {
            int numberOfActivities = Integer.parseInt(JOptionPane.showInputDialog("How many graded activities did the student have?"));
            ArrayList<Integer> activities = new ArrayList<>();
            for (int i = 0; i < numberOfActivities; i++) {
                int activity = Integer.parseInt(JOptionPane.showInputDialog("What was the student's score for activity " + (i + 1) + "?"));
                activities.add(activity);
            }
            int numberOfHomeworks = Integer.parseInt(JOptionPane.showInputDialog("How many graded homeworks did the student have?"));
            ArrayList<Integer> homeworks = new ArrayList<>();
            for (int i = 0; i < numberOfHomeworks; i++) {
                int homework = Integer.parseInt(JOptionPane.showInputDialog("What was the student's score for homework " + (i + 1) + "?"));
                homeworks.add(homework);
            }
            int midterm = Integer.parseInt(JOptionPane.showInputDialog("What was the student's score for the midterm?"));
            String midtermGrade = JOptionPane.showInputDialog("What is the student's letter grade for the midterm?");
            int finalExam = Integer.parseInt(JOptionPane.showInputDialog("What was the student's score for the final?"));
            String finalGrade = JOptionPane.showInputDialog("What is the student's letter grade for the final?");



        } catch (NumberFormatException e) {
            System.out.println("Please enter in an integer.");
            System.exit(0);
        }


    }

}
