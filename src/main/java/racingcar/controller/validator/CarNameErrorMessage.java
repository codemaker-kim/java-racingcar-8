package racingcar.controller.validator;

public enum CarNameErrorMessage {
    EMPTY_CAR_NAME("자동차 명이 비어있음"),
    CONTAINS_SPACE("자동차 명에 공백 포함"),
    DUPLICATE_NAME("중복 값 존재"),
    TOO_LONG_NAME("자동차 명은 5자 이하만 가능");

    private final String message;

    CarNameErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
