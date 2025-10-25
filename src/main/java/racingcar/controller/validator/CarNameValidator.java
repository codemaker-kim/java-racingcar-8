package racingcar.controller.validator;

import java.util.List;

public class CarNameValidator {

    private static final String SPACE = " ";
    private static final int MAXIMUM_CARNAME_LENGTH = 5;

    public static void validateCarNameIsEmpty(String carNameInput) {
        if (carNameInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 명이 비어있음");
        }
    }

    public static void validateCarNames(List<String> carNameList) {
        validateCarNamesHaveNoSpaces(carNameList);

        validateCarNamesAreUnique(carNameList);

        validateCarNamesTooLong(carNameList);
    }

    private static void validateCarNamesHaveNoSpaces(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.contains(SPACE)) {
                throw new IllegalArgumentException("자동차 명에 공백 포함");
            }
        }
    }

    private static void validateCarNamesAreUnique(List<String> carNameList) {
        long distinctCount = carNameList.stream()
                .distinct()
                .count();

        if (carNameList.size() != distinctCount) {
            throw new IllegalArgumentException("중복 값 존재");
        }
    }

    private static void validateCarNamesTooLong(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > MAXIMUM_CARNAME_LENGTH) {
                throw new IllegalArgumentException("자동차 명은 5자 이하만 가능");
            }
        }
    }
}
