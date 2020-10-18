import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean playingGame = true;
        while (playingGame) {

            Game currentGame = new Game();
            currentGame.displayLetter();

            int questionCount = -1;
            while (questionCount < 1 || questionCount > 10) {
                try {
                    System.out.println(
                            "How many questions would you like to see for the letter: " + currentGame.randomLetter);
                    Scanner sc = new Scanner(System.in);
                    questionCount = sc.nextInt();
                    if (questionCount < 1 || questionCount > 10) {
                        System.out.println("INVALID INPUT, please select an integer between 1 and 10.");
                    }
                } catch (Exception e) {
                    System.out.println("INVALID INPUT, please select an integer between 1 and 10.");
                }
            }

            currentGame.getNTopics(questionCount);
            currentGame.displayQuestions();

            Scanner sc = new Scanner(System.in);
            System.out.print("Press enter for another round.");
            String stillPlaying = sc.nextLine();

            if (!stillPlaying.equals("")) {
                playingGame = false;
            }

        }

    }
}