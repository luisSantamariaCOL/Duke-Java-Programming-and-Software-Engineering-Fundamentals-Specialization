import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerWithFilters {

    public void printAverageRatings() {

        ThirdRatings tr = new ThirdRatings("ratings_short");
        MovieDatabase.initialize("ratedmovies_short");
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");

        int minimalRaters = 1;
        ArrayList<Rating> ratings = tr.getAverageRatings(minimalRaters);
        System.out.println(ratings.size() + " movies with at least " + minimalRaters + " raters");
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            String movieID = rating.getItem();
            String titleOfMovie = MovieDatabase.getTitle(movieID);
            System.out.println(rating.getValue() + " " + titleOfMovie);
        }

    }
}
