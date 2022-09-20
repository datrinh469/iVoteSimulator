package Students;

public class SingleAnswerStudent implements Student<Integer>{
    private int studentID;
    private int answer; // Answers work by having array size equal to # of answer options and each index is 0
    // for answer not selected or 1 for it is.

    /**
     * Constructor for class
     * @param studentID unique student ID in order to identify student to ensure only most recent answer counts
     */
    public SingleAnswerStudent(int studentID) {
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
     * Obtains single answer from student.
     * @param studentAnswer integer representing index of the student's answers.
     */
    public void setAnswers(Integer studentAnswer) {
            answer = studentAnswer;
    }

    /**
     * Retrieves and returns answer of the student.
     * @return integer representing index of answer.
     */
    public Integer getAnswers() {
        return answer;
    }
}
