import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Counter {
    public static void main(String[] args) throws FileNotFoundException {
        CheckWord commonWords = new CheckWord();

        ReadWord readWord = new ReadWord("resources/Nineteen+eighty-four.txt");

        ParallelArrays parallelArrays = new ParallelArrays();

        ArrayList<String> toRead = readWord.getWords();

        for (String word: toRead) {
            if (commonWords.isCommon(word)) {
                continue;
            }
            parallelArrays.add(word);
        }

        int[] counts = parallelArrays.getCnt();
        String[] words = parallelArrays.getWords();

        int[] maxFive = find5MaxIndex(counts);
        for (int i : maxFive) {
            System.out.println(words[i] + ": " + counts[i]);
        }

    }

    private static int[] find5MaxIndex(int[] counts) {
        int[] index = new int[5];
        int[] max = new int[5];
        int filled = 0;
        for (int i = 0; i < counts.length; i++) {
            if (max[filled] < counts[i]) {
                addIndex(index, max, i, counts[i]);
                if (filled != 4) {
                    filled++;
                }
            }
        }
        return index;
    }

    private static void addIndex(int[] index, int[] counts, int i, int ct) {
        int indexToAdd = 0;
        for (int j = 4; j >= 0; j--) {
            if (counts[j] == 0) {
                continue;
            }
            if (counts[j] > ct) {
                indexToAdd = j+1;
                break;
            }
        }

        for (int j = 3; j >= indexToAdd; j--) {
            counts[j + 1] = counts[j];
            index[j + 1] = index[j];
        }
        counts[indexToAdd] = ct;
        index[indexToAdd] = i;
    }
}
