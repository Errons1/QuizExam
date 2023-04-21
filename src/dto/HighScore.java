package dto;

public class HighScore {

    private String user;
    private int score;
    private String topic;

    public HighScore() {
    }

    public HighScore(String user, int score, String topic) {
        this.user = user;
        this.score = score;
        this.topic = topic;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}
