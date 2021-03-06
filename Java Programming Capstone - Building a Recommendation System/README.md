# Java Programming Capstone - Building a Recommendation System

Ever wonder how Netflix decides what movies to recommend for you? Or how Amazon recommends books? We can get a feel for how it works by building a simplified recommender of our own!  

In this capstone, you will show off your problem solving and Java programming skills by creating recommender systems. You will work with data for movies, including ratings, but the principles involved can easily be adapted to books, restaurants, and more. You will write a program to answer questions about the data, including which items should be recommended to a user based on their ratings of several movies. Given input files on users ratings and movie titles, you will be able to:  

1. Read in and parse data into lists and maps;
2. Calculate average ratings;
3. Calculate how similar a given rater is to another user based on ratings; and
4. Recommend movies to a given user based on ratings. 
5. Display recommended movies for a given user on a webpage.  

## Introduction

* The website twitflicks.com mines Twitter for tweets that include comments about current movies.
* These comments are turned into ratings that are made part of the input to the program.
* In order to use these ratings, i had to get them, parse them, and write a program to determine wich movies someone should watch.
* Rather than Twitflicks, I used another Twitter based source of data called Rotten Tomatoes.
* Also, the Engine of the Recommendation Systems is capable of create recommendatins based on data about books, movies, restaurants, etc.
* The program have access to a large number of ratings for thousands of movies.


## Movie POJO

* Movie.java mirrors CSV file for data
  * One line per movie in .csv file
  * IMDB identifier, title, year, country, genre, director, minutes, IMDB poster-image-URL
* Plaint Old Java Object (POJO)
  * We use POJO class we are created, to store data for each movie.
  * Once a movie object is created it doesn't change.
* Read data with FileResource, CSVParser, CSVRecord

## Rater Data and Class
* CSV file raings.csv stores movie ratings
  * Each line in the CSV file stores data for one rating, that is one rater on Twitter writing about a specific movie.
  * Rater ID, Movie ID, Rating, Time of Rating
* From Movie ID we get all movie data
  * Stored when reading movie CSV file
* The Rater class supports several operations
  * Determinate... Does this rater have rating for movie 2883512? method hasRating()
  * What is rating for movie 2883512?
  * Add rating 8 for 2883152
  * Get IDs for all movies rated, see Rater.java
  
## Summarize Reading and Storing Data
* Use Movie.java, Rater.java and Rating.java to read CSV files create ArrayLists
  * Rater.java stores Rating data for one rater
  * Each Rating contains movie ID and rating
* Movie.java and Rating.java are POJOs
  * Create and access data via getter methods
* Rater.java supports queries about what movies are rated
