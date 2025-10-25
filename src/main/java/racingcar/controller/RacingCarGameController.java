package racingcar.controller;

import static java.util.stream.Collectors.toSet;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Set;
import racingcar.controller.validator.CarNameValidator;
import racingcar.controller.validator.TryCountValidator;
import racingcar.model.Car;
import racingcar.view.input.InputView;

public class RacingCarGameController {

    private static final String COMMA = ",";
    private static final int BASE_POSITION = 0;

    public void play() {
        String carNameInput = getCarNames();
        String tryCountInput = getTryCount();

        CarNameValidator.validateCarNames(carNameInput);
        TryCountValidator.validateTryCount(tryCountInput);

        Set<Car> carSet = collectToSet(carNameInput);

        int tryCount = Integer.parseInt(tryCountInput);

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

    private Set<Car> collectToSet(String carNameInput) {
        return Arrays.stream(
                        carNameInput.split(COMMA)
                )
                .map(carName -> new Car(carName, BASE_POSITION))
                .collect(toSet());
    }
}

