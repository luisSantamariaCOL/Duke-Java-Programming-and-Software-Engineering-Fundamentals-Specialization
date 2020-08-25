import java.util.ArrayList;
import java.util.Random;

public class MarkovModel extends AbstractMarkovModel{

    private int numOfCharactersToPredict;

    public MarkovModel(int n) {
        myRandom = new Random();
        numOfCharactersToPredict = n;
    }

    public void setTraining(String s) {
        myText = s.trim();
    }


    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - numOfCharactersToPredict);
        String key = myText.substring(index, index + numOfCharactersToPredict);
        sb.append(key);
        for (int k = 0; k < numChars - numOfCharactersToPredict; k++) {
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

    @Override
    public String toString() {
        return "Markov of order " + numOfCharactersToPredict;
    }
}
