package view;

import java.util.List;

import domain.Ladder;
import domain.Line;
import domain.Player;
import domain.Players;
import domain.Point;
import domain.Result;
import domain.Results;

public class OutputView {

    private static final String BLANK = " ";
    private static final String DIVIDER = "|";
    private static final String LINE_START_FORMAT = "    ";
    private static final String NAME_START_FORMAT = "  ";
    private static final String CONNECTED = "-----";
    private static final String DISCONNECTED = "     ";
    private static final String RESULT_FORMAT = "%s : %s%n";
    private static final int DIVISOR = 2;
    private static final int DEFAULT_PADDING = 2;
    private static final int FLAG = 1;

    public static void printPlayers(final Players players) {
        System.out.print(NAME_START_FORMAT);

        players.getPlayers()
                .stream()
                .map(Player::getName)
                .forEach(OutputView::printName);

        System.out.println();
    }

    private static void printName(final String name) {
        String alignedName = alignCenter(name);

        System.out.print(alignedName + BLANK);
    }

    private static String alignCenter(final String name) {
        int length = name.length();

        int leftPadding = DEFAULT_PADDING - length / DIVISOR;
        int rightPadding = DEFAULT_PADDING - (length - FLAG) / DIVISOR;

        return BLANK.repeat(leftPadding) + name + BLANK.repeat(rightPadding);
    }

    public static void printLadder(final Ladder ladder) {
        ladder.getLines()
                .forEach(OutputView::printLine);
    }

    private static void printLine(final Line line) {
        List<Point> points = line.getPoints();

        StringBuilder result = new StringBuilder(LINE_START_FORMAT + DIVIDER);
        for (Point point : points) {
            result.append(toStatus(point));
        }

        System.out.println(result);
    }

    private static String toStatus(final Point point) {
        if (point.isConnected()) {
            return CONNECTED + DIVIDER;
        }

        return DISCONNECTED + DIVIDER;
    }

    public static void printResults(final Results results) {
        for (Result result : results.getResults()) {
            System.out.printf(RESULT_FORMAT, result.getPlayerName(), result.getRewardName());
        }
    }

    public static void printResult(final Result result) {
        System.out.println(result.getRewardName());
    }
}
