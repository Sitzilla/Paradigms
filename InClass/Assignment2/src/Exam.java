import java.util.ArrayList;

/**
 * Created by evan on 9/3/15.
 */
public class Exam {
    private int score;
    private String letterGrade;

    Exam(int score, String letterGrade) {
        this.score = checkScore(score);
        this.letterGrade = letterGrade;
    }

    private int checkScore(int score) {
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
        System.out.println("Invalid grade entered... defaulting to 'F'");
        return "F";
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }
}
