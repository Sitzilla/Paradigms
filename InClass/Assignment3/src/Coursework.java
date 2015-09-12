import java.util.ArrayList;

/**
 * Created by evan on 9/3/15.
 */
public class Coursework {
    ArrayList <Double> scores = new ArrayList<Double>();
    private int numberOfScores;

    public double averageScores() {
        double total = 0;

        if (numberOfScores == 0) { return 0; }

        for (Double score : scores) {
            total += score;
        }

        return total / numberOfScores;
    }

    public void addScore(double score) {
        Exam exam = new Exam();
        score = exam.checkScore(score);
        scores.add(score);
        numberOfScores++;
    }
}
