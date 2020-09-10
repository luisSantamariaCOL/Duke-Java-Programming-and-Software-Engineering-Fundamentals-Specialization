package src;

public class DirectorsFilter implements Filter {
    private String directors;

    public DirectorsFilter(String directors) {
        this.directors = directors;
    }

    @Override
    public boolean satisfies(String id) {
        String directorsOfMovie = MovieDatabase.getDirector(id);
        String[] directorsList = directors.trim().split(",");
        for (String director : directorsList) {
            if (directorsOfMovie.contains(director)) { return true; }
        }
        return false;
    }
}
