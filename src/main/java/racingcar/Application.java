package racingcar;

import racingcar.controller.RacingCarGameController;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController controller = new RacingCarGameController();

        controller.play();
    }
}
