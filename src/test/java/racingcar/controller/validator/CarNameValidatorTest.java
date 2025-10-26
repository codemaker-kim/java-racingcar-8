package racingcar.controller.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    @Test
    @DisplayName("자동차 입력이 비어있을 때 예외 발생")
    void carNameInputEmptyTest() {
        assertThatThrownBy(() ->
                CarNameValidator.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 리스트에 공백이 포함된 이름이 있을 경우 예외 발생")
    void carNameHasSpace() {
        assertThatThrownBy(() ->
                CarNameValidator.validateCarNames("t tt"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 리스트에 중복이 있을 경우 예외 발생")
    void carNameConflict() {
        assertThatThrownBy(() ->
                CarNameValidator.validateCarNames("test,test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 리스트 중에 5자 초과인 이름이 있을 경우 예외 발생")
    void carNameOverMaximumSizeTest() {
        assertThatThrownBy(() ->
                CarNameValidator.validateCarNames("fortest,sumin,java"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}