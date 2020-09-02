
/*
    Class for testing methods of all classes
 */

public class Testing {

    public static void main(String[] args) {
//        testFirstRatings();
//        testSecondRatings();
//        testThirdRatings();
//        testMovieRunnerAverage();
        testMovieRunnerWithFilters();
    }

    public static void testFirstRatings() {
        FirstRatings firstRatings = new FirstRatings();
//        firstRatings.testLoadMovies();
        firstRatings.testLoadRaters();
    }

    public static void testSecondRatings() {
        SecondRatings sr = new SecondRatings();
        sr.getAverageRatings(2);
    }

    public static void testThirdRatings() {
        ThirdRatings tr = new ThirdRatings();
        System.out.println(tr.getAverageRatings(4));
    }

    public static void testMovieRunnerAverage() {
        MovieRunnerAverage mr = new MovieRunnerAverage();
//        mr.printAverageRatings();
        mr.getAverageRatingOneMovie();
    }

    public static void testMovieRunnerWithFilters() {
        MovieRunnerWithFilters mr = new MovieRunnerWithFilters();
//        mr.printAverageRatings();
//        mr.printAverageRatingsByYear();
//        mr.printAverageRatingsByGenre();
//        mr.printAverageRatingsByMinutes();
//        mr.printAverageRatingsByDirectors();
//        mr.printAverageRatingsByYearAfterAndGenre();
        mr.printAverageRatingsByDirectorsAndMinutes();
    }

}
