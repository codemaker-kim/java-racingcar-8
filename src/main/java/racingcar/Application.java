package racingcar;

import java.util.List;
import racingcar.controller.CarController;
import racingcar.controller.RacingCarGameController;
import racingcar.model.Car;

public class Application {
    public static void main(String[] args) {
        CarController carController = new CarController();
        List<Car> carList = carController.generateCarList();

        RacingCarGameController gameController = new RacingCarGameController(carList);

        gameController.play();
    }
}
