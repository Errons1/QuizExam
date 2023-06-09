import dto.HighScore;
import dto.MultiQuiz;

import java.sql.*;
import java.util.ArrayList;

public class Jdbc {

    public Jdbc() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    private Connection connectDB() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/QuizGame";
        String username = "root";
        String password = "root";

        return DriverManager.getConnection(url, username, password);
    }

    public void populateDB() throws SQLException {
        String sqlTruncate = """
                TRUNCATE QuizGame.multiQuiz;
                """;

        String sqlPopulateDB = """
                INSERT INTO QuizGame.multiQuiz(question, answerA, answerB, answerC, answerD, solution)
                VALUES ('What is 2 + 2?', '1. Number 3', '2. Number 2', '3. Number 7', '4. Number 5', 2);
                """;

        Connection connection = connectDB();
        PreparedStatement preparedStatement1 = connection.prepareStatement(sqlTruncate);
        PreparedStatement preparedStatement2 = connection.prepareStatement(sqlPopulateDB);
        preparedStatement1.executeUpdate();
        preparedStatement2.executeUpdate();

        preparedStatement1.close();
        preparedStatement2.close();
        connection.close();
    }

    public ArrayList<MultiQuiz> getMultiQuiz() throws SQLException {
        ArrayList<MultiQuiz> multiQuizArrayList = new ArrayList<>();
        String sqlGetMultiQuiz = """
                SELECT *
                FROM QuizGame.multiQuiz
                """;

        Connection connection = connectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlGetMultiQuiz);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String question = resultSet.getString(2);
            String answerA = resultSet.getString(3);
            String answerB = resultSet.getString(4);
            String answerC = resultSet.getString(5);
            String answerD = resultSet.getString(6);
            int solution = resultSet.getInt(7);

            MultiQuiz multiQuiz = new MultiQuiz(question, solution, answerA, answerB, answerC, answerD);
            multiQuizArrayList.add(multiQuiz);
        }

        preparedStatement.close();
        connection.close();
        return multiQuizArrayList;
    }

    public void saveUserScore(HighScore highScore) throws SQLException {
        String sqlSaveUserScore = """
                INSERT INTO QuizGame.highScore (user, score, topic)
                VALUES (?, ?, ?);
                """;

        Connection connection = connectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSaveUserScore);
        preparedStatement.setString(1, highScore.getUser());
        preparedStatement.setInt(2, highScore.getScore());
        preparedStatement.setString(3, highScore.getTopic());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    public ArrayList<HighScore> getHighscoreTable() throws SQLException {
        ArrayList<HighScore> highScores = new ArrayList<>();
        String sqlGetHighscoreTable = """
                SELECT * 
                FROM QuizGame.highScore;
                """;

        Connection connection = connectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlGetHighscoreTable);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String user = resultSet.getString(2);
            int score = resultSet.getInt(3);
            String topic = resultSet.getString(4);

            HighScore highScore = new HighScore(user, score, topic);
            highScores.add(highScore);
        }

        return highScores;
    }
}
