import java.util.ArrayList;

public class MatchAllFilter implements Filter {
    private ArrayList<Filter> filters;

    public MatchAllFilter() {
        filters = new ArrayList<>();
    }

    public void addFilter(Filter f){
        filters.add(f);
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        for (Filter f : filters) {
            if (!f.satisfies(qe)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        StringBuilder sb = new StringBuilder();
        for (Filter f: filters) {
            sb.append(f.getName()+"\n");
        }
        return sb.toString();
    }
}
