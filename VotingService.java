import javafx.util.Pair;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class VotingService {
    private ArrayList<Pair<Integer, Integer[]>> studentsAnswers;
    private Pair<String, Integer>[] answersAndNumOfVotes;
    private boolean multiAnsweredAllowed;

    /**
     * Constructor for class
     * @param multiAnswerAllowed Boolean that checks if multiple answers will be allowed.
     * @param listOfAnswers String array that contains all the answer options.
     */
    public VotingService(boolean multiAnswerAllowed, String[] listOfAnswers) {
        studentsAnswers = new ArrayList();
        answersAndNumOfVotes = new Pair[listOfAnswers.length];
        this.multiAnsweredAllowed = multiAnswerAllowed;

        for(int i = 0; i < listOfAnswers.length; i++) {
            answersAndNumOfVotes[i] = new Pair<>(listOfAnswers[i], 0);
        }
    }

    /**
     * Receives student submission and adds it to list of students who've answered.
     * @param studentID Unique ID of student to check if they've answered already.
     * @param answers Integer array containing student's answers.
     */
    public void studentSubmission(int studentID, int[] answers) {
        Pair<Integer, Integer[]> temp;

        // If the student already answered, remove the old pair from the array list.
        studentsAnswers.removeIf(student -> student.getKey() == studentID);

        // If multiple answers are allowed, create new pair containing student ID and the array of their answers,
        // else, array of their answer contains a single element.
        if (multiAnsweredAllowed)
            temp = new Pair<>(studentID, IntStream.of(answers).boxed().toArray(Integer[]::new));
        else
            temp = new Pair<>(studentID, IntStream.of(answers[answers.length-1]).boxed().toArray(Integer[]::new));
        // Adds new pair to list.
        studentsAnswers.add(temp);
    }

    public Pair<String, Integer>[] compileAnswers() {
        for (Pair<Integer, Integer[]> student: studentsAnswers) {
            Integer[] answers = student.getValue();
            for(int i = 0; i < answers.length; i++) {

            }
        }
        return answersAndNumOfVotes;
    }
}
