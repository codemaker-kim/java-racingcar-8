package racingcar.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.controller.validator.TryCountValidator;
import racingcar.model.Car;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class GameController {

    private static final int BASE_POSITION = 0;
    private final List<Car> carList;

    public GameController(List<Car> carList) {
        this.carList = carList;
    }

    public void play() {
        String tryCountInput = InputView.inputTryCount();
        TryCountValidator.validateTryCount(tryCountInput);

        int tryCount = Integer.parseInt(tryCountInput);

        runGame(tryCount);

        List<Car> winners = findWinners();
        OutputView.printWinners(winners);
    }

    private void runGame(int tryCount) {
        OutputView.printResultPrompt();

        for (int round = BASE_POSITION; round < tryCount; round++) {
            carList.forEach(Car::accelerate);
            OutputView.printRoundResult(carList);
        }
    }

    private List<Car> findWinners() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(BASE_POSITION);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(toList());
    }
}

