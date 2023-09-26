import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CheckWord {
    private Set<String> commonWords;

    public CheckWord() throws FileNotFoundException {
        commonWords = new HashSet<>();
        File file = new File("resources/commonWords.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            commonWords.add(scanner.nextLine().toLowerCase());
        }
    }

    public boolean isCommon(String str){
        return commonWords.contains(str);
    }
}
