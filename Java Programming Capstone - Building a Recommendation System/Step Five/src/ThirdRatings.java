import java.util.ArrayList;

public class ThirdRatings {

    private ArrayList<EfficientRater> myRaters;

    public ThirdRatings() {
        this("ratings_short.csv");
    }

    public ThirdRatings(String ratingsFile) {
        FirstRatings fr = new FirstRatings();
        this.myRaters = fr.loadRaters(ratingsFile);
    }

    public int getRaterSize() {
        return myRaters.size();
    }

    private double getAverageByID(String movieID, int minimalRaters) {
        double average = 0.0;
        double sum = 0.0;
        double count = 0.0;
        for (EfficientRater rater : myRaters) {
            if (rater.hasRating(movieID)) {
                sum += rater.getRating(movieID);
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



}