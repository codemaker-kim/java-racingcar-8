package racingcar.strategy;

import static java.math.BigDecimal.ZERO;
import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.model.Car;

public class RacingCarWinnerStrategy implements WinnerStrategy {

    @Override
    public List<Car> findWinner(List<Car> cars) {
        int maxPosition = getMaxPosition(List.copyOf(cars));

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(
                        ZERO.intValue()
                );
    }
}
