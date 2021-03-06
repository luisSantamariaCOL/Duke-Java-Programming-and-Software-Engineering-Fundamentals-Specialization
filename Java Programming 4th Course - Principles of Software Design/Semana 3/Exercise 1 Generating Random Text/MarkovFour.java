import java.util.ArrayList;
import java.util.Random;

public class MarkovFour {

    private String myText;
    private Random myRandom;

    public MarkovFour() {
        myRandom = new Random();
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String s) {
        myText = s.trim();
    }

    public ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<>();
        int pos = 0;
        int index = myText.indexOf(key, pos);
        while (index != -1) {
            if (index == (myText.length() - key.length())) {
                break;
            }
            String follow = myText.substring(index + key.length(), index + key.length() + 1);
            follows.add(follow);
            pos = index + key.length();
            index = myText.indexOf(key, pos);
        }
        // System.out.println(follows);
        return follows;
    }

    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - 4);
        String key = myText.substring(index, index + 4);
        sb.append(key);
        for (int k = 0; k < numChars - 4; k++) {
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;

        }

        return sb.toString();
    }
}
