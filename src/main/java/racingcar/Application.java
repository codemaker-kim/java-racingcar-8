package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final int MINIMUM_TRYCOUNT = 1;
    private static final int MAXIMUM_CARNAME_LENGTH = 5;


    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");

        int tryCount = readTryCount();

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 명이 비어있음");
        }

        List<String> carNameList = Arrays.stream(
                carNames.split(COMMA)
        ).toList();

        validateCarNames(carNameList);
    }

    private static void validateCarNames(List<String> carNameList) {
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

    private static int readTryCount() {
        try {
            int tryCount = Integer.parseInt(Console.readLine());

            if (tryCount < MINIMUM_TRYCOUNT) {
                throw new IllegalArgumentException("최소 시도횟수는 1번");
            }

            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수가 비어있음");
        }
    }
}
