package racingcar.view.output.dto;

import racingcar.model.Car;

public record CarInfo(
        String name,
        int position
) {
    public static CarInfo from(Car car) {
        return new CarInfo(
                car.getName(),
                car.getPosition()
        );
    }
}
