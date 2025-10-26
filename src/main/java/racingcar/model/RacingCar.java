package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar extends Car {

    public RacingCar(String name, int position) {
        super(name, position);
    }

    @Override
    public void accelerate() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }
}
