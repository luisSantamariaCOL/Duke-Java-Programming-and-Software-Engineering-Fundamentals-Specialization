import java.util.*;

public class LargestQuakes {

    public int indexOfLargest(ArrayList<QuakeEntry> quakeData) {
        double largestMagnitude = 0;
        int index = 0;
        for (int k = 0; k < quakeData.size(); k++) {
            double currentMagnitude = quakeData.get(k).getMagnitude();
            if (currentMagnitude > largestMagnitude) {
                index = k;
                largestMagnitude = currentMagnitude;
            }
        }
        return index;
    }

    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        ArrayList<QuakeEntry> copy = new ArrayList<>(quakeData);
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for (int j = 0; j < howMany; j++) {
            if (copy.size() == 0) break;
            int largestIdx = indexOfLargest(copy);
            QuakeEntry largestQE = copy.get(largestIdx);
            answer.add(largestQE);
            copy.remove(largestIdx);
        }
        return answer;
    }

    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        // String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        // System.out.println("All earthquakes: ");
        ArrayList<QuakeEntry> largest = getLargest(list, 5);
        for (QuakeEntry qe : largest) {
            System.out.println(qe);
        }
        int largestIdx = indexOfLargest(list);
        System.out.println("Index location of the largest magnitude: " + largestIdx
                + " with magnitude " + list.get(largestIdx).getMagnitude());
        System.out.println(list.size() + " Earthquakes that were from the source.");
    }
}
