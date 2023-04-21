package dto;

public class MultiQuiz extends Quiz{

    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;

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
        System.out.println(super.question);
        System.out.println(answerA);
        System.out.println(answerB);
        System.out.println(answerC);
        System.out.println(answerD);
    }

    @Override
    public boolean checkAnswer(int answer) {
        return super.solution == answer;
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
