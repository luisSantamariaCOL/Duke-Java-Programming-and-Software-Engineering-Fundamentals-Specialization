package src;

import edu.duke.*;
import org.apache.commons.csv.*;

import java.util.ArrayList;
import java.util.HashMap;

public class FirstRatings {

    public ArrayList<EfficientRater> loadRaters(String filename) {
        FileResource fileOfRatings = new FileResource("data/" + filename);
        CSVParser parser = fileOfRatings.getCSVParser();
        ArrayList<EfficientRater> raters = new ArrayList<>();
        for (CSVRecord record : parser) {
            EfficientRater rater = recordToRater(record);
            if (!raters.contains(rater)) {
                raters.add(rater);
            } else {
                int index = raters.indexOf(rater);
                raters.get(index).addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
            }
        }
        return raters;
    }

    private EfficientRater recordToRater(CSVRecord record) {
        String id = record.get("rater_id");
        EfficientRater rater = new EfficientRater(id);
        rater.addRating(record.get("movie_id"), Double.parseDouble(record.get("rating")));
        return rater;
    }

    public void testLoadRaters() {
        ArrayList<EfficientRater> localVariable = loadRaters("ratings_short.csv");
        System.out.println("---------------------------------");
        System.out.println("total number of raters " + localVariable.size());
        int particularNumberOfRatings = 2;
        int countRaters = 0;
        int maxNumOfRatings = 0;
        for (EfficientRater rater : localVariable) {
            if (rater.numRatings() == particularNumberOfRatings) {
                countRaters++;
            }
            if (rater.numRatings() > maxNumOfRatings) {
                maxNumOfRatings = rater.numRatings();
            }
            System.out.println("ID " + rater.getID() + ", Number of ratings " + rater.numRatings());
            System.out.println("\t" + rater.getItemsRated());

        }
        System.out.println("The filename has " + countRaters + " raters " +
                "with " + particularNumberOfRatings + " ratings");
        printMaximumNumberOfRatings(maxNumOfRatings, localVariable);
        printNumOfRatingsOfParticularMovie("1798709", localVariable);
        howManyDifferentMoviesHaveBeenRated(localVariable);
    }

    private void howManyDifferentMoviesHaveBeenRated(ArrayList<EfficientRater> raters) {
        System.out.println("-------------------------------------------------");
        ArrayList<String> differentMovies = new ArrayList<>();
        for (EfficientRater rater : raters) {
            ArrayList<String> temp = rater.getItemsRated();
            for (String item : temp) {
                if (!differentMovies.contains(item)) {
                    differentMovies.add(item);
                }
            }
        }
        System.out.println("There were " + differentMovies.size() + " different movies rated");
    }

    private void printMaximumNumberOfRatings(int maxNumOfRatings, ArrayList<EfficientRater> raters) {
        int count = 0;
        System.out.println("-------------------------------------------------");
        System.out.println("Raters that have max number of ratings: ");
        for (EfficientRater rater : raters) {
            if (rater.numRatings() == maxNumOfRatings) {
                System.out.println("ID " + rater.getID() + ", Number of ratings " + rater.numRatings());
                System.out.println("\t" + rater.getItemsRated());
                count++;
            }
        }
        System.out.println("Number of raters with max number of ratings is: " + count);
        System.out.println("-------------------------------------------------");
    }

    private void printNumOfRatingsOfParticularMovie(String movie_id, ArrayList<EfficientRater> raters) {
        int countNumOfRatings = 0;
        for (EfficientRater rater : raters) {
            if (rater.getItemsRated().contains(movie_id)) {
                countNumOfRatings++;
            }
        }
        System.out.println("Movie " + movie_id + " was rated by " + countNumOfRatings + " raters");
    }

    public ArrayList<Movie> loadMovies(String filename) {
        FileResource fileOfRecords = new FileResource("data/" + filename);
        CSVParser parser = fileOfRecords.getCSVParser();
        ArrayList<Movie> movies = new ArrayList<>();
        for (CSVRecord record : parser) {
            Movie movie = recordToMovie(record);
            movies.add(movie);
        }
        return movies;
    }

    private Movie recordToMovie(CSVRecord record) {
        String id = record.get("id");
        String title = record.get("title");
        String year = record.get("year");
        String genre = record.get("genre");
        String director = record.get("director");
        String country = record.get("country");
        String poster = record.get("poster");
        int minutes = Integer.parseInt(record.get("minutes"));
        Movie movieCreated = new Movie(id, title, year, genre, director, country, poster, minutes);
        return movieCreated;
    }

    public void testLoadMovies() {
        int countComedys = 0;
        int minutesInLength = 150;
        int countMoviesWithCertainMinutes = 0;

        ArrayList<Movie> localVariable = loadMovies("ratedmoviesfull.csv");
        HashMap<String, Integer> directorsCount = loadDirectors(localVariable);
        System.out.println("---------------------------------");
        System.out.println("total number of movies " + localVariable.size());
        for (Movie movie : localVariable) {
            // System.out.println(movie);

            if (movie.getGenres().contains("Comedy")) {
                countComedys++;
            }
            if (movie.getMinutes() > minutesInLength) {
                countMoviesWithCertainMinutes++;
            }
        }
        printDirectorsWithNumberOfMoviesGreaterOrEqualThan(16, directorsCount);
        System.out.println("How many movies include Comedy genre? " + countComedys);
        System.out.println("How many movies are greater than " + minutesInLength + " minutes in length? "
                + countMoviesWithCertainMinutes);
    }

    private HashMap<String, Integer> loadDirectors(ArrayList<Movie> movies) {

        HashMap<String, Integer> directorsCount = new HashMap<>();

        for (Movie movie : movies) {
            if (movie.getDirector().contains(",")) { // if movie has more than one director.
                String[] directors = movie.getDirector().split(",");
                for (String eachDirector : directors) {
                    addDirector(directorsCount, eachDirector.trim());
                }
            } else {
                String director = movie.getDirector();
                addDirector(directorsCount, director);
            }
        }

        return directorsCount;
    }

    private void addDirector(HashMap<String, Integer> directorsCount, String director) {
        if (!directorsCount.containsKey(director)) {
            directorsCount.put(director, 1);
        } else {
            directorsCount.put(director, directorsCount.get(director) + 1);
        }
    }

    private void printDirectorsWithNumberOfMoviesGreaterOrEqualThan(int numberOfMovies, HashMap<String, Integer> directorsCount) {
        int maxNumberOfMoviesDirected = 0;
        for (String key : directorsCount.keySet()) {
            if (directorsCount.get(key) >= numberOfMovies) {
                System.out.println(key + " " + directorsCount.get(key));
                if (directorsCount.get(key) > maxNumberOfMoviesDirected) {
                    maxNumberOfMoviesDirected = directorsCount.get(key);
                }
            }
        }
        System.out.println("maximum number of films directed by one director: " + maxNumberOfMoviesDirected);
    }
}
