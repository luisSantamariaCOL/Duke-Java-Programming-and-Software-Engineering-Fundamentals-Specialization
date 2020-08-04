import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {

    @Override
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        String q1Line = q1.getInfo();
        String lastWordQ1 = q1Line.substring(q1Line.lastIndexOf(" ")+1);
        String q2Line = q2.getInfo();
        String lastWordQ2 = q2Line.substring(q2Line.lastIndexOf(" ")+1);
        int compareResult = lastWordQ1.compareTo(lastWordQ2);

        if (compareResult == 0) {
            return Double.compare(q1.getMagnitude(), q2.getMagnitude());
        }
        return compareResult;
    }


}
