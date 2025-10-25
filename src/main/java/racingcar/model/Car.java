package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void accelerate() {
        if (Randoms.pickNumberInRange(0, 9) >= 4)
            position++;
    }
}
