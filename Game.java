import java.util.*;
import java.io.*;

public class Game {
    static String staticTopicFileName = "topics.txt";
    char randomLetter;
    int questionCount;
    ArrayList<String> questionsSelected;

    public int getRandomNumberUsingNextInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public char generateRandomLetter() {
        int index = getRandomNumberUsingNextInt(0, 26);
        int characterCode = index + 65;
        char letter = (char) characterCode;
        return letter;
    }

    public void getNTopics(int n) {

        ArrayList<String> topics = readFile();
        ArrayList<String> selectedTopics = new ArrayList<String>();
        ArrayList<String> possibleSelections = new ArrayList<>(topics);

        for (int i = 1; i <= n; i++) {
            int randomInteger = getRandomNumberUsingNextInt(0, i);
            selectedTopics.add(possibleSelections.get(randomInteger));
            possibleSelections.remove(randomInteger);
        }
        this.questionsSelected = selectedTopics;
    }

    public ArrayList<String> readFile() {
        ArrayList<String> listOfLines = new ArrayList<>();
        try {
            File myObj = new File(staticTopicFileName);
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

    public void displayQuestions() {
        ArrayList<String> topics = this.questionsSelected;

        System.out.println();
        for (int i = 0; i < topics.size(); i++) {
            System.out.println("\t" + (i + 1) + ") " + topics.get(i));
        }
        System.out.println();
    }

    public void displayLetter() {
        System.out.println("#".repeat(50));
        System.out.println();
        System.out.println("The letter randomly selected is: " + this.randomLetter);
        System.out.println();
    }

    public Game() {
        this.randomLetter = generateRandomLetter();
    }
}
