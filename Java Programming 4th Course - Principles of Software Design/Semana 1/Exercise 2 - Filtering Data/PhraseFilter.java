
public class PhraseFilter implements Filter {
    private String request; // "start", "end", or "any"
    private String phrase;

    public PhraseFilter(String request, String phrase) {
        this.request = request;
        this.phrase = phrase;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        if (request.equals("start")) {
            return qe.getInfo().startsWith(phrase);
        } else if (request.equals("end")) {
            return qe.getInfo().endsWith(phrase);
        }
        return qe.getInfo().contains(phrase);
    }

    @Override
    public String getName() {
        return "Phrase Filter";
    }
}
