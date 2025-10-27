package racingcar.controller.validator;

public enum CarNameErrorMessage {
    EMPTY_CAR_NAME("자동차 이름 입력이 비어있습니다."),
    CONTAINS_SPACE("자동차 이름에 공백이 포함되어 있습니다."),
    DUPLICATE_NAME("자동차 이름이 중복됩니다."),
    TOO_LONG_NAME("자동차 명은 5자 이하만 가능합니다.");

    private final String message;

    CarNameErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
