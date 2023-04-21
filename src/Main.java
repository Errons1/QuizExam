import dto.MultiQuiz;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Jdbc jdbc = new Jdbc();
        jdbc.populateDB();

        Program program = new Program();
        program.start();

    }
}
