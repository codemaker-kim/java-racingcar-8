package racingcar.controller;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import racingcar.controller.validator.CarNameValidator;
import racingcar.controller.validator.TryCountValidator;
import racingcar.model.Car;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingCarGameController {

    private static final String COMMA = ",";
    private static final int BASE_POSITION = 0;

    public void play() {
        String carNameInput = InputView.inputTryCount();
        String tryCountInput = InputView.inputCarNames();

        CarNameValidator.validateCarNames(carNameInput);
        TryCountValidator.validateTryCount(tryCountInput);

        Set<Car> carSet = collectToSet(carNameInput);

        int tryCount = Integer.parseInt(tryCountInput);

        OutputView.printResultPrompt();

        for (int round = BASE_POSITION; round < tryCount; round++) {
            carSet.forEach(Car::accelerate);
            OutputView.printRoundResult(carSet);
        }

        Set<Car> winners = findWinners(carSet);
        OutputView.printWinners(winners);
    }

    private Set<Car> collectToSet(String carNameInput) {
        return Arrays.stream(
                        carNameInput.split(COMMA)
                )
                .map(carName -> new Car(carName, BASE_POSITION))
                .collect(toCollection(LinkedHashSet::new));
    }

    private Set<Car> findWinners(Set<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(BASE_POSITION);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(toCollection(LinkedHashSet::new));
    }
}

