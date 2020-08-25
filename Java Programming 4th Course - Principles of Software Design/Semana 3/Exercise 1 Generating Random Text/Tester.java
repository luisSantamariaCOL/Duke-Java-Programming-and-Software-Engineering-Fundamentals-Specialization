import edu.duke.FileResource;

public class Tester {
    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.testMarkovRunner();
    }

    public void testGetFollows() {
        MarkovOne markovOne = new MarkovOne();
        String trainingText = "this is a test yes this is a test.";
        markovOne.setTraining(trainingText);
        System.out.println(markovOne.getFollows("es"));
    }

    public void testGetFollowsWithFile() {
        FileResource fr = new FileResource();
        String trainingText = fr.asString();
        trainingText = trainingText.replace('\n', ' ');
        MarkovOne markovOne = new MarkovOne();
        markovOne.setTraining(trainingText);
        System.out.println(markovOne.getFollows("th").size());
    }

    public void testMarkovRunner() {
        MarkovRunner markovRunner = new MarkovRunner();
        // markovRunner.runMarkovFour();
        // markovRunner.runMarkovZero();
        // markovRunner.runMarkovOne();
        markovRunner.runMarkovModel();
    }
}
