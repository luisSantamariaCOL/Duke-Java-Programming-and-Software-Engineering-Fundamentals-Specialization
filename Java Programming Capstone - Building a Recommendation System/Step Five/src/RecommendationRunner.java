import edu.duke.FileResource;

import java.util.ArrayList;

/***************************************************************
 *  Name:    Luis Santamaria
 *
 *  Date: 10-September-2020
 *
 *  Description:  -------------------STEP FIVE--------
 *                 a class RecommendationRunner that implements Recommender.
 *                 The two methods you will need to implement are:
 *                • getItemsToRate()
 *                • printRecommendationsFor()
 *
 *                When the user first visits the recommender site, our code
 *                will call the method getItemsToRate() to get a list of movies
 *                to display on the web page for users to rate.
 *                After the user submits their ratings, our code will call the
 *                method printRecommendationsFor() to get your recommendations
 *                based on the user's ratings and display them.
 *
 *
 ****************************************************************/

public class RecommendationRunner implements Recommender {

    private String webRaterID;
    private String moviePoster;
    private String movieName;
    private double ratingValue;
    private int year;
    private String director;
    private int minutes;
    private String country;

    public RecommendationRunner() {
        initializeVariables();
    }

    private void initializeVariables() {
        this.webRaterID = "";
        this.moviePoster = "";
        this.movieName = "";
        this.ratingValue = 0.0;
        this.year = 0;
        this.director = "";
        this.minutes = 0;
        this.country = "";
    }

    @Override
    public ArrayList<String> getItemsToRate() {
        AllFilters filters = new AllFilters();
        filters.addFilter(new GenreFilter("Animation, Adventure"));
        filters.addFilter(new MinutesFilter(92, 98));
        filters.addFilter(new YearAfterFilter(2010));
        ArrayList<String> movies = MovieDatabase.filterBy(filters);
        return movies;
    }

    @Override
    public void printRecommendationsFor(String webRaterID) {
        this.webRaterID = webRaterID;
        style("pruebacss.txt");
        printHtml();
    }


    private ArrayList<Rating> getRatings() {
        FourthRatings fourthRatings = new FourthRatings();
        int numSimilarRaters = 20;
        int minimalRaters = 2;
        String genre = "Animation";

        AllFilters filters = new AllFilters();
        filters.addFilter(new GenreFilter(genre));

        ArrayList<Rating> ratings =
                fourthRatings.getSimilarRatings(webRaterID, numSimilarRaters, minimalRaters,
                        filters);
        if (ratings.size() == 0) {
            String message = "no movies were rated by the number of minimal raters specified in the recommender";
            System.out.println("<h1>" + message + "</h1>");
            System.exit(1);
        }
        System.out.println("<h1>Ratings: " + ratings.size() + "</h1>");
        return ratings;
    }

    private void setMovieValues(Rating rating) {
        Movie movie = MovieDatabase.getMovie(rating.getItem());

        moviePoster = movie.getPoster();
        movieName = movie.getTitle();
        ratingValue = (double) Math.round(rating.getValue() * 10) / 10;
        year = movie.getYear();
        director = movie.getDirector();
        minutes = movie.getMinutes();
        country = movie.getCountry();
    }

    private void printHtml() {
        printTable();
    }

    private void printTable() {
        System.out.println("<table>");
        printTableHead();
        printTableBody();
        System.out.println("</table>");
    }

    private void printTableHead() {
        System.out.println("\t<tr class=\"trTable\">");
        System.out.println("\t\t<th>#</th>");
        System.out.println("\t\t<th>Poster</th>");
        System.out.println("\t\t<th>Movie</th>");
        System.out.println("\t\t<th>Rating</th>");
        System.out.println("\t\t<th>Year</th>");
        System.out.println("\t\t<th>Director</th>");
        System.out.println("\t\t<th>Minutes</th>");
        System.out.println("\t\t<th>Country</th>");
        System.out.println("\t</tr>");
    }

    private void printTableBody() {
        int i = 1;
        for (Rating rating : getRatings()) {
            setMovieValues(rating);
            System.out.println("\t<tr>");
            printTableRow(i, moviePoster, movieName, ratingValue, year, director, minutes, country);
            System.out.println("\t</tr>");
            i++;
        }
    }

    private void printTableRow(int index, String poster, String movie, double rating, int year,
                               String director, int minutes, String country) {
        System.out.println("\t\t<td>" + index + "</td>");
        System.out.println("\t\t<td> <img src=" + poster + " /></td>");
        System.out.println("\t\t<td>" + movie + "</td>");
        System.out.println("\t\t<td>" + rating + "</td>");
        System.out.println("\t\t<td>" + year + "</td>");
        System.out.println("\t\t<td>" + director + "</td>");
        System.out.println("\t\t<td>" + minutes + "</td>");
        System.out.println("\t\t<td>" + country + "</td>");

    }

    private void style(String cssFile) {
        System.out.println("<style>");
        String[] cssContent = splitFile(new FileResource(cssFile));
        for (String line : cssContent) {
            System.out.println(line);
        }
        System.out.println("</style>");

    }

    private String[] splitFile(FileResource fileResource) {
        String[] myText = fileResource.asString().trim().split("\n");
        return myText;
    }

}
