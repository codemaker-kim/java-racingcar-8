package racingcar.controller;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import racingcar.controller.dto.CarListDto;
import racingcar.controller.validator.CarNameValidator;
import racingcar.model.Car;
import racingcar.model.RacingCar;
import racingcar.view.input.InputView;

public class CarController {

    private static final String COMMA = ",";
    private static final int BASE_POSITION = 0;

    public CarListDto generateCarList() {
        String carNameInput = InputView.inputCarNames();
        CarNameValidator.validateCarNames(carNameInput);

        return new CarListDto(collectToList(carNameInput));
    }

    private List<Car> collectToList(String carNameInput) {
        return Arrays.stream(
                        carNameInput.split(COMMA)
                )
                .map(carName -> new RacingCar(carName, BASE_POSITION))
                .collect(toList());
    }
}
