import java.time.LocalDateTime;

class LateSubmissionException extends Exception {
    public LateSubmissionException(String message) {
        super(message);
    }
}

class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String message) {
        super(message);
    }
}

class OnlineExam {
    private LocalDateTime deadline = LocalDateTime.of(2025, 11, 2, 18, 0);

    public void submitExam(String fileName, LocalDateTime submissionTime)
            throws LateSubmissionException, InvalidFileFormatException {

        if (!fileName.endsWith(".pdf")) {
            throw new InvalidFileFormatException("Submission failed: invalid file format. Only .pdf allowed.");
        }

        if (submissionTime.isAfter(deadline)) {
            throw new LateSubmissionException("Submission failed: late submission. Deadline was " + deadline + ".");
        }

        System.out.println("Exam submitted successfully: " + fileName);
    }
}

public class OnlineExamSubmission {
    public static void main(String[] args) {
        OnlineExam exam = new OnlineExam();

        try {
            exam.submitExam("AnswerSheet.pdf", LocalDateTime.of(2025, 11, 2, 17, 30));
        } catch (LateSubmissionException e) {
            System.out.println(e.getMessage());
        } catch (InvalidFileFormatException e) {
            System.out.println(e.getMessage());
        }

        try {
            exam.submitExam("Notes.docx", LocalDateTime.of(2025, 11, 2, 16, 45));
        } catch (LateSubmissionException e) {
            System.out.println(e.getMessage());
        } catch (InvalidFileFormatException e) {
            System.out.println(e.getMessage());
        }

        try {
            exam.submitExam("FinalExam.pdf", LocalDateTime.of(2025, 11, 2, 19, 0));
        } catch (LateSubmissionException e) {
            System.out.println(e.getMessage());
        } catch (InvalidFileFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
