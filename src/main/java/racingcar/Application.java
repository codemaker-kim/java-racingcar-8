package racingcar;

import racingcar.controller.CarController;
import racingcar.controller.GameController;
import racingcar.controller.dto.CarListDto;
import racingcar.model.Cars;
import racingcar.strategy.RacingCarWinnerStrategy;

public class Application {
    public static void main(String[] args) {
        CarController carController = new CarController();
        CarListDto carListDto = carController.generateCarList();

        GameController gameController = new GameController(
                new Cars(carListDto.carList()),
                new RacingCarWinnerStrategy()
        );

        gameController.play();
    }
}
