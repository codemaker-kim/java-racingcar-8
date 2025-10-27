package racingcar.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingCar;

class MaxPositionWinnerStrategyTest {

    private WinnerStrategy winnerStrategy;

    @BeforeEach
    void setUp() {
        winnerStrategy = new MaxPositionWinnerStrategy();
    }

    @Test
    @DisplayName("승자만이 포함된 리스트만을 올바르게 반환한다.")
    void findWinnerTest() {
        //given
        final List<Car> carList = List.of(
                new RacingCar("sumin", 3),
                new RacingCar("java", 4),
                new RacingCar("jigi", 5),
                new RacingCar("gg", 5)
        );
        Cars cars = new Cars(carList);

        //when
        List<Car> winners = cars.findWinners(winnerStrategy);

        //then
        assertThat(winners)
                .hasSize(2)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("jigi", "gg");
    }
}