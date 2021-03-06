import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of SecondRatings here.
 *
 * @author Luis Esteban Santamaría Blanco
 * @version August 18, 2020
 */

public class MovieRunnerAverage {

    public void printAverageRatings() {
        SecondRatings sr = new SecondRatings("ratedmoviesfull", "ratings");
        System.out.println(sr.getMovieSize() + " movies");
        System.out.println(sr.getRaterSize() + " raters\n");

        ArrayList<Rating> ratings = sr.getAverageRatings(12);
        Collections.sort(ratings);
        for (Rating rating : ratings) {
            String movieID = rating.getItem();
            String titleOfMovie = sr.getTitle(movieID);
            System.out.println(rating.getValue() + " " + titleOfMovie);
        }
        System.out.println("How many movies? " + ratings.size());
    }

    public void getAverageRatingOneMovie() {
        SecondRatings sr = new SecondRatings("ratedmoviesfull", "ratings");
        String movieToFind = "Vacation";
        String idFinded = sr.getID(movieToFind);
        ArrayList<Rating> ratings = sr.getAverageRatings(1);
        for (Rating rating : ratings) {
            if (rating.getItem().equals(idFinded)) {
                System.out.println(movieToFind + " " + rating.getValue());
                break;
            }
        }
    }
}
