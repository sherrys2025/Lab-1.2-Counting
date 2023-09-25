import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class CheckWord {
    Set<String> commonWords;

    public CheckWord(){
        commonWords = new HashSet<>();
        File file = new File("resources/commonWords.txt");
    }
}
