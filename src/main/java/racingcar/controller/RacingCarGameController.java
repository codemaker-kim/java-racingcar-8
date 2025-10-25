package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.controller.validator.CarNameValidator;
import racingcar.controller.validator.TryCountValidator;
import racingcar.view.input.InputView;

public class RacingCarGameController {

    private static final String COMMA = ",";

    public void play() {
        String carNames = getCarNames();
        String tryCount = getTryCount();

        CarNameValidator.validateCarNameIsEmpty(carNames);

        List<String> carNameList = Arrays.stream(
                carNames.split(COMMA)
        ).toList();

        CarNameValidator.validateCarNames(carNameList);
        TryCountValidator.validateTryCount(tryCount);

        // 2. 리스트를 순회하며 이름을 가진 객체 Car를 생성
        // 3. 순회하며 accelerate 메서드 실행
        // 4. OutputView 기반 출력
    }

    private String getTryCount() {
        InputView.printTryCountPrompt();

        return Console.readLine();
    }

    private String getCarNames() {
        InputView.printCarNamePrompt();

        return Console.readLine();
    }
}

