package racingcar.controller;

import java.util.List;
import racingcar.controller.validator.TryCountValidator;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.strategy.WinnerStrategy;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class GameController {

    private static final int BASE_POSITION = 0;

    private final Cars cars;
    private final WinnerStrategy strategy;

    public GameController(Cars cars, WinnerStrategy strategy) {
        this.cars = cars;
        this.strategy = strategy;
    }

    public void play() {
        String tryCountInput = InputView.inputTryCount();
        TryCountValidator.validateTryCount(tryCountInput);

        int tryCount = Integer.parseInt(tryCountInput);

        runGame(tryCount);

        List<Car> winners = cars.findWinners(strategy);
        OutputView.printWinners(winners);
    }

    private void runGame(int tryCount) {
        OutputView.printResultPrompt();

        for (int round = BASE_POSITION; round < tryCount; round++) {
            cars.accelerateAll();

            OutputView.printRoundResult(
                    cars.getCarList()
            );
        }
    }
}

