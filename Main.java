import java.util.*;
import java.io.*;

public class Main {

    public static int getRandomNumberUsingNextInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static char generateRandomLetter() {
        int index = getRandomNumberUsingNextInt(0, 26);
        int characterCode = index + 65;
        char letter = (char) characterCode;
        return letter;
    }

    public static ArrayList<String> getNTopics(int n) {

        ArrayList<String> topics = readFile();
        ArrayList<String> selectedTopics = new ArrayList<String>();
        ArrayList<String> possibleSelections = new ArrayList<>(topics);

        for (int i = 1; i <= n; i++) {
            int randomInteger = getRandomNumberUsingNextInt(0, i);
            selectedTopics.add(possibleSelections.get(randomInteger));
            possibleSelections.remove(randomInteger);
        }
        return selectedTopics;
    }

    public static ArrayList<String> readFile() {
        ArrayList<String> listOfLines = new ArrayList<>();
        try {
            File myObj = new File("topics.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                listOfLines.add(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return listOfLines;
    }

    public static void displayQuestions(ArrayList<String> topics) {
        for (int i = 0; i < topics.size(); i++) {
            System.out.println("\t" + (i + 1) + ") " + topics.get(i));
        }
    }

    public static void displayLetter(char letter) {
        System.out.println("The letter randomly selected is: " + letter);
    }

    public static void main(String[] args) {
        boolean playingGame = true;
        while (playingGame) {

            System.out.println("#".repeat(50));
            System.out.println();
            char randomLetter = generateRandomLetter();
            displayLetter(randomLetter);
            System.out.println();

            int questionCount = -1;
            while (questionCount < 1 || questionCount > 10) {
                try {
                    System.out.println("How many questions would you like to see for the letter: " + randomLetter);
                    Scanner sc = new Scanner(System.in);
                    questionCount = sc.nextInt();
                    if (questionCount < 1 || questionCount > 10) {
                        System.out.println("INVALID INPUT, please select an integer between 1 and 10.");
                    }
                } catch (Exception e) {
                    System.out.println("INVALID INPUT, please select an integer between 1 and 10.");
                }
            }

            System.out.println();
            ArrayList<String> questionsSelected = getNTopics(questionCount);
            displayQuestions(questionsSelected);
            System.out.println();

            Scanner sc = new Scanner(System.in);
            System.out.print("Press enter for another round.");
            String stillPlaying = sc.nextLine();

            if (!stillPlaying.equals("")) {
                playingGame = false;
            }

        }

    }
}