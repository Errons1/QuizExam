import dto.HighScore;
import dto.MultiQuiz;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    private Jdbc jdbc = new Jdbc();

    public void start() throws SQLException {
        printMainMenu();
        inputMainMenu();
    }

    private void printMainMenu() {
        System.out.println("1. Multi Quiz");
        System.out.println("2. Binary Quiz");
        System.out.println("3. High-score");
        System.out.println("4. Exit application");
    }

    private void inputMainMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isRunning = true;

        while (isRunning) {
            input = scanner.nextLine();

            switch (input) {
                case "1" : {
                    startMultiQuiz();
                    printMainMenu();
                    break;
                }
                case "4" : {
                    isRunning = false;
                    System.out.println("Application exiting");
                    break;
                }
                default: {
                    System.out.println("Invalid input");
                }
            }
        }


    }

    private void startMultiQuiz() throws SQLException {
        ArrayList<MultiQuiz> quiz = jdbc.getMultiQuiz();
        Scanner scanner = new Scanner(System.in);
        boolean isAnswering = true;
        String input = "";
        int answer = 0;
        int counter = 0;
        HighScore highScore = new HighScore();

        System.out.println("You have chosen multi choice quiz");
        System.out.println("Enter your name:");
        highScore.setUser(scanner.nextLine());
        highScore.setTopic("Multi");

        for (MultiQuiz question : quiz) {
            question.printQuestion();

            isAnswering = true;
            while (isAnswering) {
                input = scanner.nextLine();
                if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")) {
                    answer = Integer.parseInt(input);

                    if (question.checkAnswer(answer)) {
                        System.out.println("Correct answer!");
                        counter++;
                    } else {
                        System.out.println("Wrong answer!");
                    }
                    isAnswering = false;

                } else {
                    System.out.println("Invalid input");
                }
            }
        }

        System.out.println("Your score is " + counter + " out of " + quiz.size());
        highScore.setScore(counter);
        jdbc.saveUserScore(highScore);
    }


}
