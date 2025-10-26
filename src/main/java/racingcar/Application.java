package racingcar;

import java.util.List;
import racingcar.controller.CarController;
import racingcar.controller.GameController;
import racingcar.model.Car;

public class Application {
    public static void main(String[] args) {
        CarController carController = new CarController();
        List<Car> carList = carController.generateCarList();

        GameController gameController = new GameController(carList);

        gameController.play();
    }
}
