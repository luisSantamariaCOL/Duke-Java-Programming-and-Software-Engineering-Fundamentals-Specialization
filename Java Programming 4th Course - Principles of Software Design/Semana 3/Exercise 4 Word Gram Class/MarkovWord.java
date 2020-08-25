import java.util.ArrayList;
import java.util.Random;

public class MarkovWord implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int myOrder;

    public MarkovWord(int order) {
        myOrder = order;
        myRandom = new Random();
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text) {
        myText = text.split("\\s+");
    }

    public int indexOf(String[] words, WordGram target, int start) {
        for (int k = start; k < words.length - myOrder; k++) { // Search through all the words
            if (words[k].equals(target.wordAt(0))) {
                WordGram wg = new WordGram(words, k, myOrder);
                if (wg.equals(target)) { //if word i'm looking for is my target, i found it.
                    return k;
                }
            }
        }
        return -1;
    }

    private ArrayList<String> getFollows(WordGram kGram) { // 1 por myOrder
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while (pos < myText.length) {
            int start = indexOf(myText, kGram, pos);
//            System.out.println("start >> " + start);
            if (start == -1) {
                break;
            }
            if (start + 1 >= myText.length - myOrder) { //start + my Order sospechoso
                break;
            }
            String next = myText[start + myOrder];
//            System.out.println("next >> " + next);
            follows.add(next);
            pos = start + myOrder;
        }
        return follows;
    }

    public String getRandomText(int numWords) {
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length - myOrder);
        WordGram kGram = new WordGram(myText, index, myOrder);
//        System.out.println(" >> " + kGram.toString());
//        System.out.println(" >> " + kGram);
        sb.append(kGram);
        sb.append(" ");
        for (int k = 0; k < numWords - myOrder; k++) {
            ArrayList<String> follows = getFollows(kGram);
//            System.out.println("follows >> " + follows);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            kGram = kGram.shiftAdd(next);
        }

        return sb.toString().trim();
    }


}
