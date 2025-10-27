package racingcar.controller.validator;

import static racingcar.controller.validator.CarNameErrorMessage.CONTAINS_SPACE;
import static racingcar.controller.validator.CarNameErrorMessage.DUPLICATE_NAME;
import static racingcar.controller.validator.CarNameErrorMessage.EMPTY_CAR_NAME;
import static racingcar.controller.validator.CarNameErrorMessage.TOO_LONG_NAME;
import static racingcar.global.Separator.COMMA;
import static racingcar.global.Separator.SPACE;

import java.util.Arrays;
import java.util.List;

public class CarNameValidator {

    private static final int MAXIMUM_CARNAME_LENGTH = 5;

    public static void validateCarNames(String carNameInput) {
        validateCarNameIsEmpty(carNameInput);

        validateCarNamesHaveNoSpaces(carNameInput);

        validateCarNamesAreUnique(carNameInput);

        validateCarNamesTooLong(carNameInput);
    }

    private static void validateCarNameIsEmpty(String carNameInput) {
        if (carNameInput.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME.getMessage());
        }
    }

    private static void validateCarNamesHaveNoSpaces(String carNameInput) {
        Arrays.stream(splitCarNameInput(carNameInput))
                .filter(CarNameValidator::isContainSpace)
                .findFirst()
                .ifPresent(carName -> {
                    throw new IllegalArgumentException(CONTAINS_SPACE.getMessage());
                });
    }

    private static void validateCarNamesAreUnique(String carNameInput) {
        List<String> carNameList = Arrays.asList(splitCarNameInput(carNameInput));
        long distinctCount = carNameList.stream()
                .distinct()
                .count();

        if (carNameList.size() != distinctCount) {
            throw new IllegalArgumentException(DUPLICATE_NAME.getMessage());
        }
    }

    private static void validateCarNamesTooLong(String carNameInput) {
        Arrays.stream(splitCarNameInput(carNameInput))
                .filter(
                        carName -> carName.length() > MAXIMUM_CARNAME_LENGTH
                )
                .findFirst()
                .ifPresent(carName -> {
                    throw new IllegalArgumentException(TOO_LONG_NAME.getMessage());
                });
    }

    private static String[] splitCarNameInput(String carNameInput) {
        return carNameInput.split(
                COMMA.getSign()
        );
    }

    private static boolean isContainSpace(String carName) {
        return carName.contains(
                SPACE.getSign()
        );
    }
}
