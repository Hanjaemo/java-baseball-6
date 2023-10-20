package baseball.view;

public class OutputView {

    public static void printBeginningMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printBallCountResult(int countOfBall, int countOfStrike) {
        if (countOfBall == 0 && countOfStrike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (countOfStrike == 0) {
            System.out.println(countOfBall + "볼");
            return;
        }
        if (countOfBall == 0) {
            System.out.println(countOfStrike + "스트라이크");
            return;
        }
        System.out.println(countOfBall + "볼 " + countOfStrike + "스트라이크");
    }

    public static void printEndingMessageForAllStrike(int digitNumber) {
        System.out.println(digitNumber + "스트라이크\n" +
                digitNumber + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}