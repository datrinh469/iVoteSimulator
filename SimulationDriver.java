import java.util.Arrays;
import java.util.Random;
import Students.*;

public class SimulationDriver {
    private static String[] questionsList = {"What is the capital of _________?", "Select all that are true.",
            "Which Arknights character is the best waifu?"};
    private static String[][] freeAnswersList = {{"Right", "Wrong"}, {"True", "False"}};
    private static Random random = new Random();

    public static void main(String[] args) {
        Question question = new Question();
        question.setQuestion(questionsList[random.nextInt(questionsList.length)]);
        if(random.nextInt(2) == 1) {
            question.setAnswers(random.nextInt(24)+1);
        }
        else {
            question.setAnswers(freeAnswersList[random.nextInt(freeAnswersList.length)]);
        }
        System.out.println(question.getQuestion());
        System.out.println(Arrays.toString(question.getAnswers()));
    }
}
