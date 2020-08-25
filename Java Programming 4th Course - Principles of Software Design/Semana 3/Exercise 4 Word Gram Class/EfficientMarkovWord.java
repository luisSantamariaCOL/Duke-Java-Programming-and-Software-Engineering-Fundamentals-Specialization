import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EfficientMarkovWord implements IMarkovModel{
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    HashMap<WordGram, ArrayList<String>> myMap;

    public EfficientMarkovWord(int order) {
        myOrder = order;
        myRandom = new Random();
        myMap = new HashMap<>();
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


    public void buildMap() {
        myMap.clear();
        WordGram wg;
        for (int i = 0; i <= myText.length - myOrder; i++) {
            wg = new WordGram(myText, i, myOrder);
            ArrayList<String> arrayOfFollows = new ArrayList<>();
            if (!myMap.containsKey(wg)) {
                myMap.put(wg, arrayOfFollows);
            }
            if (i == (myText.length - myOrder)) {
                break;
            }
            String follow = myText[i + myOrder];
            arrayOfFollows = myMap.get(wg);
            arrayOfFollows.add(follow);
            myMap.put(wg, arrayOfFollows);
        }
    }


    public ArrayList<String> getFollows(WordGram wg) {
        return myMap.get(wg);
    }

    /*    public String getRandomText(int numChars) {
        follows.clear();
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - numOfCharactersToPredict);
        String key = myText.substring(index, index + numOfCharactersToPredict);
        sb.append(key);
        buildMap();
        for (int k = 0; k < numChars - numOfCharactersToPredict; k++) {
            ArrayList<String> arrayFollows = getFollows(key);
            if (arrayFollows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(arrayFollows.size());
            String next = arrayFollows.get(index);
            sb.append(next);
            key = key.substring(1) + next;

        }

        return sb.toString();
    }*/

    public String getRandomText(int numWords) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length - myOrder);
        WordGram kGram = new WordGram(myText, index, myOrder);
        sb.append(kGram);
        sb.append(" ");
        buildMap();
        for (int k = 0; k < numWords - myOrder; k++) {
            ArrayList<String> follows = getFollows(kGram);
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

    public void printHashMapInfo() {
        buildMap();
        int keysCount = 0;
        int largestSize = 0;
        for (WordGram kWordGram : myMap.keySet()) {
            ArrayList<String> value = myMap.get(kWordGram);
//            System.out.println("Key " + kWordGram + " : " + value);
            if (value.size() > largestSize) {
                 largestSize = value.size();
            }
            keysCount++;
        }
        System.out.println("\n------------------------------------\n");
        System.out.println("Number of keys: " + keysCount);
        System.out.println("Largest size: " + largestSize);
        System.out.println("\n------------------------------------\n");
        System.out.println("Keys that have the maximum size value: ");
        for (WordGram kWordGram : myMap.keySet()) {
            if (myMap.get(kWordGram).size() == largestSize) {
                System.out.println("Key " + kWordGram + " : " + myMap.get(kWordGram));
            }
        }
    }

}

