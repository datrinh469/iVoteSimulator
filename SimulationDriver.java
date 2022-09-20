import java.util.Arrays;

public class SimulationDriver {
    private static String[][] freeAnswersList = {{"Right", "Wrong"}, {"True", "False"}};
    public static void main(String[] args) {
        Question question = new Question();
        question.setAnswers(freeAnswersList[1]);
        System.out.println(Arrays.toString(question.getAnswers()));

        Student student = new Student(321438292);
        student.setAnswers(false, new int[]{0, 1, 1, 1, 0, 1, 0});
        System.out.print("Student ID: " + student.getStudentID() + "\nAnswer: ");
        int[] temp = student.getAnswers();
        for(int i = 0; i < temp.length; i++)
            System.out.print(temp[i] + " ");
        System.out.println();
    }
}
