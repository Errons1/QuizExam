package dto;

public class MultiQuiz extends Quiz{

    String answerA;
    String answerB;
    String answerC;
    String answerD;

    public MultiQuiz() {
    }

    public MultiQuiz(String question, int solution, String answerA, String answerB, String answerC, String answerD) {
        super(question, solution);
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
    }

    @Override
    public void printQuestion() {

    }

    @Override
    public void checkAnswer() {

    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }
}
