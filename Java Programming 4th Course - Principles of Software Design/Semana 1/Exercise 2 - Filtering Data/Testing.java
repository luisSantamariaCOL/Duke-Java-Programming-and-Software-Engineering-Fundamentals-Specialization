public class Testing {

    public static void main(String[] args) {
        Testing testing = new Testing();
        EarthQuakeClient2 eqc = new EarthQuakeClient2();
        // eqc.testMatchAllFilter2();
        testing.testQuakesWithFilter();
    }

    public void testQuakesWithFilter(){
        EarthQuakeClient2 eqc = new EarthQuakeClient2();
        eqc.quakesWithFilter();
    }


}
