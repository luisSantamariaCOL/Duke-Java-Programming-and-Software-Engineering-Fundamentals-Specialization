
/**
 * Write a description of class MarkovRunner here.
 *
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

import java.security.InvalidKeyException;

public class MarkovRunnerWithInterface {
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
        int size = 200;
        int seed = 365;

        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size, seed);

/*
        EfficientMarkovModel efficientMarkovModel = new EfficientMarkovModel(5);
        runModel(efficientMarkovModel, st, size, seed);
        efficientMarkovModel.printHashMapInfo();

        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size, seed);

        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size, seed);*/

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

    public void testHashMap() {
        EfficientMarkovModel markovModel = new EfficientMarkovModel(2);
        int seed = 42;
        String trainingText = "yes-this-is-a-thin-pretty-pink-thistle";
        int sizeOfText = 50;
        runModel(markovModel, trainingText, 50, 42);
        // markovModel.printHashMapInfo();

    }

    public void compareMethods() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 1000;
        int seed = 42;
        MarkovModel markovModel = new MarkovModel(2);
        EfficientMarkovModel efficientMarkovModel = new EfficientMarkovModel(2);
        runModel(efficientMarkovModel, st, size, seed);
    }
}
