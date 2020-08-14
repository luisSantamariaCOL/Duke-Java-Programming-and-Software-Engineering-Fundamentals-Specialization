import java.util.*;

public class WordGramTester { // for developing, coding and testing WordGram
    // .hashCode(), to be added to a HashMap
    public static void main(String[] args) {
        WordGramTester tester = new WordGramTester();
        tester.testRunMarkov();
    }

    public void testWordGram() {
        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        int size = 4;
        for (int index = 0; index <= words.length - size; index += 1) {
            WordGram wg = new WordGram(words, index, size);
            System.out.println(index + "\t" + wg.length() + "\t" + wg);
        }
    }

    public void testWordGramEquals() {
        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        ArrayList<WordGram> list = new ArrayList<>(); // Generating WordGrams
        int size = 4;

        // storing in the arrayList list
        for (int index = 0; index <= words.length - size; index += 1) {
            WordGram wg = new WordGram(words, index, size);
            list.add(wg);
        }

        // get first WordGram of list
        WordGram first = list.get(0);

        // comparing first WordGram to all other WordGrams in list
        System.out.println("checking " + first);
        for (int k = 0; k < list.size(); k++) {
            //if (first == list.get(k)) {
            if (first.equals(list.get(k))) {
                System.out.println("matched at " + k + " " + list.get(k));
            }
        }
    }

    public void testWordGramShiftAdd() {
        String source = "this is a test";
        String[] words = source.split("\\s+");
        ArrayList<WordGram> list = new ArrayList<>(); // Generating WordGrams
        int size = 4;
        WordGram wg = new WordGram(words, 0, size);
        wg.shiftAdd("yes");

    }

    public void testRunMarkov() {
        MarkovRunner markovRunner = new MarkovRunner();
        markovRunner.runMarkov();
    }

    public void testPrintHashMap() {
        MarkovRunner markovRunner = new MarkovRunner();
        markovRunner.testHashMap();
    }
}
