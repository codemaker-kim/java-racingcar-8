package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar extends Car {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int ACCELERATION_THRESHOLD = 4;

    public RacingCar(String name, int position) {
        super(name, position);
    }

    @Override
    public void accelerate() {
        if (Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX) >= ACCELERATION_THRESHOLD) {
            position++;
        }
    }
}
