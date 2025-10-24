package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름으로 빈 문자열 입력 시 예외 발생")
    void inputEmptyCarName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수가 자연수가 아닐 경우 예외 발생")
    void inputTryCount() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("java,code", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수가 빈 문자열일 경우 예외 발생")
    void inputEmptyTryCount() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("java,code", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("차 이름이 공백을 포함하고 있을 경우 예외 발생")
    void ContainSpaceCarName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ja va,code", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("차 이름이 중복될 경우 예외 발생")
    void conflictCarName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("java,java", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("차 이름이 5자 이상일 경우 예외 발생")
    void tooLongCarName() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("sumin,java", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
