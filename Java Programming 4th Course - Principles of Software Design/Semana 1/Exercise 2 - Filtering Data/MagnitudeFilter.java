
public class MagnitudeFilter implements Filter {
    private double minMag;
    private double maxMag;

    public MagnitudeFilter(double minMag, double maxMag) {
        this.minMag = minMag;
        this.maxMag = maxMag;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        return minMag <= qe.getMagnitude() && qe.getMagnitude() <= maxMag;
    }

    @Override
    public String getName() {
        return "Magnitude Filter";
    }
}
