import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EfficientMarkovModel extends AbstractMarkovModel {
    private int numOfCharactersToPredict;
    private HashMap<String, ArrayList<String>> follows;

    public EfficientMarkovModel(int n) {
        myRandom = new Random();
        numOfCharactersToPredict = n;
        follows = new HashMap<>();
    }

    public void setTraining(String s) {
        myText = s.trim();
    }

    public void buildMap() {
        String key;
        for (int i = 0; i <= myText.length() - numOfCharactersToPredict; i++) {
            key = myText.substring(i, i + numOfCharactersToPredict);
            ArrayList<String> arrayOfFollows = new ArrayList<>();
            if (!follows.containsKey(key)) {
                follows.put(key, arrayOfFollows);
            }
            if (i == (myText.length() - numOfCharactersToPredict)) {
                break;
            }
            String follow = myText.substring(i + key.length(), i + key.length() + 1);
            arrayOfFollows = follows.get(key);
            arrayOfFollows.add(follow);
            follows.put(key, arrayOfFollows);
        }
    }

    public ArrayList<String> getFollows(String key) {
        return follows.get(key);
    }

    public String getRandomText(int numChars) {
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
    }

    @Override
    public String toString() {
        return "Efficient Markov Model of order " + numOfCharactersToPredict;
    }

    public void printHashMapInfo() {
        int largestSize = 0;
        for (String key : follows.keySet()) {
            ArrayList<String> value = follows.get(key);
            // System.out.println(key + " " + value);
            if (value.size() > largestSize) {
                largestSize = value.size();
            }
        }
        System.out.println("number of keys: " + follows.size());
        System.out.println("largest size: " + largestSize);
//         System.out.println("Keys that have maximum size value: ");
//        for (String key : follows.keySet()) {
//            if (follows.get(key).size() == largestSize) {
//                System.out.print(key + " ");
//            }
//        }
    }

}
