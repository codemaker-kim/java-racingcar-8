package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.controller.validator.CarNameValidator;
import racingcar.controller.validator.TryCountValidator;
import racingcar.model.Car;
import racingcar.view.input.InputView;

public class RacingCarGameController {

    private static final String COMMA = ",";
    private static final int BASE_POSITION = 0;

    public void play() {
        String carNames = getCarNames();
        String tryCountInput = getTryCount();

        CarNameValidator.validateCarNameIsEmpty(carNames);

        List<String> carNameList = Arrays.stream(
                carNames.split(COMMA)
        ).toList();

        CarNameValidator.validateCarNames(carNameList);
        TryCountValidator.validateTryCount(tryCountInput);

        int tryCount = Integer.parseInt(tryCountInput);

        Set<Car> carSet = carNameList.stream()
                .map(carName -> new Car(carName, BASE_POSITION))
                .collect(Collectors.toSet());

        for (int round = BASE_POSITION; round < tryCount; round++) {
            carSet.forEach(Car::accelerate);
        }

        // 4. OutputView 기반 출력
    }

    private String getTryCount() {
        InputView.printTryCountPrompt();

        return Console.readLine();
    }

    private String getCarNames() {
        InputView.printCarNamePrompt();

        return Console.readLine();
    }
}

