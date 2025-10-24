package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");

        int tryCount = readTryCount();

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException();
        }

        List<String> carNameList = Arrays.stream(
                        carNames.split(",")
                ).toList();
    }

    private static int readTryCount() {
        try {
            int tryCount = Integer.parseInt(Console.readLine());

            if (tryCount < 1) {
                throw new IllegalArgumentException();
            }

            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
