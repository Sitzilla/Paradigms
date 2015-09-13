import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by evan on 9/12/15.
 */
public class Assignment3 {

    public static void main(String[] args) {
        createNewStudent();

    }

    public static void createNewStudent() {
        int numberOfActivities;
        int numberOfHomeworks;
        int midterm;
        String midtermGrade;
        int finalExam;
        String finalGrade;
        GradePanel panel = new GradePanel();
        JFrame application = new JFrame();

        String firstName = JOptionPane.showInputDialog("What is the student's first name?");
        String lastName = JOptionPane.showInputDialog("What is the student's last name?");
        Student student = new Student(firstName, lastName);

        try {
            numberOfActivities = Integer.parseInt(JOptionPane.showInputDialog("How many graded activities did the student have?"));
            for (int i = 0; i < numberOfActivities; i++) {
                int activity = Integer.parseInt(JOptionPane.showInputDialog("What was the student's score for activity " + (i + 1) + "?"));
                student.addGradedActivity(activity);
            }
            numberOfHomeworks = Integer.parseInt(JOptionPane.showInputDialog("How many graded homeworks did the student have?"));

            for (int i = 0; i < numberOfHomeworks; i++) {
                int homework = Integer.parseInt(JOptionPane.showInputDialog("What was the student's score for homework " + (i + 1) + "?"));
                student.addGradedHomework(homework);
            }
            midterm = Integer.parseInt(JOptionPane.showInputDialog("What was the student's score for the midterm?"));
            midtermGrade = JOptionPane.showInputDialog("What is the student's letter grade for the midterm?");
            student.setMidterm(midterm, midtermGrade);
            finalExam = Integer.parseInt(JOptionPane.showInputDialog("What was the student's score for the final?"));
            finalGrade = JOptionPane.showInputDialog("What is the student's letter grade for the final?");
            student.setFinal(finalExam, finalGrade);



        } catch (NumberFormatException e) {
            System.out.println("Invalid data entered. Exiting.");
            System.exit(0);
        }

        student.printGrade();
        panel.setGrade(student.letterGrade());
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(200, 200);
        application.setVisible(true);
    }

}
