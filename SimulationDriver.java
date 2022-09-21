import java.util.Random;
import Students.*;

public class SimulationDriver {
    //Preset array of some questions and answers.
    private static String[] questionsList = {"What is the capital of _________?", "Select all that are true.",
            "Which Arknights character is the best waifu?", "What constitutes a 'good' Sankta?",
            "What reasons are the Sarkaz persecuted?", "Reasons for Victoria's class struggles."};
    private static String[][] freeAnswersList = {{"Right", "Wrong"}, {"True", "False"}, {"dwsdainw", "example something",
    "Random gibberish", "pewpewpewpepwpew", "HK", "Umame"}, {"example1", "example2", "example3", "example4", "example5",
            "example6", "example7", "example8", "example9", "example10"}};
    private static Random random = new Random();

    /**
     * Main function that automates and runs the iVote Simulator
     * @param args
     */
    public static void main(String[] args) {
        //Creates a new question
        Question question = new Question();
        //Randomizes question and answer options
        if(random.nextInt(2) == 1) {
            question.setQuestion(questionsList[random.nextInt(questionsList.length)]);
            question.setAnswers(random.nextInt(24)+1);
        }
        else {
            question.setQuestion(("Generic Question"));
            question.setAnswers(freeAnswersList[random.nextInt(freeAnswersList.length)]);
        }

        //RNG determines if question will be single or multiple answer
        boolean multiAnswerAllowed = random.nextInt(2) == 1;
        VotingService votingService = new VotingService(multiAnswerAllowed, question.getAnswers().length);
        int numOfStudents = random.nextInt(30)+1;

        //randomly creates random number of student submissions
        for(int i = 0; i < numOfStudents; i++) {
            Student tempStudent;
            if(multiAnswerAllowed) {
                tempStudent = new MultiAnswerStudent(random.nextInt(999999999));
                boolean[] tempStudentAnswers = new boolean[question.getAnswers().length];
                for(int j = 0; j < tempStudentAnswers.length; j++)
                    tempStudentAnswers[j] = random.nextInt(2) == 1;
                tempStudent.setAnswers(tempStudentAnswers);
                votingService.studentSubmission(tempStudent.getStudentID(), (boolean[]) tempStudent.getAnswers());
            }
            else {
                tempStudent = new SingleAnswerStudent(random.nextInt(999999999));
                tempStudent.setAnswers(random.nextInt(question.getAnswers().length));
                votingService.studentSubmission(tempStudent.getStudentID(), (int) tempStudent.getAnswers());
            }
        }

        //Compiles all the answers for voting
        votingService.compileAnswers();

        //Prints out results
        if(multiAnswerAllowed)
            System.out.println("This question allows multiple answers to be selected.");
        else
            System.out.println("This question allows only one answer to be selected.");
        System.out.println(question.getQuestion());
        votingService.displayAnswers(question.getAnswers());
        System.out.println("There were " + numOfStudents + " submissions. (Some may be repeat submissions)");
        System.out.println("The following student IDs are the ones who submitted:");
        votingService.displayStudentIDs();
    }
}
