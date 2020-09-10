package src;

import java.util.ArrayList;
import java.util.Collections;

public class FourthRatings {
//    private ArrayList<EfficientRater> myRaters;

    public FourthRatings() {
        this("ratings.csv");
    }

    public FourthRatings(String ratingsFile) {
        RaterDatabase.initialize(ratingsFile);
    }

    private double getAverageByID(String movieID, int minimalRaters) {
        double average = 0.0;
        double sum = 0.0;
        double count = 0.0;
        for (Rater rater : RaterDatabase.getRaters()) {
            if (rater.hasRating(movieID)) {
                sum += ((EfficientRater) rater).getRating(movieID); // Ojo a esta linea
                count++;
            }
        }
        if (count >= minimalRaters) {
            average = sum / count;
            return average;
        }
        return 0.0;
    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<Rating> ratingsWithMinimalRaters = new ArrayList<>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for (String movieID : movies) {
            double averageRating = getAverageByID(movieID, minimalRaters);
            if (averageRating == 0.0) continue;
            Rating rating = new Rating(movieID, averageRating);
            ratingsWithMinimalRaters.add(rating);
//                System.out.println("movie " + movieId + " average rating " + averageRating);
        }
        return ratingsWithMinimalRaters;
    }

    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria) {
        ArrayList<Rating> ratingsWithMinimalRaters = new ArrayList<>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        for (String movieID : movies) {
            double averageRating = getAverageByID(movieID, minimalRaters);
            if (averageRating == 0.0) continue;
            Rating rating = new Rating(movieID, averageRating);
            ratingsWithMinimalRaters.add(rating);
        }
        return ratingsWithMinimalRaters;
    }

    private double docProduct(Rater me, Rater r) {
        ArrayList<String> items = MovieDatabase.filterBy(new TrueFilter());
        double product = 0.0;

        Rater meRater = RaterDatabase.getRater(me.getID());
        Rater rRater = RaterDatabase.getRater(r.getID());

        for (String item : items) {
            if (meRater.hasRating(item) && rRater.hasRating(item)) {
                double meRatingScaled = meRater.getRating(item) - 5.0;
                double rRatingScaled = rRater.getRating(item) - 5.0;
                product += meRatingScaled*rRatingScaled;
            }
        }

        return product;
    }

    // Find raters near me, call getSimilarities
    private ArrayList<Rating> getSimilarities(String id) {
        ArrayList<Rating> list = new ArrayList<>();
        Rater me = RaterDatabase.getRater(id); // Access to Raters
        for (Rater r : RaterDatabase.getRaters()) {
            // add dot_product(r, me) to list if r != me
            if (!r.getID().equals(id)) {
                double similarity = docProduct(r, me);
                if (similarity > 0.0) { // there is a similarity
                    Rating rating = new Rating(r.getID(), similarity); // Rater r, similarity
                    list.add(rating);
                }
            }
        }
        // List of raters sorted in reverse order. Descending
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters) {
        return getSimilarRatings(id, numSimilarRaters, minimalRaters, new TrueFilter());
    }

    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters,
                                                       Filter filterCriteria) {
        ArrayList<Rating> list = getSimilarities(id);
        ArrayList<Rating> movieRatings = new ArrayList<>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        // Rater me = RaterDatabase.getRater(id);

        for (String movieID : movies) {
            int count = 0;
            double sum = 0.0;
            for (int i = 0; i < numSimilarRaters; i++) {
                Rating raterRating = list.get(i); // get a rating r of every rater in numSimilarRaters
                String rID = raterRating.getItem();
                Rater er = RaterDatabase.getRater(rID);
                if (er.hasRating(movieID)) {
                    double weight = raterRating.getValue() * er.getRating(movieID);
                    sum += weight;
                    count++;
                }
            }
            if (count >= minimalRaters) {
                double weightedAvgMovie = sum/count;
                Rating rating = new Rating(movieID, weightedAvgMovie);
                movieRatings.add(rating);
            }
        }
        Collections.sort(movieRatings, Collections.reverseOrder());

        return movieRatings;
    }


}