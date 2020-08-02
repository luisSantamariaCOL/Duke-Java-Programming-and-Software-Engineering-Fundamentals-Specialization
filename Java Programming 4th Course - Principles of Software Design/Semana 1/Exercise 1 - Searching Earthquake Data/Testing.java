public class Testing {

    public static void main(String[] args) {
        Testing testing = new Testing();
        testing.testLargestQuakesFindLargestQuakes();
    }

    public void testEarthQuakeClientCreateCSV() {
        EarthQuakeClient earthQuakeClient = new EarthQuakeClient();
        earthQuakeClient.createCSV();
    }

    public void testEarthQuakeClientBigQuakes() {
        EarthQuakeClient earthQuakeClient = new EarthQuakeClient();
        earthQuakeClient.bigQuakes();
    }

    public void testEarthQuakeClientCloseToMe() {
        EarthQuakeClient earthQuakeClient = new EarthQuakeClient();
        earthQuakeClient.closeToMe();
    }

    public void testEarthQuakeClientQuakesOfDepth() {
        EarthQuakeClient earthQuakeClient = new EarthQuakeClient();
        earthQuakeClient.quakesOfDepth();
    }

    public void testEarthQuakeClientQuakesByPhrase() {
        EarthQuakeClient earthQuakeClient = new EarthQuakeClient();
        earthQuakeClient.quakesByPhrase();
    }

    public void testClosestQuakesGetClosest() {
        ClosestQuakes cq = new ClosestQuakes();
        cq.findClosestQuakes();
    }

    public void testLargestQuakesFindLargestQuakes() {
        LargestQuakes lq = new LargestQuakes();
        lq.findLargestQuakes();
    }
}
