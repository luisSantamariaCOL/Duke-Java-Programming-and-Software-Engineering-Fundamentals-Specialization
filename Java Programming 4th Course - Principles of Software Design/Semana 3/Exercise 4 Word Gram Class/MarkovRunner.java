
/**
 * Write a description of class MarkovRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size) {
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for (int k = 0; k < 3; k++) {
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for (int k = 0; k < 3; k++) {
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovWord markovWord = new MarkovWord(5);
//        EfficientMarkovWord markovWord = new EfficientMarkovWord(3);
        int seed = 844;
        int size = 200;
        runModel(markovWord, st, size, seed);
    }

    public void testHashMap() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        EfficientMarkovWord efficient = new EfficientMarkovWord(2);
        int seed = 65;
        int size = 50;
        efficient.setTraining(st);
        efficient.setRandom(seed);
        efficient.printHashMapInfo();
    }

    private void printOut(String s) {
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for (int k = 0; k < words.length; k++) {
            System.out.print(words[k] + " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }

}
