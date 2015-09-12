import java.text.DecimalFormat;

/**
 * Created by evan on 9/3/15.
 */
public class Student {
    private String firstName;
    private String lastName;
    private Exam midterm = new Exam();
    private Exam finalExam = new Exam();
    private Coursework homework = new Coursework();
    private Coursework inClassWork = new Coursework();

    Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setMidterm(double score, String grade) {
        midterm.setScore(score);
        midterm.setLetterGrade(grade);
    }

    public void setFinal(double score, String grade) {
        finalExam.setScore(score);
        finalExam.setLetterGrade(grade);
    }

    public void addGradedHomework(double score) {
        homework.addScore(score);
    }

    public void addGradedActivity(double score) {
        inClassWork.addScore(score);
    }

    public void printGrade() {
        DecimalFormat df = new DecimalFormat("#.00");
        double numberGrade = calculateNumberGrade();
        String letterGrade = calculateLetterGrate(numberGrade);

        // grade adjustment per professor's specifications
        letterGrade = examWeightedAdjustment(letterGrade);

        System.out.println("Final course grade for " +
                            firstName + " " + lastName + ": " +
                            letterGrade + ", " + df.format(numberGrade) + "%");

    }

    // method to ensure that final letter grade for the class cannot be lower than an exam grade
    private String examWeightedAdjustment(String letterGrade) {
        char lowestExam;
        char weightAdjustedScore;

        lowestExam = (char) Math.max(midterm.getLetterGrade().charAt(0), finalExam.getLetterGrade().charAt(0));
        weightAdjustedScore = (char) Math.min(lowestExam, letterGrade.charAt(0));
        return String.valueOf(weightAdjustedScore);
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
