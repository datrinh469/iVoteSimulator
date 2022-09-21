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
     * @param listOfAnswersLength int that holds the length of the list of answers array.
     */
    public VotingService(boolean multiAnswerAllowed, int listOfAnswersLength) {
        answersAndNumOfVotes = new int[listOfAnswersLength];
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
        studentsAnswer.removeIf(student -> student.getKey() == studentID);

        temp = new Pair<>(studentID, answer);
        // Adds new pair to list.
        studentsAnswer.add(temp);
    }

    /**
     * Counts the votes of each answer. Chooses proper ArrayList to use based on whether multiple answers are allowed.
     * @return int array containing number of votes for each answer whose indices correlate with index of questions
     * array.
     */
    public void compileAnswers() {
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
    }

    /**
     * Displays the answer options with how many students selecting that answer.
     * @param answerOptions String array containing all the answer choices.
     */
    public void displayAnswers(String[] answerOptions) {
        for(int i = 0; i < answerOptions.length; i++)
            System.out.printf("%-20s: " + answersAndNumOfVotes[i] + "\n", answerOptions[i]);
    }

    /**
     * Displays all the unique student IDs that submitted their answers
     */
    public void displayStudentIDs() {
        if(multiAnswerAllowed) {
            for (Pair<Integer, boolean[]> student:studentsAnswers)
                System.out.println(student.getKey());
        }
        else {
            for (Pair<Integer, Integer> student:studentsAnswer)
                System.out.printf("%09d\n",student.getKey());
        }
    }
}
