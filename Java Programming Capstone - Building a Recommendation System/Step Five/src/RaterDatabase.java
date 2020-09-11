/**
 * an efficient way to get information about raters.
 *
 * @author Luis Santamaria COL
 * @version 07-september-2020
 */

import edu.duke.*;
import org.apache.commons.csv.*;

import java.util.ArrayList;
import java.util.HashMap;

public class RaterDatabase {

    /* maps a rater ID String to a Rater object
     * that includes all the movie ratings made by this rater. */
    private static HashMap<String, Rater> ourRaters;

    private static void initialize() {
        // this method is only called from addRatings
        if (ourRaters == null) {
            ourRaters = new HashMap<String, Rater>();
        }
    }

    // initialize the rater database.
    public static void initialize(String filename) {
        if (ourRaters == null) {
            ourRaters = new HashMap<String, Rater>();
            addRatings("data/" + filename);
        }
    }

    // add rater ratings to the database from a file.
    // addRatings calls addRaterRating
    public static void addRatings(String filename) {
        initialize();
        FileResource fr = new FileResource(filename);
        CSVParser csvp = fr.getCSVParser();
        for (CSVRecord rec : csvp) {
            String id = rec.get("rater_id");
            String item = rec.get("movie_id");
            String rating = rec.get("rating");
            addRaterRating(id, item, Double.parseDouble(rating));
        }
    }

    // add one rater and their movie rating to the database.
    public static void addRaterRating(String raterID, String movieID, double rating) {
        initialize();
        Rater rater = null;
        if (ourRaters.containsKey(raterID)) {
            rater = ourRaters.get(raterID);
        } else {
            rater = new EfficientRater(raterID);
            ourRaters.put(raterID, rater);
        }
        rater.addRating(movieID, rating);
    }

    // find a Rater that has this ID.
    public static Rater getRater(String id) {
        initialize();

        return ourRaters.get(id);
    }

    // returns an ArrayList of Raters from the database.
    public static ArrayList<Rater> getRaters() {
        initialize();
        ArrayList<Rater> list = new ArrayList<Rater>(ourRaters.values());

        return list;
    }

    // to get the number of raters in the database.
    public static int size() {
        return ourRaters.size();
    }

}