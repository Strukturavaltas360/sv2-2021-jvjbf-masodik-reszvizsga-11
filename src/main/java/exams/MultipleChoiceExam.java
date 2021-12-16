package exams;

public class MultipleChoiceExam extends Exam {

    public MultipleChoiceExam(long studentId, String topic, int maxPoints) {
        super(studentId, topic, maxPoints);
    }

    public MultipleChoiceExam(long studentId, String topic) {
        super(studentId, topic);
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        validateActualPoints(actualPoints);
        if (actualPoints >= getMaxPoints() * 0.51) {
            examResult = ExamResult.PASSED;
        } else {
            examResult = ExamResult.NOT_PASSED;
        }
    }

    private void validateActualPoints(int actualPoints) {
        if (actualPoints>getMaxPoints() ||actualPoints <0) {
            throw new IllegalArgumentException("Points are out of bounds");
        }
    }

}
