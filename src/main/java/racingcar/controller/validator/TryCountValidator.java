package racingcar.controller.validator;

public class TryCountValidator {

    private static final int MINIMUM_TRYCOUNT = 1;

    public static void validateTryCount(String tryCountInput) {
        validateTryCountIsEmpty(tryCountInput);
        validateTryCountFormat(tryCountInput);
    }

    private static void validateTryCountIsEmpty(String tryCountInput) {
        if (tryCountInput.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수가 비어있음");
        }
    }

    private static void validateTryCountFormat(String tryCountInput) {
        try {
            validateMinimumTryCount(tryCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다");
        }
    }

    private static void validateMinimumTryCount(String tryCountInput) {
        int tryCount = Integer.parseInt(tryCountInput);

        if (tryCount < MINIMUM_TRYCOUNT) {
            throw new IllegalArgumentException("최소 시도횟수는 1번");
        }
    }
}
