package racingcar.strategy;

import java.util.List;
import racingcar.model.Car;

public interface WinnerStrategy{
    List<Car> findWinner(List<Car> cars);
}
