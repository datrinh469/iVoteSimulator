package Students;

public interface Student<A> {

    /**
     * Retrieves student ID
     * @return int representing unique student ID
     */
    int getStudentID();

    /**
     * Sets the answers the student chose into their static arrays
     * @param value Is either an int for single choice questions or array of booleans for multiple answer questions
     */
    void setAnswers(A value);

    /**
     * Retrieves student's answers
     * @return int or array of booleans depending on question type
     */
    A getAnswers();
}
