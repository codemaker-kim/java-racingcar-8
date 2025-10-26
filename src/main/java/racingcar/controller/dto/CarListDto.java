package racingcar.controller.dto;

import java.util.List;
import racingcar.model.Car;

public record CarListDto(
        List<Car> carList
) {
}
