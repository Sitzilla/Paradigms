import java.util.ArrayList;

/**
 * Created by evan on 9/3/15.
 */
public class Exam {
    private double score;
    private String letterGrade;

    double checkScore(double score) {
        if (score >=0 && score <= 100) {
            return score;
        } else if (score > 0) {
            return 100;
        } else return 0;
    }

    private String checkLetterGrade(String letterGrade) {
        ArrayList <String> legalGrades = new ArrayList<String>();
        legalGrades.add("A");
        legalGrades.add("B");
        legalGrades.add("C");
        legalGrades.add("D");
        legalGrades.add("F");

        if (legalGrades.contains(letterGrade)) { return letterGrade; }
        System.out.println("You have submitted a bad grade for an Exam, value of:" + letterGrade + ".");
        return "F";
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        score = checkScore(score);
        this.score = score;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        letterGrade = checkLetterGrade(letterGrade);
        this.letterGrade = letterGrade;
    }
}
