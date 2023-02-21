package domain;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int move(int index) {
        int currentIndex = index;

        for (Line line : lines) {
            currentIndex = line.move(currentIndex);
        }

        return currentIndex;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
