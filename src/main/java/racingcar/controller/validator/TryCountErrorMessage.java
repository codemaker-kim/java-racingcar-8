package racingcar.controller.validator;

public enum TryCountErrorMessage {
    EMPTY_TRY_COUNT("시도 횟수가 비어있음"),
    INVALID_NUMBER_FORMAT("시도 횟수는 숫자여야 합니다"),
    BELOW_MINIMUM("최소 시도횟수는 1번");

    private final String message;

    TryCountErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
