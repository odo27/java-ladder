package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final BooleanGenerator booleanGenerator;
    private final List<Point> points = new ArrayList<>();

    public Line(BooleanGenerator booleanGenerator, int personCount) {
        this.booleanGenerator = booleanGenerator;
        generatePoints(personCount);
    }

    private boolean isGenerated() {
        return booleanGenerator.generate();
    }

    private void generatePoints(int personCount) {
        for (int i = 0; i < personCount - 1; i++) {
            generatePoint();
        }
    }

    private void generatePoint() {
        if (isGenerated() && !hasAdjacentPoint()) {
            points.add(Point.CONNECTION);
            return;
        }
        points.add(Point.SEPARATION);
    }

    private boolean hasAdjacentPoint() {
        return !points.isEmpty() && points.get(points.size() - 1).isConnection();
    }

    public List<Point> getPoints() {
        return points;
    }
}
