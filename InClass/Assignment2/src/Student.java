/**
 * Created by evan on 9/3/15.
 */
public class Student {
    private String firstName;
    private String lastName;
    private Exam midterm;
    private Exam finalExam;
    private Coursework homework;
    private Coursework inClassWork;

    Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setMidterm(int score, String grade) {
        midterm.setScore(score);
        midterm.setLetterGrade(grade);
    }

    public void setFinal(int score, String grade) {
        finalExam.setScore(score);
        finalExam.setLetterGrade(grade);
    }

    public void addGradedHomework(int score) {
        homework.addScore(score);
    }

    public void addGradedActivity(int score) {
        inClassWork.addScore(score);
    }

    public void printGrade() {
        double numberGrade = calculateNumberGrade();
        String letterGrade = calculateLetterGrate(numberGrade);

        System.out.println("Final course grade for " +
                            firstName + " " + lastName + ": " +
                            letterGrade + ", " + numberGrade);

    }

    private double calculateNumberGrade() {
        return (.15 * inClassWork.averageScores()) +
                (.25 * homework.averageScores()) +
                (.25 * midterm.getScore()) +
                (.35 * finalExam.getScore());
    }

    private String calculateLetterGrate(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80 && grade < 90) {
            return "B";
        } else if (grade >= 70 && grade < 80) {
            return "C";
        } else if (grade >= 60 && grade < 70) {
            return "D";
        } else {
            return "F";
        }
    }

}
