package racingcar.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.controller.validator.TryCountValidator;
import racingcar.model.Car;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingCarGameController {

    private static final int BASE_POSITION = 0;
    private final List<Car> carList;

    public RacingCarGameController(List<Car> carList) {
        this.carList = carList;
    }

    public void play() {
        String tryCountInput = InputView.inputTryCount();
        TryCountValidator.validateTryCount(tryCountInput);

        int tryCount = Integer.parseInt(tryCountInput);

        OutputView.printResultPrompt();

        for (int round = BASE_POSITION; round < tryCount; round++) {
            carList.forEach(Car::accelerate);
            OutputView.printRoundResult(carList);
        }

        List<Car> winners = findWinners(carList);
        OutputView.printWinners(winners);
    }

    private List<Car> findWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(BASE_POSITION);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(toList());
    }
}

