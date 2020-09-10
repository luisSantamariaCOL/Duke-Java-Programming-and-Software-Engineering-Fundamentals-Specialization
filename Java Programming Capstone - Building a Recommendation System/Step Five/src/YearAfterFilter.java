package src;

public class YearAfterFilter implements Filter {
    private int myYear;

    public YearAfterFilter(int year) {
        myYear = validYear(year);
    }

    @Override
    public boolean satisfies(String id) {
        return MovieDatabase.getYear(id) >= myYear;
    }

    private int validYear(int year) {
        if (year >= 1895 && year < 2021) {
            return year;
        }
        return 1985;
    }
}
