package racingcar.model;

import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = List.copyOf(carList);
    }

    public void accelerateAll() {
        carList.forEach(Car::accelerate);
    }

    public List<Car> getCarList() {
        return List.copyOf(carList);
    }
}
