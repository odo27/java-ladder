package domain;

import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(final List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }
}
