package racingcar.view.output.dto;

import java.util.List;
import racingcar.model.Car;

public record CarInfoListDto(
        List<CarInfo> carInfoList
) {
    public static CarInfoListDto from(List<Car> carList) {
        List<CarInfo> carInfoList = carList.stream()
                .map(CarInfo::from)
                .toList();

        return new CarInfoListDto(carInfoList);
    }
}
