package racingcar;

import racingcar.controller.CarController;
import racingcar.controller.GameController;
import racingcar.controller.dto.CarListDto;

public class Application {
    public static void main(String[] args) {
        CarController carController = new CarController();
        CarListDto carListDto = carController.generateCarList();

        GameController gameController = new GameController(carListDto.carList());

        gameController.play();
    }
}
