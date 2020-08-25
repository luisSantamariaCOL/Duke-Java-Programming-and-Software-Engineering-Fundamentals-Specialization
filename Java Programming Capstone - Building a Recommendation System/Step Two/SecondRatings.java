/**
 * This class do many of the calculations focusing on computing averages on movie ratings
 *
 * @author Luis Esteban Santamaría Blanco
 * @version August 18, 2020
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;

    public SecondRatings() {
        // default constructor
        this("ratedmovies_short", "ratings_short");
    }

    public SecondRatings(String movieFile, String ratingsFile) {
        FirstRatings fr = new FirstRatings();
        this.myMovies = fr.loadMovies(movieFile);
        this.myRaters = fr.loadRaters(ratingsFile);
    }

    public int getMovieSize() {
        return myMovies.size();
    }

    public int getRaterSize() {
        return myRaters.size();
    }

    private double getAverageByID(String movieID, int minimalRaters) {
        double average = 0.0;
        double sum = 0.0;
        double count = 0.0;
        for (Rater rater : myRaters) {
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
        for (Movie movie : myMovies) {
            String movieID = movie.getID();
            double averageRating = getAverageByID(movieID, minimalRaters);
            if (averageRating == 0.0) continue;
            Rating rating = new Rating(movieID, averageRating);
            ratingsWithMinimalRaters.add(rating);
//                System.out.println("movie " + movieId + " average rating " + averageRating);
        }
        return ratingsWithMinimalRaters;
    }

    public String getTitle(String movieID) {
        String titleOfTheMovie = "";
        boolean movieExists = false;
        for (Movie movie : myMovies) {
            if (movie.getID().equals(movieID)) {
                titleOfTheMovie = movie.getTitle();
                movieExists = true;
            }
        }

        if (movieExists) return titleOfTheMovie;

        return "ID was not found";
    }

    public String getID(String title) {
        String movieID = "";
        boolean movieIDExist = false;

        for (Movie movie : myMovies) {
            if (movie.getTitle().equals(title)) {
                movieID = movie.getID();
                movieIDExist = true;
            }
        }

        if (movieIDExist) return movieID;

        return "NO SUCH TITLE";
    }

}