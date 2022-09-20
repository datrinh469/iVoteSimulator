public class Question {
    private String question, answers[];

    /**
     * Constructor to create Question with no question.
     */
    public Question() {
        question = null;
    }

    /**
     * Constructor to create Question with initial question
     * @param question Initial question for class Question to instantiate with
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Retrieves question of class Question
     * @return String question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the potential answers for the question.
     * @param numOfAnswers Number of possible answers. Automatically sets up answers in multiple choice, alphabetical
     *                     format i.e. 'A', 'B', 'C' etc.
     */
    public void setAnswers(int numOfAnswers) {
        answers = new String[numOfAnswers];
        char letter = 'A';
        for(int i = 0; i < numOfAnswers; i++) {
            answers[i] = String.valueOf(letter++);
        }
    }

    /**
     * Overloaded function that sets the potential answers for the question.
     * @param listOfAnswers String array containing possible answers that will show up themselves in terminal
     *                      i.e. 'True', 'False'; 'Vatican City', 'Madrid', 'Berlin'
     */
    public void setAnswers(String[] listOfAnswers) {
        answers = new String[listOfAnswers.length];
        for(int i = 0; i < answers.length; i++) {
            answers[i] = (i+1) + ". " + listOfAnswers[i];
        }
    }

    /**
     * Returns string array of all possible answers
     * @return String Array of all possible answers
     */
    public String[] getAnswers() {
        return answers;
    }
}
