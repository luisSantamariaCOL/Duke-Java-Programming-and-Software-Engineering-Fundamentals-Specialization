import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.Collections;

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
    private static final String url = "https://www.dukelearntoprogram.com//capstone/recommender.php?id=3uKlPQdMeDZbVt";


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
        try {
            this.webRaterID = webRaterID;
            printHtml();
        } catch (Exception e) {
            errorMessage();
        }
    }

        // This methods will get all the Ratings to display
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
            errorMessage();
        }

        if (ratings.size() > 20) {
            ArrayList<Rating> ratingsSubList = new ArrayList<>(ratings.subList(0, 20));
            return ratingsSubList;
        }
        return ratings;
    }

    private void setMovieValues(Rating rating) {
        Movie movie = MovieDatabase.getMovie(rating.getItem());

        moviePoster = MovieDatabase.getPoster(rating.getItem()).substring(7);
        movieName = movie.getTitle();
        ratingValue = (double) Math.round(rating.getValue() * 10) / 10;
        year = movie.getYear();
        director = movie.getDirector();
        minutes = movie.getMinutes();
        country = movie.getCountry();
    }

    private void printHtml() {
        printHead();
        printBody();
    }

    private void printHead() {
        metaTag();
        style("bootstrapmin.txt");
        style("maincss.txt");
    }

    private void printBody() {

        System.out.println("<div class=\"container-table100\">");
        System.out.println("<div class=\"wrap-table100\">");
        printTable();
        System.out.println("</div>");
        System.out.println("</div>");

    }

    private void printTable() {
        System.out.println("<div class=\"table100 ver3 m-b-110\">");
        printTableHead();
        printTableBody();
        System.out.println("</div>");
    }

    private void printTableHead() {
        String[] tableTitles = {"#", "POSTER", "MOVIE", "RATING", "YEAR", "DIRECTOR", "MINUTES", "COUNTRY"};

        System.out.println("<div class=\"table100-head\">");
        System.out.println("    <table>");
        System.out.println("        <thead>");
        System.out.println("            <tr class=\"row100 head\">");
        int i = 1;
        for (String tableTitle : tableTitles) {
            System.out.println("             <th class=\"column"+i+"\">"+tableTitle+"</th>");
            i++;
        }
        System.out.println("            </tr>");
        System.out.println("        <thead>");
        System.out.println("    </table>");
        System.out.println("</div>");
    }

    private void printTableBody() {

        System.out.println("<div class=\"table100-body js-pscroll\">");
        System.out.println("    <table>");
        System.out.println("        <tbody>");
        int i = 1;
        for (Rating rating : getRatings()) {
            setMovieValues(rating);
            System.out.println("            <tr class=\"body\">");
            printTableRow(i, moviePoster, movieName, ratingValue, year, director, minutes, country);
            System.out.println("            </tr>");
            i++;
        }
        System.out.println("        </tbody>");
        System.out.println("    </table>");
        System.out.println("</div>");
    }

    private void printTableRow(int index, String poster, String movie, double rating, int year,
                               String director, int minutes, String country) {
        String URL = "http://www.dukelearntoprogram.com/capstone/data/" + poster;

        System.out.println("                <td class=\"column1\">" + index + "</td>");
        System.out.println("                <td class=\"column2\"> <img src=\"" + URL + "\" height=\"100\" align=\"center\"></td>");
        System.out.println("                <td class=\"column3\">" + movie + "</td>");
        System.out.println("                <td class=\"column4\">" + rating + "</td>");
        System.out.println("                <td class=\"column5\">" + year + "</td>");
        System.out.println("                <td class=\"column6\">" + director + "</td>");
        System.out.println("                <td class=\"column7\">" + minutes + "</td>");
        System.out.println("                <td class=\"column8\">" + country + "</td>");

    }

    private void style(String cssFile) {
        System.out.println("<style>");
        String[] cssContent = splitFile(new FileResource(cssFile));
        for (String line : cssContent) {
            System.out.println(line);
        }
        System.out.println("</style>");
    }

    private void metaTag() {
        System.out.println("<meta charset=\"UTF-8\">");
        System.out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
    }

    private String[] splitFile(FileResource fileResource) {
        String[] myText = fileResource.asString().trim().split("\n");
        return myText;
    }

    private void errorMessage() {
        String message = "no movies were rated by the number of minimal raters specified in the recommender";
        System.out.println("<h6 style=\"color:white;\">" + message + "</h6>\"");
        System.out.println("<h6 style=\"color:white;\">please try again in</h6>");
        System.out.println("<a href=\""+ url +"\">Capstone Recommender Input Form</a>\n");
        System.out.println();
        System.exit(0);
    }

}
