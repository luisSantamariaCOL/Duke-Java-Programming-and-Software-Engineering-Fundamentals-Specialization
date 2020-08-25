public class Testing {

    public void testEarthQuakeClientCreateCSV() {
        EarthQuakeClient earthQuakeClient = new EarthQuakeClient();
        earthQuakeClient.closeToMe();
    }

    public void testEarthQuakeClientBigQuakes() {
        EarthQuakeClient earthQuakeClient = new EarthQuakeClient();
        earthQuakeClient.bigQuakes();
    }

    public void testEarthQuakeClientCloseToMe() {
        EarthQuakeClient earthQuakeClient = new EarthQuakeClient();
        earthQuakeClient.closeToMe();
    }
}
