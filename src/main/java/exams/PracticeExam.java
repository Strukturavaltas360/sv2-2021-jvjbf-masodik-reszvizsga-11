package exams;

import java.util.List;

public class PracticeExam extends Exam {
    public PracticeExam(long studentId, String topic, List<Integer> points) {
        super(studentId, topic);
        super.setMaxPoints(sumPoints(points));
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        examResult = ExamResult.OK;
        if (actualPoints < getMaxPoints()* 0.51) {
            examResult = ExamResult.NOT_PASSED;
        }
        if (actualPoints >= getMaxPoints()* 0.76) {
            examResult = ExamResult.PERFECT;
        }
    }

    private int sumPoints(List<Integer> points) {
        int sum = 0;
        for (Integer p : points) {
            sum += p;
        }
        validateSum(sum);
        return sum;
    }

    private void validateSum(int sum) {
        if (sum < 10 || sum > 150) {
            throw new IllegalArgumentException("Maximum points should be between 10 and 150! Actual:" + sum);
        }
    }
}
