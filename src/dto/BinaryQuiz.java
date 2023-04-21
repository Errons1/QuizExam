package dto;

public class BinaryQuiz extends Quiz{

    public BinaryQuiz() {
    }

    public BinaryQuiz(String question, int solution) {
        super(question, solution);
    }

    @Override
    public void printQuestion() {

    }

    @Override
    public boolean checkAnswer(int answer) {
        return true;
    }

}
