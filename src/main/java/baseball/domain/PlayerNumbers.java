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
        throwExceptionIfInvalidDigitNumber(numbers, digitNumber);
        throwExceptionIfContainsNumberOutOfRange(numbers);
        throwExceptionIfDuplicatedNumber(numbers);
    }

    private void throwExceptionIfInvalidDigitNumber(List<Integer> numbers, int digitNumber) {
        if (invalidDigitNumber(numbers, digitNumber)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 " + digitNumber + "자리여야 합니다.");
        }
    }

    private boolean invalidDigitNumber(List<Integer> numbers, int digitNumber) {
        return numbers.size() != digitNumber;
    }

    private void throwExceptionIfContainsNumberOutOfRange(List<Integer> numbers) {
        if (containsNumberOutOfRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 " + MIN_NUMBER + " 이상 " + MAX_NUMBER + " 이하여야 합니다.");
        }
    }

    private boolean containsNumberOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(int number) {
        return !(MIN_NUMBER <= number && number <= MAX_NUMBER);
    }

    private void throwExceptionIfDuplicatedNumber(List<Integer> numbers) {
        for (int indexOfCurrentNumber = 0; indexOfCurrentNumber < numbers.size(); indexOfCurrentNumber++) {
            List<Integer> remainingNumbers = numbers.subList(indexOfCurrentNumber + 1, numbers.size());
            if (remainingNumbers.contains(numbers.get(indexOfCurrentNumber))) {
                throw new IllegalArgumentException("[ERROR] 숫자는 서로 달라야 합니다.");
            }
        }
    }

    public void checkForBallCount(ComputerNumbers computerNumbers, int digitNumber) {
        for (int indexOfPlayerNumber = 0; indexOfPlayerNumber < digitNumber; indexOfPlayerNumber++) {
            computerNumbers.compare(numbers.get(indexOfPlayerNumber), indexOfPlayerNumber);
        }
    }
}
