package racingcar.controller.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountValidatorTest {

    @Test
    @DisplayName("시도 횟수 입력이 비어있을 경우 예외 발생")
    void validateEmptyTryCountTest() {
        assertThatThrownBy(() ->
                TryCountValidator.validateTryCount(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 최소 시도 횟수보다 작을 경우 예외 발생")
    void validateBelowMinimumTest() {
        assertThatThrownBy(() ->
                TryCountValidator.validateTryCount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닐 경우 예외 발생")
    void validateInvalidNumberFormatTest() {
        assertThatThrownBy(() ->
                TryCountValidator.validateTryCount("asdf"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}