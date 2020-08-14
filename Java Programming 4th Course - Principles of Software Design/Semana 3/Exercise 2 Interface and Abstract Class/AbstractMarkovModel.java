
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;

    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    protected ArrayList<String> getFollows(String key) {
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

}
