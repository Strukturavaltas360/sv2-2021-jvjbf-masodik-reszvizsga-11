package exams;

import java.util.ArrayList;
import java.util.List;

public class ExamDB {
    List<Exam> exams = new ArrayList<>();

    public void addExam(Exam exam, int actualPoints) {
        exam.calculateExamResult(actualPoints);
        exams.add(exam);
    }

    public int countPassedExams() {
        int count = 0;
        for (Exam exam : exams) {
            if (exam.examResult != ExamResult.NOT_PASSED)
                count++;
        }
        return count;
    }

    public List<Exam> findById(long studentId) {
        List<Exam> result = new ArrayList<>();
        for (Exam exam : exams) {
            if (exam.getStudentId() == studentId) {
                result.add(exam);
            }
        }
        return result;
    }

    public List<String> findTopicByPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        for (Exam exam : exams) {
            if (exam.getTopic().startsWith(prefix) && !result.contains(exam.getTopic())) {
                result.add(exam.getTopic());
            }
        }
        return result;
    }

    public List<Exam> getExams() {
        return new ArrayList<>(exams);
    }
}
