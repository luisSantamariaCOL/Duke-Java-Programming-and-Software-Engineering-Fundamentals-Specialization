public class Testing {

    public void testEarthQuakeClientCreateCSV() {
        EarthQuakeClient earthQuakeClient = new EarthQuakeClient();
        earthQuakeClient.createCSV();
    }

    public void testEarthQuakeClientBigQuakes() {
        EarthQuakeClient earthQuakeClient = new EarthQuakeClient();
        earthQuakeClient.bigQuakes();
    }
}
