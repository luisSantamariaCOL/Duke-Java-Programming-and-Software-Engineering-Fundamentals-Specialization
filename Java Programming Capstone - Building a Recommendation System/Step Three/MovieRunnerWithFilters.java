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
        System.out.println("found " + ratings.size() + " movies");
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            String movieID = rating.getItem();
            String titleOfMovie = MovieDatabase.getTitle(movieID);
            System.out.println(rating.getValue() + " " + titleOfMovie);
        }


    }

    public void printAverageRatingsByYear() {
        int minimalRaters = 1;
        int year = 2000;

        ThirdRatings tr = new ThirdRatings("ratings_short");
        MovieDatabase.initialize("ratedmovies_short");
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");


        YearAfterFilter yearFilter = new YearAfterFilter(year);
        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, yearFilter);
        System.out.println("found " + ratings.size() + " movies");
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            String movieID = rating.getItem();
            if (!yearFilter.satisfies(movieID)) continue;
            String titleOfMovie = MovieDatabase.getTitle(movieID);
            System.out.println(rating.getValue() + " " + titleOfMovie);
        }
    }

    public void printAverageRatingsByGenre() {
        int minimalRaters = 1;
        String genre = "Crime";

        ThirdRatings tr = new ThirdRatings("ratings_short");
        MovieDatabase.initialize("ratedmovies_short");
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");


        GenreFilter genreFilter = new GenreFilter(genre);
        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, genreFilter);
        System.out.println("found " + ratings.size() + " movies");
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            String movieID = rating.getItem();

            if (!genreFilter.satisfies(movieID)) continue;

            String titleOfMovie = MovieDatabase.getTitle(movieID);
            String genresOfMovie = MovieDatabase.getGenres(movieID);

            System.out.println(rating.getValue() + " " + titleOfMovie);
            System.out.println("\t" + genresOfMovie);
        }
    }

    public void printAverageRatingsByMinutes() {
        int minimalRaters = 1;
        int minMinutesOfMovie = 110;
        int maxMinutesOfMovie = 170;

        ThirdRatings tr = new ThirdRatings("ratings_short");
        MovieDatabase.initialize("ratedmovies_short");
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");


        MinutesFilter minutesFilter = new MinutesFilter(minMinutesOfMovie, maxMinutesOfMovie);
        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, minutesFilter);
        System.out.println("found " + ratings.size() + " movies");
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            String movieID = rating.getItem();

            if (!minutesFilter.satisfies(movieID)) continue;

            String titleOfMovie = MovieDatabase.getTitle(movieID);
            int minutesOfMovie = MovieDatabase.getMinutes(movieID);

            System.out.println(rating.getValue() + " Time: " + minutesOfMovie + " " + titleOfMovie);
        }
    }

    public void printAverageRatingsByDirectors() {
        int minimalRaters = 1;
        String directors = "Charles Chaplin,Michael Mann,Spike Jonze";

        ThirdRatings tr = new ThirdRatings("ratings_short");
        MovieDatabase.initialize("ratedmovies_short");
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");


        DirectorsFilter directorsFilter = new DirectorsFilter(directors);
        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, directorsFilter);
        System.out.println("found " + ratings.size() + " movies");
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            String movieID = rating.getItem();

            if (!directorsFilter.satisfies(movieID)) continue;

            String titleOfMovie = MovieDatabase.getTitle(movieID);
            String directorsOfMovie = MovieDatabase.getDirector(movieID);

            System.out.println(rating.getValue() + " " + titleOfMovie);
            System.out.println("\t" + directorsOfMovie);
        }
    }

    public void printAverageRatingsByYearAfterAndGenre() {
        int minimalRaters = 1;
        int year = 1980;
        String genre = "Romance";

        ThirdRatings tr = new ThirdRatings("ratings_short");
        MovieDatabase.initialize("ratedmovies_short");
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");

        AllFilters allFilters = new AllFilters();
        allFilters.addFilter(new YearAfterFilter(year));
        allFilters.addFilter(new GenreFilter(genre));

        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, allFilters);

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

    public void printAverageRatingsByDirectorsAndMinutes() {
        int minimalRaters = 1;
        int minMinutes = 30;
        int maxMinutes = 170;
        String directors = "Spike Jonze,Michael Mann,Charles Chaplin,Francis Ford Coppola";

        ThirdRatings tr = new ThirdRatings("ratings_short");
        MovieDatabase.initialize("ratedmovies_short");
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        System.out.println("read data for " + MovieDatabase.size() + " movies");

        AllFilters allFilters = new AllFilters();
        allFilters.addFilter(new MinutesFilter(minMinutes, maxMinutes));
        allFilters.addFilter(new DirectorsFilter(directors));

        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(minimalRaters, allFilters);

        System.out.println("found " + ratings.size() + " movies");
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            String movieID = rating.getItem();

            if (!allFilters.satisfies(movieID)) continue;

            String titleOfMovie = MovieDatabase.getTitle(movieID);
            int minutesOfMovie = MovieDatabase.getMinutes(movieID);
            String directorsOfMovie = MovieDatabase.getDirector(movieID);

            System.out.println(rating.getValue() + " Time: " + minutesOfMovie + " " + titleOfMovie);
            System.out.println("\t" + directorsOfMovie);
        }
    }
}
