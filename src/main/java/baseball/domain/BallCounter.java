package baseball.domain;

import static baseball.domain.PitchResult.*;

import java.util.HashMap;
import java.util.Map;

public class BallCounter {

    private static final Map<PitchResult, Integer> ballCounter = new HashMap<>();

    private BallCounter() {
    }

    public static void countBall() {
        ballCounter.put(BALL, ballCounter.getOrDefault(BALL, 0) + 1);
    }

    public static void countStrike() {
        ballCounter.put(STRIKE, ballCounter.getOrDefault(STRIKE, 0) + 1);
    }

    public static boolean isAllStrike(int digitNumber) {
        return getCountOfStrike() == digitNumber;
    }

    public static void reset() {
        ballCounter.replace(BALL, 0);
        ballCounter.replace(STRIKE, 0);
    }

    public static int getCountOfBall() {
        return ballCounter.getOrDefault(BALL, 0);
    }

    public static int getCountOfStrike() {
        return ballCounter.getOrDefault(STRIKE, 0);
    }
}
