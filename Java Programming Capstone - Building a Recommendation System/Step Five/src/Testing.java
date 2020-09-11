/*
    Class for testing methods of all classes
 */

import java.util.ArrayList;

public class Testing {

    public static void main(String[] args) {
//        testFirstRatings();
//        testSecondRatings();
//        testThirdRatings();
//        testMovieRunnerAverage();
//        testMovieRunnerWithFilters();
//        testMovieRunnerSimilarRatings();
        testRecommendationRunner();
    }

    public static void testFirstRatings() {
        FirstRatings firstRatings = new FirstRatings();
//        firstRatings.testLoadMovies();
//        firstRatings.testLoadRaters();
    }

    public static void testSecondRatings() {
        SecondRatings sr = new SecondRatings();
        System.out.println(sr.getAverageRatings(2));
    }

    public static void testThirdRatings() {
        ThirdRatings tr = new ThirdRatings();
        System.out.println(tr.getAverageRatings(4));
    }

    public static void testMovieRunnerAverage() {
        MovieRunnerAverage mr = new MovieRunnerAverage();
        mr.printAverageRatings();
//        mr.getAverageRatingOneMovie();
    }

    public static void testMovieRunnerWithFilters() {
        MovieRunnerWithFilters mr = new MovieRunnerWithFilters();
//        mr.printAverageRatings();
//        mr.printAverageRatingsByYear();
//        mr.printAverageRatingsByGenre();
//        mr.printAverageRatingsByMinutes();
//        mr.printAverageRatingsByDirectors();
//        mr.printAverageRatingsByYearAfterAndGenre();
//        mr.printAverageRatingsByDirectorsAndMinutes();
    }

    public static void testMovieRunnerSimilarRatings() {
        MovieRunnerSimilarRatings mv = new MovieRunnerSimilarRatings();
//        mv.printAverageRatings();
//        mv.printAverageRatingsByYearAfterAndGenre();
//        mv.printSimilarRatings();
//        mv.printSimilarRatingsByGenre();
//        mv.printSimilarRatingsByDirector();
//        mv.printSimilarRatingsByGenreAndMinutes();
          mv.printSimilarRatingsByYearAfterAndMinutes();
    }

    public static void testRecommendationRunner() {
        RecommendationRunner recommendationRunner = new RecommendationRunner();
//        ArrayList<String> movies = recommendationRunner.getItemsToRate();
        recommendationRunner.printRecommendationsFor("201");

    }
}
