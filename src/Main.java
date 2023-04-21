import dto.BinaryQuiz;
import dto.HighScore;
import dto.MultiQuiz;
import dto.Quiz;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {

        Jdbc jdbc = new Jdbc();
        jdbc.populateDB();

        Program program = new Program();
        program.start();

    }
}
