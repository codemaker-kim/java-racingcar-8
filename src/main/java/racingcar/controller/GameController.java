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

        OutputView.printResultPrompt();

        for (int round = BASE_POSITION; round < tryCount; round++) {
            carList.forEach(Car::accelerate);
            OutputView.printRoundResult(carList);
        }

        List<Car> winners = findWinners(tryCount);
        OutputView.printWinners(winners);
    }

    private List<Car> findWinners(int tryCount) {
        return carList.stream()
                .filter(car -> car.getPosition() == tryCount)
                .collect(toList());
    }
}

