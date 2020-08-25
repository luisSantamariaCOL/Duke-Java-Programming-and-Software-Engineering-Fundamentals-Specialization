
public class DistanceFilter implements Filter {
    private Location location;
    private float maxDistance;

    public DistanceFilter(Location location, float maxDistance) {
        this.location = location;
        this.maxDistance = maxDistance;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        return qe.getLocation().distanceTo(location) <= maxDistance;
    }

    @Override
    public String getName() {
        return "Distance Filter";
    }
}
