package racingcar.controller.validator;

import java.util.Arrays;
import java.util.List;

public class CarNameValidator {

    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final int MAXIMUM_CARNAME_LENGTH = 5;

    public static void validateCarNames(String carNameInput) {
        validateCarNameIsEmpty(carNameInput);

        validateCarNamesHaveNoSpaces(carNameInput);

        validateCarNamesAreUnique(carNameInput);

        validateCarNamesTooLong(carNameInput);
    }

    private static void validateCarNameIsEmpty(String carNameInput) {
        if (carNameInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 명이 비어있음");
        }
    }

    private static void validateCarNamesHaveNoSpaces(String carNameInput) {
        Arrays.stream(
                        carNameInput.split(COMMA)
                )
                .filter(
                        carName -> carName.contains(SPACE)
                )
                .findFirst()
                .ifPresent(carName -> {
                    throw new IllegalArgumentException("자동차 명에 공백 포함");
                });
    }

    private static void validateCarNamesAreUnique(String carNameInput) {
        List<String> carNameList = Arrays.asList(carNameInput.split(COMMA));
        long distinctCount = carNameList.stream()
                .distinct()
                .count();

        if (carNameList.size() != distinctCount) {
            throw new IllegalArgumentException("중복 값 존재");
        }
    }

    private static void validateCarNamesTooLong(String carNameInput) {
        Arrays.stream(
                        carNameInput.split(COMMA)
                )
                .filter(
                        carName -> carName.length() > MAXIMUM_CARNAME_LENGTH
                )
                .findFirst()
                .ifPresent(carName -> {
                    throw new IllegalArgumentException("자동차 명은 5자 이하만 가능");
                });
    }
}
