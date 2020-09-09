import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class EfficientRater implements Rater{

    private String myID;
//    private ArrayList<Rating> myRatings;
    private HashMap<String, Rating> myRatingsMap;

    public EfficientRater(String id) {
        myID = id;
//        myRatings = new ArrayList<Rating>();
        myRatingsMap = new HashMap<>();
    }

    public void addRating(String item, double rating) {
        myRatingsMap.put(item, new Rating(item, rating));
//        myRatings.add(new Rating(item,rating));
    }

    public boolean hasRating(String item) {
        if (myRatingsMap.containsKey(item))
            return true;
        return false;
    }

    public String getID() {
        return myID;
    }

    public double getRating(String item) {
        if (hasRating(item))
            return myRatingsMap.get(item).getValue();
        return -1;
    }

    public int numRatings() {
        return myRatingsMap.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> items = new ArrayList<>();
        for (String key : myRatingsMap.keySet()) {
            items.add(key);
        }
//        for(int k=0; k < myRatings.size(); k++){
//            list.add(myRatings.get(k).getItem());
//        }
        return items;
    }

    @Override
    public boolean equals(Object o) {
        boolean sameId = false;

        if (o instanceof EfficientRater) {
            sameId = this.myID.equals(((EfficientRater) o).getID());
            // sameId = this.myID.equals(((PlainRater) o).myID);
        }
        return sameId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(myID, myRatingsMap);
    }
}
