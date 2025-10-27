package racingcar.controller.validator;

import static racingcar.controller.validator.TryCountErrorMessage.BELOW_MINIMUM;
import static racingcar.controller.validator.TryCountErrorMessage.EMPTY_TRY_COUNT;
import static racingcar.controller.validator.TryCountErrorMessage.INVALID_NUMBER_FORMAT;

public class TryCountValidator {

    private static final int MINIMUM_TRYCOUNT = 1;

    public static void validateTryCount(String tryCountInput) {
        validateTryCountIsEmpty(tryCountInput);
        validateTryCountFormat(tryCountInput);
    }

    private static void validateTryCountIsEmpty(String tryCountInput) {
        if (tryCountInput.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_TRY_COUNT.getMessage());
        }
    }

    private static void validateTryCountFormat(String tryCountInput) {
        try {
            validateMinimumTryCount(tryCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateMinimumTryCount(String tryCountInput) {
        int tryCount = Integer.parseInt(tryCountInput);

        if (tryCount < MINIMUM_TRYCOUNT) {
            throw new IllegalArgumentException(BELOW_MINIMUM.getMessage());
        }
    }
}
