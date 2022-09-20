import java.util.HashSet;
import java.util.Set;

public class Student {
    private int studentID;
    private Integer[] answers;

    /**
     * Constructor for class
     * @param studentID unique student ID in order to identify student to ensure only most recent answer counts
     */
    public Student(int studentID) {
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
     * Obtains array of student's answers and whether multiple answers are allowed. If not, select the most recent
     * answer (the one at the end of the array).
     * @param multiAnswerAllowed Boolean that checks if multiple answers are allowed
     * @param studentAnswers Integer array containing the student's answers.
     */
    public void setAnswers(boolean multiAnswerAllowed, int[] studentAnswers) {
        if(multiAnswerAllowed) {
            Set<Integer> hashSet = new HashSet<>();
            for (int studentAnswer : studentAnswers) {
                if (!hashSet.contains(studentAnswer))
                    hashSet.add(studentAnswer);
            }
            answers = hashSet.toArray(new Integer[0]);
        }
        else {
            answers = new int[1];
            answers[0] = studentAnswers[studentAnswers.length-1];
        }
    }

    /**
     * Retrieves and returns array of answer of the student.
     * @return Integer array of answer(s).
     */
    public int[] getAnswers() {
        for(int i = 0; i < answers.length; i++)
            answers[i]+=1;
        return answers;
    }
}
