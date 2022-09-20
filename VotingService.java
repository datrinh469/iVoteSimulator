import javafx.util.Pair;
import java.util.ArrayList;

public class VotingService {
    private ArrayList<Pair<Integer, boolean[]>> studentsAnswers;
    private ArrayList<Pair<Integer, Integer>> studentsAnswer;
    private int[] answersAndNumOfVotes;
    private boolean multiAnswerAllowed;

    /**
     * Constructor for class, chooses between two ArrayLists depending on whether multiple answers are allowed
     * @param multiAnswerAllowed Boolean that checks if multiple answers will be allowed.
     * @param listOfAnswers String array that contains all the answer options.
     */
    public VotingService(boolean multiAnswerAllowed, String[] listOfAnswers) {
        answersAndNumOfVotes = new int[listOfAnswers.length];
        this.multiAnswerAllowed = multiAnswerAllowed;

        if(multiAnswerAllowed)
            studentsAnswers = new ArrayList<>();
        else
            studentsAnswer = new ArrayList<>();
    }

    /**
     * Receives student submission and adds it to list of students who've answered.
     * @param studentID Unique ID of student to check if they've answered already.
     * @param answers boolean array containing student's answers.
     */
    public void studentSubmission(int studentID, boolean[] answers) {
        Pair<Integer, boolean[]> temp;

        // If the student already answered, remove the old pair from the array list.
        studentsAnswers.removeIf(student -> student.getKey() == studentID);

        // Adds new pair to list.
        temp = new Pair<>(studentID, answers);
        studentsAnswers.add(temp);
    }

    /**
     * Receives student submission and adds it to list of students who've answered.
     * @param studentID Unique ID of student to check if they've answered already.
     * @param answer int containing student's answer.
     */
    public void studentSubmission(int studentID, int answer) {
        Pair<Integer, Integer> temp;

        // If the student already answered, remove the old pair from the array list.
        studentsAnswers.removeIf(student -> student.getKey() == studentID);

        temp = new Pair<>(studentID, answer);
        // Adds new pair to list.
        studentsAnswer.add(temp);
    }

    /**
     * Counts the votes of each answer. Chooses proper ArrayList to use based on whether multiple answers are allowed.
     * @return int array containing number of votes for each answer whose indices correlate with index of questions
     * array.
     */
    public int[] compileAnswers() {
        if(multiAnswerAllowed) {
            for (Pair<Integer, boolean[]> student : studentsAnswers) {
                boolean[] answers = student.getValue();
                for (int i = 0; i < answers.length; i++) {
                    if(answers[i])
                        answersAndNumOfVotes[i]++;
                }
            }
        }
        else {
            for (Pair<Integer, Integer> student : studentsAnswer) {
                answersAndNumOfVotes[student.getValue()]++;
            }
        }
        return answersAndNumOfVotes;
    }
}
