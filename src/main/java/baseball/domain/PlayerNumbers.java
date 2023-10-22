package baseball.domain;

import java.util.List;

public class PlayerNumbers {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final List<Integer> numbers;

    public PlayerNumbers(List<Integer> numbers, int digitNumber) {
        validateNumbers(numbers, digitNumber);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers, int digitNumber) {
        if (invalidDigitNumber(numbers, digitNumber)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 " + digitNumber + "자리여야 합니다.");
        }
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 1 이상 9 이하여야 합니다.");
        }
        for (int indexOfCurrentNumber = 0; indexOfCurrentNumber < numbers.size(); indexOfCurrentNumber++) {
            List<Integer> remainingNumbers = numbers.subList(indexOfCurrentNumber + 1, numbers.size());
            if (remainingNumbers.contains(numbers.get(indexOfCurrentNumber))) {
                throw new IllegalArgumentException("[ERROR] 숫자는 서로 달라야 합니다.");
            }
        }
    }

    private boolean invalidDigitNumber(List<Integer> numbers, int digitNumber) {
        return numbers.size() != digitNumber;
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> !(MIN_NUMBER <= number && number <= MAX_NUMBER));
    }

    public void checkForBallCount(ComputerNumbers computerNumbers, int digitNumber) {
        for (int indexOfPlayerNumber = 0; indexOfPlayerNumber < digitNumber; indexOfPlayerNumber++) {
            computerNumbers.compare(numbers.get(indexOfPlayerNumber), indexOfPlayerNumber);
        }
    }
}
