import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWord {
    private File readFile;
    private ArrayList<String> wordList;

    public ReadWord(String fileName) throws FileNotFoundException {
        wordList = new ArrayList<>();
        this.readFile = new File(fileName);
        Scanner scanner = new Scanner(readFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (String word: line.split(" ")){
                if (word.length() != 0) {
                    word = filterWord(word);
                    wordList.add(word);
                }
            }
        }

        //System.out.println(wordList.toString());

    }

    private String filterWord(String word){
        word = word.toLowerCase();
        while(word.length() != 0 && !Character.isLetter(word.charAt(0))){
            word = word.substring(1);
        }

        while(word.length() != 0 && !Character.isLetter(word.charAt(word.length()-1))){
            word = word.substring(0, word.length()-1);
        }
        return word;

    }

    public ArrayList<String> getWords() {
        return wordList;
    }
}