package Students;

public class MultiAnswerStudent implements Student<boolean[]>{
    private int studentID;
    private boolean[] answers; // Answers work by having array size equal to # of answer options and each index is 0
                                // for answer not selected or 1 for it is.

    /**
     * Constructor for class
     * @param studentID unique student ID in order to identify student to ensure only most recent answer counts
     */
    public MultiAnswerStudent(int studentID) {
        this.studentID = studentID;
    }

    /**
     * Public method that grabs student's ID
     * @return Integer that is student ID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Obtains array of student's answers.
     * @param studentAnswers Integer array containing the student's answers.
     */
    public void setAnswers(boolean[] studentAnswers) {
        answers = new boolean[studentAnswers.length];
        System.arraycopy(studentAnswers, 0, answers, 0, answers.length);
    }

    /**
     * Retrieves and returns array of answer of the student.
     * @return Integer array of answer(s).
     */
    public boolean[] getAnswers() {
        return answers;
    }
}
