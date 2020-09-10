package src;

import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerSimilarRatings {

    public void printAverageRatings() {
        FourthRatings fr = new FourthRatings("ratings_short.csv");
        MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");

        int minimalRaters = 1;
        ArrayList<Rating> ratings = fr.getAverageRatings(minimalRaters);
        System.out.println("found " + ratings.size() + " movies");
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            String movieID = rating.getItem();
            String titleOfMovie = MovieDatabase.getTitle(movieID);
            System.out.println(rating.getValue() + " " + titleOfMovie);
        }
    }

    public void printAverageRatingsByYearAfterAndGenre() {
        int minimalRaters = 1;
        int year = 1980;
        String genre = "Romance";

        FourthRatings fr = new FourthRatings("ratings_short.csv");

        MovieDatabase.initialize("ratedmovies_short.csv");
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");

        AllFilters allFilters = new AllFilters();
        allFilters.addFilter(new YearAfterFilter(year));
        allFilters.addFilter(new GenreFilter(genre));

        ArrayList<Rating> ratings = fr.getAverageRatingsByFilter(minimalRaters, allFilters);

        System.out.println("found " + ratings.size() + " movies");
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            String movieID = rating.getItem();

            if (!allFilters.satisfies(movieID)) continue;

            String titleOfMovie = MovieDatabase.getTitle(movieID);
            int yearOfMovie = MovieDatabase.getYear(movieID);
            String genresOfMovie = MovieDatabase.getGenres(movieID);

            System.out.println(rating.getValue() + " " + yearOfMovie + " " + titleOfMovie);
            System.out.println("\t" + genresOfMovie);
        }
    }

    public void printSimilarRatings() {
        FourthRatings fr = new FourthRatings();
        String raterID = "71";
        ArrayList<Rating> similarRatings = fr.getSimilarRatings(raterID, 20, 5);
        System.out.println("size " + similarRatings.size());
        for (Rating rating : similarRatings) {
            Movie movie = MovieDatabase.getMovie(rating.getItem());
            String movieName = movie.getTitle();
            System.out.println(movieName + " " + rating.getValue());
        }
    }

    public void printSimilarRatingsByGenre() {
        FourthRatings fr = new FourthRatings();
        String raterID = "964";
        String genre = "Mystery";

        ArrayList<Rating> similarRatings = fr.getSimilarRatings(raterID, 20, 5,
                new GenreFilter(genre));

//        System.out.println("size " + similarRatings.size());

        for (Rating rating : similarRatings) {
            Movie movie = MovieDatabase.getMovie(rating.getItem());
            String movieName = movie.getTitle();
            System.out.println(movieName + " " + rating.getValue());
        }
    }

    public void printSimilarRatingsByDirector() {
        FourthRatings fr = new FourthRatings();
        String raterID = "120";
        String directors = "Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh";
        ArrayList<Rating> similarRatings = fr.getSimilarRatings(raterID, 10, 2,
                new DirectorsFilter(directors));

//        System.out.println("size " + similarRatings.size());

        for (Rating rating : similarRatings) {
            Movie movie = MovieDatabase.getMovie(rating.getItem());
            String movieName = movie.getTitle();
            System.out.println(movieName + " " + rating.getValue());
        }
    }

    public void printSimilarRatingsByGenreAndMinutes() {
        FourthRatings fr = new FourthRatings();
        String raterID = "168";
        String genre = "Drama";
        int minMinutes = 80;
        int maxMinutes = 160;
        AllFilters filters = new AllFilters();
        filters.addFilter(new GenreFilter(genre));
        filters.addFilter(new MinutesFilter(minMinutes, maxMinutes));
        ArrayList<Rating> similarRatings = fr.getSimilarRatings(raterID, 10, 3,
                filters);

//        System.out.println("size " + similarRatings.size());

        for (Rating rating : similarRatings) {
            Movie movie = MovieDatabase.getMovie(rating.getItem());
            String movieName = movie.getTitle();
            System.out.println(movieName + " " + rating.getValue());
        }
    }

    public void printSimilarRatingsByYearAfterAndMinutes() {
        FourthRatings fr = new FourthRatings();
        String raterID = "314";
        int year = 1975;
        int minMinutes = 70;
        int maxMinutes = 200;
        AllFilters filters = new AllFilters();
        filters.addFilter(new YearAfterFilter(year));
        filters.addFilter(new MinutesFilter(minMinutes, maxMinutes));
        ArrayList<Rating> similarRatings = fr.getSimilarRatings(raterID, 10, 5,
                filters);

//        System.out.println("size " + similarRatings.size());

        for (Rating rating : similarRatings) {
            Movie movie = MovieDatabase.getMovie(rating.getItem());
            String movieName = movie.getTitle();
            System.out.println(movieName + " " + rating.getValue());
        }
    }
}
