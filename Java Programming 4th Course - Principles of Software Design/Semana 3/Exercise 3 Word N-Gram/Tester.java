public class Tester {
    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.testMarkovRunner();
//        tester.testMarkovWordOne();
    }

    public void testMarkovRunner() {
        MarkovRunner mr = new MarkovRunner();
//        mr.runMarkov();
//        mr.testGetFollows();
        mr.runMarkovTwo();
    }

    public void testMarkovWordOne() {
        MarkovWordOne mwo = new MarkovWordOne();
        mwo.testIndexOf();
    }
}
