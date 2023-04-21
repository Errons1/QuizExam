package dto;

abstract public class Quiz {

    String question;

    int solution;

    public Quiz() {
    }

    public Quiz(String question, int solution) {
        this.question = question;
        this.solution = solution;
    }

    public void example() {
        System.out.println("Example!");
    }

    abstract public void printQuestion();

    abstract public boolean checkAnswer(int answer);


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }
}
